package fr.encheres.ihm;

import java.util.List;

import fr.encheres.bo.Enchere;

public class EnchereModel {
	private Enchere enchere;
	private List<Enchere> listeEnchere;
	
	/**
	 * 
	 */
	public EnchereModel() {
		super();
	}

	/**
	 * @param enchere
	 */
	public EnchereModel(Enchere enchere) {
		super();
		this.enchere = enchere;
	}

	/**
	 * @param enchere
	 * @param listeEnchere
	 */
	public EnchereModel(Enchere enchere, List<Enchere> listeEnchere) {
		super();
		this.enchere = enchere;
		this.listeEnchere = listeEnchere;
	}
	
	/**
	 * @return the enchere
	 */
	public Enchere getEnchere() {
		return enchere;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	/**
	 * @return the listeEnchere
	 */
	public List<Enchere> getListeEnchere() {
		return listeEnchere;
	}

	/**
	 * @param listeEnchere the listeEnchere to set
	 */
	public void setListeEnchere(List<Enchere> listeEnchere) {
		this.listeEnchere = listeEnchere;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnchereModel [enchere=" + enchere + ", listeEnchere=" + listeEnchere + "]";
	}
}