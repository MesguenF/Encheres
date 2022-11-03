<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Profil</title>
        <div style="text-align:right">
			<a href="PageListeEncheresMesVentes.jsp" >Ench&egrave;res</a>
			<a href="PageVendreUnArticle.jsp" >Vendre un article</a>
			<a href="MonProfilServlet" >Mon profil</a>		
			<a href="ListingProfilServlet" >Listing des Profil</a>	
			<a href="LogoutServlet" >D&eacute;connexion</a>
		</div>
</head>
<body><br/>
<h4>Profil : ${pseudo}</h4>

		<form action="MonProfilServlet" method="POST" >
		
			<label for="nom"> Pseudo :</label> 
			<input type="text" id="pseudo" name="pseudo"  size="30"  value=${pseudo} />
			
			<label for="nom"> Nom : </label> 
			<input type="text" id="nom" name="nom" value=${nom} size="30" />
		
			<label for="prenom"> Prénom : </label>
			<input type="text" id="prenom" name="prenom" value=${prenom} size="30" />
			<br /><br />
		
			<label for="email"> Email : </label>
			<input type="text" id="email" name="email" value=${email} size="30" />
			<br /><br />
		
			<label for="telephone"> Téléphone : &nbsp;</label> 
			<input type="text" id="telephone" name="telephone"  value=${telephone} size="15" />
			<br /><br />

			<label for="adresse"> Adresse : </label> 
			<input type="text" id="adresse"  name="adresse" value=${adresse} size="75" />
			<br /><br />
	
			<label for="codepostal"> Code Postal : </label> 
			<input type="text" id="codepostal" name="codepostal"  value=${codepostal} size="5" />
			<br /><br />
	
			<label for="ville"> Ville : </label> 
			<input type="text" id="ville" name="ville" value=${ville} size="30" />
			<br /><br />
		
			<label for="password"> Mot de Passe : </label> 
			<input type="password" id="Password" name="Password" size="30" />
			<br /><br /> 
			
			<button type="submit" name="envoyer" value="envoyer"> Envoyer </button>
			
			<button type="reset"> Annuler </button>
		</form>
		
		<form action="DeleteAccountServlet" method="POST" >
		
				<div>
				 <label for="deleteAccount">Supprimer le profil utilisateur</label>
				
			  <input type="checkbox" id="deleteAccount" name="deleteAccount">
			</div>
		
			<button type="submit" name="deleteSend" value="deleteSend"> Supprimer </button>
			<br /><br />
		</form>
	</body> 
</body>
</html>