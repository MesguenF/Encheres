package fr.encheres.ihm;

import java.util.List;

import fr.encheres.bo.Categorie;

public class CategorieModel {
	private Categorie categorie;
	private List<Categorie> listecategorie;

	/**
	 * 
	 */
	public CategorieModel() {
		super();
	}
	
	/**
	 * @param categorie
	 */
	public CategorieModel(Categorie categorie) {
		super();
		this.categorie = categorie;
	}
	
	/**
	 * @param listecategorie
	 */
	public CategorieModel(List<Categorie> listecategorie) {
		super();
		this.listecategorie = listecategorie;
	}

	/**
	 * @param categorie
	 * @param listecategorie
	 */
	public CategorieModel(Categorie categorie, List<Categorie> listecategorie) {
		super();
		this.categorie = categorie;
		this.listecategorie = listecategorie;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/**
	 * @return the listecategorie
	 */
	public List<Categorie> getListecategorie() {
		return listecategorie;
	}

	/**
	 * @param listecategorie the listecategorie to set
	 */
	public void setListecategorie(List<Categorie> listecategorie) {
		this.listecategorie = listecategorie;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategorieModel [categorie=" + categorie + ", listecategorie=" + listecategorie + "]";
	}
}