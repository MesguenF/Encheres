package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.encheres.bo.Enchere;
import fr.encheres.dal.util.ConnectionProvider;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String sqlSelectEnchere 	= "select * from Encheres where no_article = ? and no_utilisateur = ?";
	private static final String sqlSelectAllEnchere = "select * from Encheres";
	private static final String sqlInsertEnchere = "insert into Encheres (no_utilisateur, no_article, date_enchere, montant_enchere) values (?, ?, ?, ?)";
	private static final String sqlDeleteEnchere = "delete from Encheres where no_article = ? and no_utilisateur = ?";


	
	@Override
	public Enchere selectEnchere(int noArticle, int noUtilisateur) throws DALException {
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Enchere enc = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.prepareStatement(sqlSelectEnchere);
				rqt.setInt(1, noArticle);
				rqt.setInt(2, noUtilisateur);

				rs = rqt.executeQuery();
				while (rs.next()) {
					enc = new Enchere(rs.getDate("date_enchere").toLocalDate(),rs.getInt("montant_enchere"),rs.getInt("no_utilisateur"), rs.getInt("no_article"));
				}
							
			} catch (SQLException e) {
				throw new DALException("select enchere failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return enc;
	}
	
	public List<Enchere> selectAllEnchere() throws DALException {
		Statement rqt = null;
		ResultSet rs = null;
		List<Enchere> liste = new ArrayList<Enchere>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.createStatement();
				rs = rqt.executeQuery(sqlSelectAllEnchere);
				Enchere enc = null;
				while (rs.next()) {
					enc = new Enchere(rs.getDate("date_enchere").toLocalDate(),rs.getInt("montant_enchere"),rs.getInt("no_utilisateur"), rs.getInt("no_article"));
					liste.add(enc);
				}
			} catch (SQLException e) {
				throw new DALException("selectAllEnchere failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return liste;
	}
	
	@Override
	public Enchere insertEnchere(Enchere enc) throws DALException {
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlInsertEnchere, Statement.RETURN_GENERATED_KEYS);
				rqt.setInt(1, enc.getNoUtilisateur());
				rqt.setInt(2, enc.getNoArticle());
				rqt.setDate(3, java.sql.Date.valueOf(enc.getDateEnchere()));
				rqt.setInt(4,enc.getMontantEnchere());
			
				int nbRows = rqt.executeUpdate();
				if (nbRows > 0) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						enc.setNoUtilisateur(rs.getInt(1));
						enc.setNoArticle(rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DALException("Insert enchere failed - " + enc, e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + enc, e1);
		}
		return enc;
	}

	public Enchere deleteEnchere(int noArticle, int noUtilisateur) throws DALException {
		
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlDeleteEnchere);
				rqt.setInt(1, noArticle);
				rqt.setInt(2, noUtilisateur);

				rqt.executeUpdate();
			} catch (SQLException e) {
				e.getStackTrace();
				throw new DALException("delete enchere failed - " + noArticle + noUtilisateur + e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + noArticle + noUtilisateur + e1);
		}
		return null;
	}

}
