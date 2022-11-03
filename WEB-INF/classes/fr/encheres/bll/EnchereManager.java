package fr.encheres.bll;

import java.util.List;
import fr.encheres.bo.ArticleVendu;
import fr.encheres.bo.Categorie;
import fr.encheres.bo.Enchere;
import fr.encheres.bo.Retrait;
import fr.encheres.bo.Utilisateur;
import fr.encheres.dal.DALException;

public interface EnchereManager {

		//Partie utilisateur
		public void creerUtilisateur(Utilisateur utilisateur) throws BLLException;

		public void supprimerUtilisateur(int id) throws BLLException;
		
		public Utilisateur updateUser(Utilisateur utilisateur) throws BLLException, DALException;

		public Utilisateur selectionnerUtilisateur(int id) throws BLLException;
		
		public Utilisateur login(String pseudo, String Password);
		
		public List<Utilisateur> selectionnerTousLesUtilisateurs() throws BLLException;

		
		//Partie articleVendu
		public void creerArticleVendu(ArticleVendu articlevendu) throws BLLException;
		
		public void supprimerArticleVendu(int id) throws BLLException;

		public ArticleVendu selectionnerArticleVendu(int id) throws BLLException;

		public List<ArticleVendu> selectionnerTousLesArticleVendu() throws BLLException;
		
		
		//Partie catégorie
		public void creerCategorie(Categorie cat) throws BLLException;
		
		public Categorie selectionnerCategorie(int noCategorie) throws BLLException;
		
		public List<Categorie> selectionnerToutesLesCategories() throws BLLException;
		
		
		//Partie enchere
		public Enchere selectionnerEnchere(int noArticle, int noUtilisateur) throws BLLException;

		public Enchere creerEnchere(Enchere enc) throws BLLException;

		public List<Enchere> selectionnerToutesLesEncheres() throws BLLException;

		public Enchere supprimerEnchere(int noArticle, int noUtilisateur) throws BLLException;
		
		//Partie retrait
		public Retrait selectionnerRetrait(int noArticle) throws BLLException;

		public Retrait creerRetrait(Retrait enc) throws BLLException;

		public List<Retrait> selectionnerTousLesRetraits() throws BLLException;

		public Retrait supprimerRetrait(int noArticle) throws BLLException;
}