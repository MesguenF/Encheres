package fr.encheres.dal;

import java.util.List;

import fr.encheres.bo.Utilisateur;



public interface UtilisateurDAO {
	
	// Sélectionner un coureur
		public Utilisateur selectUser(int noUtilisateur) throws DALException;
		
		public Utilisateur loginUser(String pseudo) throws DALException;

		public Utilisateur insertUser(Utilisateur util) throws DALException;

		List<Utilisateur> selectAllUser() throws DALException;

		public Utilisateur deleteUser(int noUtilisateur) throws DALException;

		public Utilisateur updateUser(Utilisateur utilisateur) throws DALException;
		
}
