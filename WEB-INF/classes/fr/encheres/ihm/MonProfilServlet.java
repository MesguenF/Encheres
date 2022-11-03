package fr.encheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.BLLException;
import fr.encheres.bll.EnchereManager;
import fr.encheres.bll.EnchereManagerSing;
import fr.encheres.bo.Utilisateur;
import fr.encheres.dal.DALException;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/MonProfilServlet")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// Test si l'utilisateur est connecté, sinon on renvoi vers la page d'accueil
		if(session == null) {
			request.getRequestDispatcher("PageAccueilNonConnecte.jsp").forward(request, response);
			} else {
			int idUser = (int) session.getAttribute("idUser") ;
			int idPseudo =  Integer.parseInt(request.getParameter("idProfil") != null ? request.getParameter("idProfil") : "0" );
			int id;
			UtilisateurModel model = new UtilisateurModel(new Utilisateur());
		
			
			//Si l'utilisateur connecté clique sur un autre profil que le sien, on récupère l'id du profil,
			//sinon on récupère son idUser pour afficher son profil
		try {
			
			if(idUser != idPseudo && idPseudo != 0) {
				id = idPseudo;
			} else {
				id = idUser;
			}
			
			Utilisateur user = manager.selectionnerUtilisateur(id);
			
			
			//Si on est en mode edition on récupère toutes les données pour faire l'update
			if (request.getParameter("envoyer") != null) {
				String pseudo = request.getParameter("pseudo");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String mail = request.getParameter("email");
				String telephone =	request.getParameter("telephone");
				String rue = request.getParameter("adresse");
				String codePostal =	request.getParameter("codepostal");
				String ville =	request.getParameter("ville");
				String password =	(request.getParameter("Password") != "" ? request.getParameter("Password"): user.getMotDePasse()) ;

				
				//On check que tout est rempli
				if (pseudo != "" & nom != "" & prenom != "" & mail != "" & telephone != "" & rue != "" & codePostal != "" & ville != "") {
					
					model.getUtilisateur().setNoUtilisateur(id);
					model.getUtilisateur().setPseudo(pseudo);
					model.getUtilisateur().setNom(nom);
					model.getUtilisateur().setPrenom(prenom);
					model.getUtilisateur().setEmail(mail);
					model.getUtilisateur().setTelephone(telephone);
					model.getUtilisateur().setRue(rue);
					model.getUtilisateur().setCodePostal(codePostal);
					model.getUtilisateur().setVille(ville);
					model.getUtilisateur().setMotDePasse(password);
					model.getUtilisateur().setCredit(user.getCredit());
					model.getUtilisateur().setAdministrateur(user.isAdministrateur());
					model.getUtilisateur().setActif(user.isActif());

					manager.updateUser(model.getUtilisateur());
					user = manager.selectionnerUtilisateur(id);
				}
			}
			//Et on affiche les données entrantes de l'utilisateur
			request.setAttribute("pseudo", user.getPseudo());
			request.setAttribute("nom", user.getNom());
			request.setAttribute("prenom", user.getPrenom());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("telephone", user.getTelephone());
			request.setAttribute("adresse", user.getRue());
			request.setAttribute("codepostal", user.getCodePostal());
			request.setAttribute("ville", user.getVille());
			request.setAttribute("credit", user.getCredit());
			model.setUtilisateur(user);
		} catch (BLLException | DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		request.getRequestDispatcher("PageMonProfil.jsp").forward(request, response);
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
