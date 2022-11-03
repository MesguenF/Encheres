package fr.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
	// Variables
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private int status;

	// Constructeurs
	/**
	 * 
	 */
	public ArticleVendu() {
		super();
	}

	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
		LocalDate dateFinEncheres, int miseAPrix, int prixVente, int noUtilisateur, int noCategorie, int status ) {
			super();
			this.noArticle = noArticle;
			this.nomArticle = nomArticle;
			this.description = description;
			this.dateDebutEncheres = dateDebutEncheres;
			this.dateFinEncheres = dateFinEncheres;
			this.miseAPrix = miseAPrix;
			this.prixVente = prixVente;
			this.noUtilisateur = noUtilisateur;
			this.noCategorie = noCategorie;
			this.status = status;
	}
	
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, int noUtilisateur, int noCategorie, int status ) {
				super();
				this.nomArticle = nomArticle;
				this.description = description;
				this.dateDebutEncheres = dateDebutEncheres;
				this.dateFinEncheres = dateFinEncheres;
				this.miseAPrix = miseAPrix;
				this.prixVente = prixVente;
				this.noUtilisateur = noUtilisateur;
				this.noCategorie = noCategorie;
				this.status = status;
		}

	// Accesseurs et mutateurs
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}	

	/**
	 * @return the etatVente
	 */
	public int getEtatVente() {
		return status;
	}

	/**
	 * @param etatVente the etatVente to set
	 */
	public void setEtatVente(int status) {
		this.status = status;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	//ToString pour affichage
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + ", etatVente=" + status + "]";
	}
}