package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.encheres.bo.Categorie;
import fr.encheres.dal.util.ConnectionProvider;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String sqlSelectCategorie 	= "select * from Categories where no_categorie = ?";
	private static final String sqlSelectAllCategorie = "select * from Categories";
	private static final String sqlInsertCategorie = "insert into Categories (libelle) values (?)";
	
	@Override
	public Categorie selectCategorie(int noCategorie) throws DALException {
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Categorie cat = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.prepareStatement(sqlSelectCategorie);
				rqt.setInt(1, noCategorie);

				rs = rqt.executeQuery();
				while (rs.next()) {
					cat = new Categorie( rs.getInt("no_categorie"), rs.getString("libelle"));
				}
							
			} catch (SQLException e) {
				throw new DALException("select categories failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return cat;
	}

	public List<Categorie> selectAllCategorie() throws DALException {
		Statement rqt = null;
		ResultSet rs = null;
		List<Categorie> liste = new ArrayList<Categorie>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.createStatement();
				rs = rqt.executeQuery(sqlSelectAllCategorie);
				Categorie cat = null;
				while (rs.next()) {
					cat = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
					liste.add(cat);
				}
			} catch (SQLException e) {
				throw new DALException("selectAllCategorie failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return liste;
	}
	
	@Override
	public Categorie insertCategorie(Categorie cat) throws DALException {
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlInsertCategorie, Statement.RETURN_GENERATED_KEYS);
				rqt.setString(1, cat.getLibelle());		

								
				int nbRows = rqt.executeUpdate();
				if (nbRows > 0) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						cat.setNoCategorie(rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DALException("Insert categories failed - " + cat, e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + cat, e1);
		}
		return cat;
	}
}
