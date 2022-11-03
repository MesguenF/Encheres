package fr.encheres.ihm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.EnchereManager;
import fr.encheres.bll.EnchereManagerSing;
import fr.encheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String next = "/PageConnexion.jsp";
		HttpSession session = request.getSession();

		if (request.getParameter("identifiant") != null) {
			if (!"".equals(request.getParameter("motdepasse"))) {
				Utilisateur user = manager.login(request.getParameter("identifiant"), request.getParameter("motdepasse"));
				
				if(user != null) {
					//on ajoute les attributs IdUser et Admin en session pour pouvoir les réutiliser plus tard
					session.setAttribute("idUser", user.getNoUtilisateur());
					session.setAttribute("admin", user.isAdministrateur());
					request.getRequestDispatcher("PageListeEncheresConnecte.jsp").forward(request, response);
					
				} else {
					request.setAttribute("erreur", "Connexion impossible!");
					request.getRequestDispatcher("PageAccueilNonConnecte.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("erreur", "Connexion impossible!");
				request.getRequestDispatcher("PageAccueilNonConnecte.jsp").forward(request, response);
			}
		}
		request.getRequestDispatcher("PageAccueilNonConnecte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}