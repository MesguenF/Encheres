package fr.encheres.dal;

import java.util.List;

import fr.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public ArticleVendu selectProduct(int noArticle) throws DALException;

	public ArticleVendu insertProduct(ArticleVendu art) throws DALException;

	List<ArticleVendu> selectAllProduct() throws DALException;

	public ArticleVendu deleteProduct(int noArticle) throws DALException;
	
	
	

}
