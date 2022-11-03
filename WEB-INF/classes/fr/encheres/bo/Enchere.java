package fr.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	// Variables
	private LocalDate dateEnchere;
	private int montantEnchere;
	private int NoUtilisateur;
	private int NoArticle;

	// Constructeurs
	/**
	 * 
	 */
	public Enchere() {
		super();
	}

	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param noUtilisateur
	 * @param noArticle
	 */
	public Enchere(LocalDate dateEnchere, int montantEnchere, int noUtilisateur, int noArticle) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.NoUtilisateur = noUtilisateur;
		this.NoArticle = noArticle;
	}

	// Accesseurs et mutateurs
	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return NoUtilisateur;
	}

	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		NoUtilisateur = noUtilisateur;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return NoArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		NoArticle = noArticle;
	}

	// ToString pour affichage
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", NoUtilisateur="
				+ NoUtilisateur + ", NoArticle=" + NoArticle + "]";
	}
}
