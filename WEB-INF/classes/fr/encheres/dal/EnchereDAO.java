package fr.encheres.dal;

import java.util.List;

import fr.encheres.bo.Enchere;

public interface EnchereDAO {
	
	public Enchere selectEnchere(int noArticle, int noUtilisateur) throws DALException;

	public Enchere insertEnchere(Enchere enc) throws DALException;

	List<Enchere> selectAllEnchere() throws DALException;

	public Enchere deleteEnchere(int noArticle, int noUtilisateur) throws DALException;

}
