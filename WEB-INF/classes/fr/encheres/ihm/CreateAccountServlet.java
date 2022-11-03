package fr.encheres.ihm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.encheres.bll.BLLException;
import fr.encheres.bll.EnchereManager;
import fr.encheres.bll.EnchereManagerSing;
import fr.encheres.bo.Utilisateur;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurModel model = new UtilisateurModel(new Utilisateur());

		 try {
			 
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("email");
		String telephone =	request.getParameter("telephone");
		String rue = request.getParameter("adresse");
		String codePostal =	request.getParameter("codepostal");
		String ville =	request.getParameter("ville");
		String password = request.getParameter("password");
		
		if (pseudo != "" & nom != "" & prenom != "" & mail != "" & telephone != "" & rue != "" & codePostal != "" & ville != "") {
			
			model.getUtilisateur().setPseudo(pseudo);
			model.getUtilisateur().setNom(nom);
			model.getUtilisateur().setPrenom(prenom);
			model.getUtilisateur().setEmail(mail);
			model.getUtilisateur().setTelephone(telephone);
			model.getUtilisateur().setRue(rue);
			model.getUtilisateur().setCodePostal(codePostal);
			model.getUtilisateur().setVille(ville);
			model.getUtilisateur().setMotDePasse(password);
			model.getUtilisateur().setCredit(100);
			model.getUtilisateur().setAdministrateur(false);
			model.getUtilisateur().setActif(true);
			
			manager.creerUtilisateur(model.getUtilisateur());
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
