package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.encheres.bo.ArticleVendu;
import fr.encheres.dal.util.ConnectionProvider;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private static final String sqlSelectArticle 	= "select * from Articles_vendus where no_article = ?";
	private static final String sqlSelectAllArticle = "select * from Articles_vendus";
	private static final String sqlInsertArticle = "insert into Articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlDeleteArticle = "delete from Articles_vendus where no_article = ?";


	
	@Override
	public ArticleVendu selectProduct(int noArticle) throws DALException {
		System.out.print("test");
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArticleVendu art = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.prepareStatement(sqlSelectArticle);
				rqt.setInt(1, noArticle);

				rs = rqt.executeQuery();
				while (rs.next()) {
					art = new ArticleVendu( rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), 
							rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"), rs.getInt("status"));
				}
							
			} catch (SQLException e) {
				throw new DALException("select Article failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return art;
	}
	
	public List<ArticleVendu> selectAllProduct() throws DALException {
		Statement rqt = null;
		ResultSet rs = null;
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.createStatement();
				rs = rqt.executeQuery(sqlSelectAllArticle);
				ArticleVendu art = null;
				while (rs.next()) {
					art = new ArticleVendu( rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), 
							rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"), rs.getInt("status"));
					liste.add(art);
				}
			} catch (SQLException e) {
				throw new DALException("selectAllProduct failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return liste;
	}
	
	@Override
	public ArticleVendu insertProduct(ArticleVendu art) throws DALException {
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlInsertArticle, Statement.RETURN_GENERATED_KEYS);
				rqt.setString(1, art.getNomArticle());

				rqt.setString(2, art.getDescription());
				rqt.setDate(3, java.sql.Date.valueOf(art.getDateDebutEncheres()));
				rqt.setDate(4, java.sql.Date.valueOf(art.getDateFinEncheres()));
				rqt.setInt(5, art.getMiseAPrix());
				rqt.setInt(6, art.getPrixVente());
				rqt.setInt(7, art.getNoUtilisateur());
				rqt.setInt(8, art.getNoCategorie());
				rqt.setInt(9, art.getEtatVente());

								
				int nbRows = rqt.executeUpdate();
				if (nbRows > 0) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						art.setNoArticle(rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DALException("Insert coureur failed - " + art, e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + art, e1);
		}
		return art;
	}

	public ArticleVendu deleteProduct(int noArticle) throws DALException {
		
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlDeleteArticle);
				rqt.setInt(1, noArticle);
				rqt.executeUpdate();
			} catch (SQLException e) {
				e.getStackTrace();
				throw new DALException("Update coureur failed - " + noArticle + e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + noArticle + e1);
		}
		return null;
	}
}
