package fr.encheres.bll;

import java.util.List;

import fr.encheres.bo.ArticleVendu;
import fr.encheres.bo.Categorie;
import fr.encheres.bo.Enchere;
import fr.encheres.bo.Retrait;
import fr.encheres.bo.Utilisateur;
import fr.encheres.dal.ArticleVenduDAO;
import fr.encheres.dal.CategorieDAO;
import fr.encheres.dal.DALException;
import fr.encheres.dal.DAOFactory;
import fr.encheres.dal.EnchereDAO;
import fr.encheres.dal.RetraitDAO;
import fr.encheres.dal.UtilisateurDAO;

public class EnchereManagerImpl implements EnchereManager {
//	// Variable pour: Un crédit initial de 100 points est alloué à la création du compte.
//	private static int CREDIT_INITIAL = 100;

	//Création d'une instance UtilisateurDAO
	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	//Création d'une instance ArticleVenduDAO
	private ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
	//Création d'une instance ArticleVenduDAO
	private CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	//Création d'une instance EnchereDAO
	private EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
	//Création d'une instance RetraitDAO
	private RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();

	
	// --------------------------------------------------------------------------//
	// -----------------------------Partie utilisateur---------------------------//
	// --------------------------------------------------------------------------//
	@Override
	public void creerUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			utilisateurDAO.insertUser(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème d'ajout d'un utilisateur: " + e.getMessage());
		}
	}

	@Override
	public void supprimerUtilisateur(int id) throws BLLException {
		try {
			utilisateurDAO.deleteUser(id);
		} catch (DALException e) {
			throw new BLLException("Problème de suppression d'un utilisateur: " + e.getMessage());
		}
	}

	public Utilisateur login(String pseudo, String password) {
		
		try {
			Utilisateur a = this.utilisateurDAO.loginUser(pseudo);
			if(a != null) {
				
				if(password .equals(a.getMotDePasse())) {
					return a;
				}				
			}
			System.out.println("Coureur avant update: " + a.getPseudo());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Utilisateur updateUser(Utilisateur utilisateur) throws DALException {
		return utilisateurDAO.updateUser(utilisateur);
	}
	
	@Override
	public Utilisateur selectionnerUtilisateur(int id) throws BLLException {
		try {
			return utilisateurDAO.selectUser(id);
		} catch (DALException e) {
			throw new BLLException("Problème de sélection d'un utilisateur: " + e.getMessage());
		}
	}

	@Override
	public List<Utilisateur> selectionnerTousLesUtilisateurs() throws BLLException {
		try {
			return utilisateurDAO.selectAllUser();
		} catch (DALException e) {
			throw new BLLException("Problème de sélection des utilisateurs: " + e.getMessage());
		}
	}
	
	// --------------------------------------------------------------------------//
	// -----------------------------Partie articleVendu--------------------------//
	// --------------------------------------------------------------------------//
	@Override
	public void creerArticleVendu(ArticleVendu articlevendu) throws BLLException {
		try {
			articleVenduDAO.insertProduct(articlevendu);
		} catch (DALException e) {
			throw new BLLException("Problème d'ajout d'un article: " + e.getMessage());
		}
	}

	@Override
	public void supprimerArticleVendu(int id) throws BLLException {
		try {
			articleVenduDAO.deleteProduct(id);
		} catch (DALException e) {
			throw new BLLException("Problème de suppression d'un article: " + e.getMessage());
		}
	}

	@Override
	public ArticleVendu selectionnerArticleVendu(int id) throws BLLException {
		try {
			return articleVenduDAO.selectProduct(id);
		} catch (DALException e) {
			throw new BLLException("Problème de sélection d'un article: " + e.getMessage());
		}
	}

	@Override
	public List<ArticleVendu> selectionnerTousLesArticleVendu() throws BLLException {
		try {
			return articleVenduDAO.selectAllProduct();
		} catch (DALException e) {
			throw new BLLException("Problème de sélection des articles: " + e.getMessage());
		}
	}

	// --------------------------------------------------------------------------//
	// -----------------------------Partie categorie-----------------------------//
	// --------------------------------------------------------------------------//
	@Override
	public Categorie selectionnerCategorie(int noCategorie) throws BLLException {
		try {
			return categorieDAO.selectCategorie(noCategorie);
		} catch (DALException e) {
			throw new BLLException("Problème de sélection d'une catégorie: " + e.getMessage());
		}
	}

	@Override
	public void creerCategorie(Categorie cat) throws BLLException {
		try {
			categorieDAO.insertCategorie(cat);
		} catch (DALException e) {
			throw new BLLException("Problème de création  d'une catégorie: " + e.getMessage());
		}
	}

	@Override
	public List<Categorie> selectionnerToutesLesCategories() throws BLLException {
		try {
			return categorieDAO.selectAllCategorie();
		} catch (DALException e) {
			throw new BLLException("Problème de sélection des catégories: " + e.getMessage());
		}
	}

	// --------------------------------------------------------------------------//
	// -----------------------------Partie enchere-------------------------------//
	// --------------------------------------------------------------------------//
	
	@Override
	public Enchere selectionnerEnchere(int noArticle, int noUtilisateur) throws BLLException {
		try {
			return enchereDAO.selectEnchere(noArticle, noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème de sélection d'une enchère: " + e.getMessage());
		}
	}

	@Override
	public Enchere creerEnchere(Enchere enc) throws BLLException {
		try {
			return enchereDAO.insertEnchere(enc);
		} catch (DALException e) {
			throw new BLLException("Problème de création  d'une enchère: " + e.getMessage());
		}
	}

	@Override
	public List<Enchere> selectionnerToutesLesEncheres() throws BLLException {
		try {
			return enchereDAO.selectAllEnchere();
		} catch (DALException e) {
			throw new BLLException("Problème de sélection des enchères: " + e.getMessage());
		}
	}

	@Override
	public Enchere supprimerEnchere(int noArticle, int noUtilisateur) throws BLLException {
		try {
			return enchereDAO.deleteEnchere(noArticle, noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème de suppression d'une enchère: " + e.getMessage());
		}
	}

	// --------------------------------------------------------------------------//
	// -----------------------------Partie retrait-------------------------------//
	// --------------------------------------------------------------------------//
	@Override
	public Retrait selectionnerRetrait(int noArticle) throws BLLException {
		try {
			return retraitDAO.selectRetrait(noArticle);
		} catch (DALException e) {
			throw new BLLException("Problème de sélection d'un retrait: " + e.getMessage());
		}
	}

	@Override
	public Retrait creerRetrait(Retrait enc) throws BLLException {
		try {
			return retraitDAO.insertRetrait(enc);
		} catch (DALException e) {
			throw new BLLException("Problème de création  d'un retrait: " + e.getMessage());
		}
	}

	@Override
	public List<Retrait> selectionnerTousLesRetraits() throws BLLException {
		try {
			return retraitDAO.selectAllRetrait();
		} catch (DALException e) {
			throw new BLLException("Problème de sélection des retraits: " + e.getMessage());
		}
	}

	@Override
	public Retrait supprimerRetrait(int noArticle) throws BLLException {
		try {
			return retraitDAO.deleteRetrait(noArticle);
		} catch (DALException e) {
			throw new BLLException("Problème de suppression d'un retrait: " + e.getMessage());
		}
	}
}