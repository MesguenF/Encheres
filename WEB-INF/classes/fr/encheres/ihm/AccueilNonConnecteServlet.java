package fr.encheres.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.encheres.bll.BLLException;
import fr.encheres.bll.EnchereManager;
import fr.encheres.bll.EnchereManagerSing;
import fr.encheres.bo.ArticleVendu;
import fr.encheres.bo.Enchere;
import fr.encheres.bo.Utilisateur;

/**
 * Servlet implementation class AccueilNonConnecteServlet
 */
@WebServlet("/AccueilNonConnecteServlet")
public class AccueilNonConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilNonConnecteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EnchereModel enchereModel = new EnchereModel(new Enchere(), new ArrayList<Enchere>());
		ArticlevenduModel articlevenduModel = new ArticlevenduModel(new ArticleVendu(), new ArrayList<ArticleVendu>());
		UtilisateurModel utilisateurModel = new UtilisateurModel(new Utilisateur(), new ArrayList<Utilisateur>());
		
		List<Enchere> listeEnchereAvantFiltre = new ArrayList<Enchere>();
		List<Enchere> listeEnchereApresFiltre = new ArrayList<Enchere>();
		List<ArticleVendu> listeArticleVenduFiltre = new ArrayList<ArticleVendu>();
		List<Utilisateur> listeUtilisateurFiltre = new ArrayList<Utilisateur>();
		
		ArticleVendu art = new ArticleVendu();
		Utilisateur util = new Utilisateur();
		
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		String recherche = request.getParameter("recherche");
		//System.out.println(recherche);
		
		
		
		try {
			//On r�cup�re toutes les ench�res
			listeEnchereAvantFiltre = manager.selectionnerToutesLesEncheres();
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			switch (categorie) {
			//Filtre = Toutes
			case 1:
				System.out.println(categorie);
				for (Enchere e : listeEnchereAvantFiltre) {
					art = manager.selectionnerArticleVendu(e.getNoArticle());
					util = manager.selectionnerUtilisateur(e.getNoUtilisateur());
					if(recherche != "") {
						if(art.getEtatVente() == 1 & art.getNomArticle().contains(recherche)) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}else {
						if(art.getEtatVente() == 1) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}
				}
				break;
			//Filtre = Informatique
			case 2:
				System.out.println(categorie);
				for (Enchere e : listeEnchereAvantFiltre) {
					art = manager.selectionnerArticleVendu(e.getNoArticle());
					util = manager.selectionnerUtilisateur(e.getNoUtilisateur());
					if(recherche != "") {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 1 & art.getNomArticle().contains(recherche)) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}else {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 1) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}
				}
				break;
			//Filtre = Ameublement
			case 3:
				System.out.println(categorie);
				for (Enchere e : listeEnchereAvantFiltre) {
					art = manager.selectionnerArticleVendu(e.getNoArticle());
					util = manager.selectionnerUtilisateur(e.getNoUtilisateur());
					if(recherche != "") {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 2 & art.getNomArticle().contains(recherche)) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}else {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 2) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}
				}
				break;
			//Filtre= V�tement
			case 4:
				System.out.println(categorie);
				for (Enchere e : listeEnchereAvantFiltre) {
					art = manager.selectionnerArticleVendu(e.getNoArticle());
					util = manager.selectionnerUtilisateur(e.getNoUtilisateur());
					if(recherche != "") {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 3 & art.getNomArticle().contains(recherche)) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}else {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 3) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}
				}
				break;
			//Filtre= Sport&Loisirs
			case 5:
				System.out.println(categorie);
				for (Enchere e : listeEnchereAvantFiltre) {
					art = manager.selectionnerArticleVendu(e.getNoArticle());
					util = manager.selectionnerUtilisateur(e.getNoUtilisateur());
					if(recherche != "") {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 4 & art.getNomArticle().contains(recherche)) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}else {
						if(art.getEtatVente() == 1 & art.getNoCategorie() == 4) {
							listeEnchereApresFiltre.add(e);
							listeArticleVenduFiltre.add(art);
							listeUtilisateurFiltre.add(util);
						}
					}
				}
				break;
			}

			enchereModel.setListeEnchere(listeEnchereApresFiltre);
			articlevenduModel.setListearticles(listeArticleVenduFiltre);
			utilisateurModel.setListeUtilisateur(listeUtilisateurFiltre);
			

		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("enchereModel", enchereModel);
		request.setAttribute("articlevenduModel", articlevenduModel);
		request.setAttribute("utilisateurModel", utilisateurModel);
		
		request.getRequestDispatcher("PageAccueilNonConnecte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}