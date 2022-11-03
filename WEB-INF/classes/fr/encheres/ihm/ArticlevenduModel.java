package fr.encheres.ihm;

import java.util.List;

import fr.encheres.bo.ArticleVendu;

public class ArticlevenduModel {
	private ArticleVendu articleVendu;
	private List<ArticleVendu> listearticles;

	/**
	 * 
	 */
	public ArticlevenduModel() {
		super();
	}

	/**
	 * @param articleVendu
	 */
	public ArticlevenduModel(ArticleVendu articleVendu) {
		super();
		this.articleVendu = articleVendu;
	}
	
	/**
	 * @param listearticles
	 */
	public ArticlevenduModel(List<ArticleVendu> listearticles) {
		super();
		this.listearticles = listearticles;
	}
	
	/**
	 * @param articleVendu
	 * @param listearticles
	 */
	public ArticlevenduModel(ArticleVendu articleVendu, List<ArticleVendu> listearticles) {
		super();
		this.articleVendu = articleVendu;
		this.listearticles = listearticles;
	}

	/**
	 * @return the articleVendu
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	/**
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	/**
	 * @return the listearticles
	 */
	public List<ArticleVendu> getListearticles() {
		return listearticles;
	}

	/**
	 * @param listearticles the listearticles to set
	 */
	public void setListearticles(List<ArticleVendu> listearticles) {
		this.listearticles = listearticles;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArticlevenduModel [articleVendu=" + articleVendu + ", listearticles=" + listearticles + "]";
	}
}