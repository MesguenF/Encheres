package fr.encheres.dal;

import java.util.List;

import fr.encheres.bo.Categorie;

public interface CategorieDAO {
	
	public Categorie selectCategorie(int noCategorie) throws DALException;

	public Categorie insertCategorie(Categorie cat) throws DALException;

	List<Categorie> selectAllCategorie() throws DALException;
	
}
