package fr.encheres.ihm;

import java.util.List;

import fr.encheres.bo.Utilisateur;

public class UtilisateurModel {
	
	private Utilisateur utilisateur;
	private List<Utilisateur> listeUtilisateur;

	
	public UtilisateurModel(Utilisateur utilisateur) {
		super();
		this.setUtilisateur(utilisateur);
	}
	
	public UtilisateurModel(Utilisateur utilisateur, List<Utilisateur> listeUtilisateur) {
		this.setUtilisateur(utilisateur);
		this.setListeUtilisateur(listeUtilisateur);
	}
	
	public UtilisateurModel(List<Utilisateur> listeUtilisateur) {
		this.setListeUtilisateur(listeUtilisateur);
	}
	
	public UtilisateurModel() {
		super();
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "UtilisateurModel [utilisateur=" + utilisateur + "]";
	}

	public List<Utilisateur> getListeUtilisateur() {
		return listeUtilisateur;
	}

	public void setListeUtilisateur(List<Utilisateur> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}

}