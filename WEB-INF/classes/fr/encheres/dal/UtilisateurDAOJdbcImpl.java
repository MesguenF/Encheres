package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.encheres.bo.Utilisateur;
import fr.encheres.dal.DALException;
import fr.encheres.dal.util.ConnectionProvider;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String sqlSelectUtilisateur 	= "select * from Utilisateurs where no_utilisateur = ?";
	private static final String sqlSelectLogin 	= "select * from Utilisateurs where pseudo = ?";
	private static final String sqlSelectAllUtilisateur = "select * from Utilisateurs";
	private static final String sqlInsertUtilisateur = "insert into Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, actif) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlUpdateUtilisateur = "update Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue= ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ?, actif = ? WHERE no_utilisateur = ?";

	private static final String sqlDeleteUtilisateur = "delete from Utilisateurs where no_utilisateur = ?";


	
	@Override
	public Utilisateur selectUser(int noUtilisateur) throws DALException {
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Utilisateur util = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.prepareStatement(sqlSelectUtilisateur);
				rqt.setInt(1, noUtilisateur);

				rs = rqt.executeQuery();
				while (rs.next()) {
					util = new Utilisateur( rs.getInt("no_utilisateur"), rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"), rs.getString("telephone"), 
							rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),rs.getInt("credit"), rs.getBoolean("administrateur"), rs.getBoolean("actif"));
				}
							
			} catch (SQLException e) {
				throw new DALException("select Utilisateur failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return util;
	}
	
	public Utilisateur loginUser(String pseudo) throws DALException {
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Utilisateur util = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.prepareStatement(sqlSelectLogin);
				rqt.setString(1, pseudo);

				rs = rqt.executeQuery();
				while (rs.next()) {
					util = new Utilisateur( rs.getInt("no_utilisateur"), rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"), rs.getString("telephone"), 
							rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),rs.getInt("credit"), rs.getBoolean("administrateur"), rs.getBoolean("actif"));
				}
							
			} catch (SQLException e) {
				throw new DALException("select loginuser failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return util;
	}
	
	
	public List<Utilisateur> selectAllUser() throws DALException {
		Statement rqt = null;
		ResultSet rs = null;
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(connection);

			try {
				rqt = connection.createStatement();
				rs = rqt.executeQuery(sqlSelectAllUtilisateur);
				Utilisateur util = null;
				while (rs.next()) {
					util = new Utilisateur(  rs.getInt("no_utilisateur"), rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"), rs.getString("telephone"), 
							rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),rs.getInt("credit"), rs.getBoolean("administrateur"), rs.getBoolean("actif"));
					liste.add(util);
				}
			} catch (SQLException e) {
				throw new DALException("selectAllUser failed - ", e);
			} 
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - ", e1);
		}
		return liste;
	}
	
	@Override
	public Utilisateur insertUser(Utilisateur util) throws DALException {
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlInsertUtilisateur, Statement.RETURN_GENERATED_KEYS);
				rqt.setString(1, util.getPseudo());

				rqt.setString(2, util.getNom());
				rqt.setString(3, util.getPrenom());
				rqt.setString(4, util.getEmail());
				rqt.setString(5, util.getTelephone());
				rqt.setString(6, util.getRue());
				rqt.setString(7, util.getCodePostal());
				rqt.setString(8, util.getVille());
				rqt.setString(9, util.getMotDePasse());
				rqt.setInt(10, util.getCredit());
				rqt.setBoolean(11, util.isAdministrateur());
				rqt.setBoolean(12, util.isActif());

								
				int nbRows = rqt.executeUpdate();
				if (nbRows > 0) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						util.setNoUtilisateur(rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DALException("InsertUser failed - " + util, e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + util, e1);
		}
		return util;
	}

	public Utilisateur deleteUser(int noUtilisateur) throws DALException {
		
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlDeleteUtilisateur);
				rqt.setInt(1, noUtilisateur);
				rqt.executeUpdate();
			} catch (SQLException e) {
				e.getStackTrace();
				throw new DALException("DeleteUser failed - " + noUtilisateur+ e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + noUtilisateur + e1);
		}
		return null;
	}

	@Override
	public Utilisateur updateUser(Utilisateur util) throws DALException {
		PreparedStatement rqt = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("Connexion: " + connection);

			try {
				rqt = connection.prepareStatement(sqlUpdateUtilisateur, Statement.RETURN_GENERATED_KEYS);
				rqt.setString(1, util.getPseudo());
				rqt.setString(2, util.getNom());
				rqt.setString(3, util.getPrenom());
				rqt.setString(4, util.getEmail());
				rqt.setString(5, util.getTelephone());
				rqt.setString(6, util.getRue());
				rqt.setString(7, util.getCodePostal());
				rqt.setString(8, util.getVille());
				rqt.setString(9, util.getMotDePasse());
				rqt.setInt(10, util.getCredit());
				rqt.setBoolean(11, util.isAdministrateur());
				rqt.setBoolean(12, util.isActif());
				rqt.setInt(13, util.getNoUtilisateur());

								
				int nbRows = rqt.executeUpdate();
				if (nbRows > 0) {
					ResultSet rs = rqt.getGeneratedKeys();
					if (rs.next()) {
						util.setNoUtilisateur(rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DALException("UpdateUser failed - " + util, e);
			}
		} catch (SQLException e1) {
			throw new DALException("CONNEXION failed - " + util, e1);
		}
		return util;
	}

}
