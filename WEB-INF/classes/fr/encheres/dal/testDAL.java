package fr.encheres.dal;

import java.time.LocalDate;

import fr.encheres.bo.ArticleVendu;
import fr.encheres.bo.Categorie;
import fr.encheres.bo.Enchere;
import fr.encheres.bo.Retrait;
import fr.encheres.bo.Utilisateur;

public class testDAL {
	static UtilisateurDAO daoUtil = DAOFactory.getUtilisateurDAO();
	static ArticleVenduDAO daoArt = DAOFactory.getArticleVenduDAO();
	static CategorieDAO daoCat = DAOFactory.getCategorieDAO();
	static EnchereDAO daoEnc = DAOFactory.getEnchereDAO();
	static RetraitDAO daoRet = DAOFactory.getRetraitDAO();




	public static void main(String[] args) throws fr.encheres.dal.DALException {
		System.out.println("-------Liste des coureurs--------");
		
		@SuppressWarnings("unused")
		Utilisateur part1 = new Utilisateur("Mamti","LeFloch","Marwin","marwin@gmail.com", "056325225","6 rue de la plage","56340","Carnac", "trezay",10,true, true);
		//daoUtil.insert(part1);
		Categorie cat1 = new Categorie("Informatique");

		ArticleVendu art1 = new ArticleVendu("test","PC Portable HP", LocalDate.parse("2021-05-06"), LocalDate.parse("2021-06-06"), 500, 400, 2, 1, 1);
		Enchere enc1 = new Enchere(LocalDate.parse("2012-11-04"), 120, 2, 4);

		Retrait ret1 = new Retrait(2,"6 rue de la plage ","56340","Carnac");

		
		try {
			//Insert
//			dao.insert(part2);
//			dao.insert(part3);
		//	daoUtil.insertUser(part1);
			//daoCat.insertCategorie(cat1);
			//daoArt.insertProduct(art1);
			//daoEnc.insertEnchere(enc1);
			//daoUtil.delete(3);
			//daoRet.insertRetrait(ret1);
			//SelectALL
			daoUtil.selectAllUser();
			System.out.println("-------Liste des coureurs--------");
			System.out.println(daoUtil.selectAllUser() + "<br>");
			System.out.println(daoArt.selectAllProduct());


			

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Problème DAL : "+e.getMessage());
		}
	}
}