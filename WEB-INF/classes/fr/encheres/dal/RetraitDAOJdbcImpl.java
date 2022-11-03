package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.encheres.bo.Retrait;
import fr.encheres.dal.util.ConnectionProvider;

public class RetraitDAOJdbcImpl implements RetraitDAO{
	
	private static final String sqlSelectRetrait 	= "select * from Retraits where no_article = ?";
	private static final String sqlSelectAllRetrait = "select * from Retraits";
	private static final String sqlInsertRetrait = "insert into Retraits (no_article, rue, code_postal, ville) values (?, ?, ?, ?)";
	private static final String sqlDeleteRetrait = "delete from Retraits where no_article = ?";


	
	@Override
	public Retrait selectRetrait(int noArticle) throws DALException {
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Retrait ret = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.prepareStatement(sqlSelectRetrait);
				rqt.setInt(1, noArticle);

				rs = rqt.executeQuery();
				while (rs.next()) {
					ret = new Retrait( rs.getInt("no_article"),rs.getString("rue"),rs.getString("code_postal"), rs.getString("ville"));
				}
							
			} catch (SQLException e) {
				throw new DALException("select Retrait failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return ret;
	}
	
	public List<Retrait> selectAllRetrait() throws DALException {
		Statement rqt = null;
		ResultSet rs = null;
		List<Retrait> liste = new ArrayList<Retrait>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.createStatement();
				rs = rqt.executeQuery(sqlSelectAllRetrait);
				Retrait ret = null;
				while (rs.next()) {
					ret = new Retrait(rs.getInt("no_article"),rs.getString("rue"),rs.getString("code_postal"), rs.getString("ville"));
					liste.add(ret);
				}
			} catch (SQLException e) {
				throw new DALException("selectAllRetrait failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return liste;
	}
	
	@Override
	public Retrait insertRetrait(Retrait ret) throws DALException {
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlInsertRetrait, Statement.RETURN_GENERATED_KEYS);
				rqt.setInt(1, ret.getNoArticle());
				rqt.setString(2, ret.getRue());
				rqt.setString(3, ret.getCodePostal());
				rqt.setString(4, ret.getVille());
								
				int nbRows = rqt.executeUpdate();
				if (nbRows > 0) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						ret.setNoArticle(rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DALException("Insert retrait failed - " + ret, e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + ret, e1);
		}
		return ret;
	}

	public Retrait deleteRetrait(int noArticle) throws DALException {
		
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlDeleteRetrait);
				rqt.setInt(1, noArticle);

				rqt.executeUpdate();
			} catch (SQLException e) {
				e.getStackTrace();
				throw new DALException("delete retrait failed - " + noArticle + e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + noArticle + e1);
		}
		return null;
	}


}
