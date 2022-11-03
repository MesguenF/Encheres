package fr.encheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.encheres.bo.ArticleVendu;
import fr.encheres.bo.Categorie;
import fr.encheres.bo.Enchere;
import fr.encheres.bo.Retrait;
import fr.encheres.bo.Utilisateur;

public class testBLL {

	public static void main(String[] args) {
		// Variable pour: Un crédit initial de 100 points est alloué à la création du
		// compte.
		int CREDIT_INITIAL = 100;
		EnchereManager encheremanager = EnchereManagerSing.getInstance();

		// Partie utilisateur
		List<Utilisateur> listeutilisateur = new ArrayList<Utilisateur>();
		Utilisateur u1 = new Utilisateur("dudu", "Delon", "Alain", "adelon@laposte.net", "Allée des chênes", "75000",
				"Paris", "vedette", CREDIT_INITIAL, false, false);
		
		try {
//			encheremanager.creerUtilisateur(u1);
			System.out.println("Liste des utilisateurs avant suppression:");
			listeutilisateur = encheremanager.selectionnerTousLesUtilisateurs();
			for (Utilisateur u : listeutilisateur) {
				System.out.println(u);
			}
//			encheremanager.supprimerUtilisateur(4);
			System.out.println("Liste des utilisateurs après suppression:");
			listeutilisateur = encheremanager.selectionnerTousLesUtilisateurs();
			for (Utilisateur u : listeutilisateur) {
				System.out.println(u);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// Partie categorie
		Categorie cat1 = new Categorie("cycle");
		Categorie cat2 = new Categorie("informatique");
		Categorie cat3 = new Categorie("vêtement");
		List<Categorie> listecategorie = new ArrayList<Categorie>();

		try {
//			encheremanager.creerCategorie(cat1);
//			encheremanager.creerCategorie(cat2);
//			encheremanager.creerCategorie(cat3);
			System.out.println(encheremanager.selectionnerCategorie(1));
			System.out.println(encheremanager.selectionnerCategorie(2));
			System.out.println("Liste des catégories:");
			listecategorie = encheremanager.selectionnerToutesLesCategories();
			for (Categorie c : listecategorie) {
				System.out.println(c);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		//Partie articleVendu
//		(String nomArticle, String description, LocalDate dateDebutEncheres,LocalDate dateFinEncheres,
//		int miseAPrix, int prixVente, int noUtilisateur, int noCategorie, int status )
		ArticleVendu art1 = new ArticleVendu("vélo", "VTT", LocalDate.of(2021, 5, 1), LocalDate.of(2021, 5, 5), 10, 20, 1, 1, 0);
		ArticleVendu art2 = new ArticleVendu("informatique", "PC", LocalDate.of(2021, 5, 1), LocalDate.of(2021, 5, 5), 15, 30, 1, 3, 1);
		List<ArticleVendu> listearticlevendu = new ArrayList<ArticleVendu>();
		
		try {
//			encheremanager.creerArticleVendu(art1);
//			encheremanager.creerArticleVendu(art2);
			System.out.println(encheremanager.selectionnerArticleVendu(1));
			System.out.println(encheremanager.selectionnerArticleVendu(2));
			System.out.println("Liste des articles avant suppression:");
			listearticlevendu = encheremanager.selectionnerTousLesArticleVendu();
			for (ArticleVendu a : listearticlevendu) {
				System.out.println(a);
			}
			//encheremanager.supprimerArticleVendu(2);;
			System.out.println("Liste des articles après suppression:");
			listearticlevendu = encheremanager.selectionnerTousLesArticleVendu();
			for (ArticleVendu a : listearticlevendu) {
				System.out.println(a);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		//Partie Retrait
		Retrait ret1 = new Retrait(1, "Rue des camélias", "56100", "Lorient");
		Retrait ret2 = new Retrait(2, "Rue des peupliers", "56240", "Plouay");
		List<Retrait> listeRetrait = new ArrayList<Retrait>();
		
		try {
//			encheremanager.creerRetrait(ret1);
//			encheremanager.creerRetrait(ret2);
			System.out.println(encheremanager.selectionnerRetrait(4));
			System.out.println(encheremanager.selectionnerRetrait(5));
			System.out.println("Liste des retraits:");
			listeRetrait = encheremanager.selectionnerTousLesRetraits();
			for (Retrait r : listeRetrait) {
				System.out.println(r);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// Partie Enchere
//		(LocalDate dateEnchere, int montantEnchere, int noUtilisateur, int noArticle)
		Enchere enc1 = new Enchere(LocalDate.of(2021, 5, 1), 50, 1, 1);
		Enchere enc2 = new Enchere(LocalDate.of(2021, 5, 3), 75, 1, 2);
		List<Enchere> listeEnchere = new ArrayList<Enchere>();
		
		try {
//			encheremanager.creerEnchere(enc1);
//			encheremanager.creerEnchere(enc2);
			System.out.println(encheremanager.selectionnerEnchere(2, 1));
			System.out.println(encheremanager.selectionnerEnchere(4, 1));
			System.out.println("Liste des enchères:");
			listeEnchere = encheremanager.selectionnerToutesLesEncheres();
			for (Enchere e : listeEnchere) {
				System.out.println(e);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
}