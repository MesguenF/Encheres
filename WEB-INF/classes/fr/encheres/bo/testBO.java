package fr.encheres.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class testBO {

	public static void main(String[] args) {
		System.out.println("---------------TEST BO---------------");
		System.out.println("-------------------------------------");
		
		//------UTILISATEURS------//
		System.out.println("------UTILISATEURS------");
		// Création utilisateurs
		Utilisateur u1 = new Utilisateur();
		Utilisateur u2 = new Utilisateur(1, "dede", "Delon", "Alain", "adelon@laposte.net", "Allée des chênes", "75000",
				"Paris", "vedette", 0, false, false);
		Utilisateur u3 = new Utilisateur(2, "gege", "Depardieu", "Gerard", "gdepardieu@laposte.net", "0152695478",
				"3, rue des vedettes", "93000", "Mantes", "star", 0, false, true);
		
		u1.setNoUtilisateur(3);
		u1.setNom("Dupont");
		u1.setPrenom("serge");
		u1.setEmail("sdupont@laposte.net");
		u1.setCredit(50);
		u1.setAdministrateur(true);
		u1.setCodePostal("56100");
		u1.setMotDePasse("doudou");
		u1.setTelephone("0297256347");
		u1.setPseudo("dudu");
		u1.setVille("Lorient");
		u1.setRue("Rue Marechal Joffre");
		u1.setActif(true);
				
		//Affichage des utilisateurs
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		listeUtilisateurs.add(u1);
		listeUtilisateurs.add(u2);
		listeUtilisateurs.add(u3);
		for (Utilisateur u : listeUtilisateurs) {
			System.out.println(u);
		}
				
		//-----ARTICLEVENDU------//
		System.out.println("------ARTICLESVENDU------");
		//Création articleVendu
		ArticleVendu art1 = new ArticleVendu();
		ArticleVendu art2 = new ArticleVendu("velo", "VTT", LocalDate.of(2021, 5, 1), LocalDate.of(2021, 5, 2), 10, 20, 1, 1, 0);
		
		art1.setDateDebutEncheres(LocalDate.of(2021, 4, 25));
		art1.setDateFinEncheres(LocalDate.of(2021, 4, 29));
		art1.setEtatVente(1);
		art1.setDescription("poussette");
		art1.setMiseAPrix(15);
		art1.setNoArticle(5);
		art1.setNomArticle("Poussette bébé");
		art1.setPrixVente(25);
		art1.setNoUtilisateur(1);
		art1.setNoCategorie(1);
		
		//Affichage des articles
		List<ArticleVendu> listeArticleVendu = new ArrayList<ArticleVendu>();
		listeArticleVendu.add(art1);
		listeArticleVendu.add(art2);
		for (ArticleVendu a : listeArticleVendu) {
			System.out.println(a);
		}
		
		//-----CATEGORIE-----//
		System.out.println("------CATEGORIES------");
		//Création catégories
		Categorie c1 = new Categorie(1,"jouet");
		Categorie c2 = new Categorie(5, "cycle");
		//Affichages des catégories
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		listeCategorie.add(c1);
		listeCategorie.add(c2);
		for (Categorie c : listeCategorie) {
			System.out.println(c);
		}
		
		//-----ENCHERE------//
		System.out.println("------ENCHERES------");
		//Création enchères
		Enchere e1 = new Enchere(LocalDate.of(2021, 4, 25),50);
		Enchere e2 = new Enchere(LocalDate.of(2021, 4, 29), 35);
		//Affichages des enchères
		List<Enchere> listeEnchere = new ArrayList<Enchere>();
		listeEnchere.add(e1);
		listeEnchere.add(e2);
		for (Enchere e : listeEnchere) {
			System.out.println(e);
		}
		
		//------RETRAIT------//
		System.out.println("------RETRAIT------");
		//Création retraits
		Retrait r1 = new Retrait("Rue des camélias", "56100", "Lorient");
		Retrait r2 = new Retrait("Rue des peupliers", "56240", "Plouay");
		//Affichages des retraits
		List<Retrait> listeRetrait = new ArrayList<Retrait>();
		listeRetrait.add(r1);
		listeRetrait.add(r2);
		for (Retrait r : listeRetrait) {
			System.out.println(r);
		}
	}
}