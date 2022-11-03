package fr.encheres.dal;

import java.util.List;

import fr.encheres.bo.Retrait;

public interface RetraitDAO {

	public Retrait selectRetrait(int noArticle) throws DALException;

	public Retrait insertRetrait(Retrait enc) throws DALException;

	List<Retrait> selectAllRetrait() throws DALException;

	public Retrait deleteRetrait(int noArticle) throws DALException;
}
