package fr.encheres.ihm;

import java.io.IOException;
import java.util.ArrayList;

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

/**
 * Servlet implementation class ListingProfilServlet
 */
@WebServlet("/ListingProfilServlet")
public class ListingProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListingProfilServlet() {
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
		UtilisateurModel model = new UtilisateurModel(new ArrayList<Utilisateur>());

		try {
			model.setListeUtilisateur(manager.selectionnerTousLesUtilisateurs());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("PageProfil.jsp").forward(request, response);

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
