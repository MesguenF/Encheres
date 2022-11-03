<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" media="screen" type="text/css" href="monstyle.css"/>
<meta charset="ISO-8859-1">
<title>Mon ENI-Ench&egrave;res</title>
</head>
<body>
<div id="container">
        <header>
        <h3 align="left">ENI-Ench&egrave;res</h3>
       	
       	
        <div style="text-align:right">
			<a href="PageListeEncheresMesVentes.jsp" >Ench&egrave;res</a>
			<a href="PageVendreUnArticle.jsp" >Vendre un article</a>
			<a href="MonProfilServlet" >Mon profil</a>	
			<a href="ListingProfilServlet" >Listing des Profil</a>		
			<a href="LogoutServlet" >D&eacute;connexion</a>
		</div>
		
		<h4 align="center">Liste des ench&egrave;res</h4>
		
		</header>
 </div>
 <br> <br>
 <form action="ListeEnchereConnecteServlet" method="POST">
 <div id="filtre">
        
        <h4 align="left">Filtres</h4>
        
		<label>Recherche : </label>
		<input type="search" id="maRecherche" name="recherche" placeholder="Le nom de l'article contient" size="30">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Rechercher"><br/><br/>
		<label>Cat&egrave;gorie : </label> 
				
		<select  name="categorie">
			<option value = "1" >Toutes</option>
			<option value = "2" >Informatique</option>
			<option value = "3">Ameublement</option>
			<option value = "4" >V&ecirc;tement</option>
			<option value = "5" >Sport&Loisir</option>
		</select>
	
 </div>
 <br>
 <div class="form-check">
			
	  			<div class="row">
	  				<div class="col">
			  			<input class="form-check-input" type="radio" name="achatVente" id="achats" value="achats" checked >
			  			<label class="form-check-label" for="achats">Achats</label>
			  			<br>
			  			<input class="form-check-input" type="checkbox" value="encheresOuvertes" id="encheresOuvertes">
			  			<label class="form-check-label" for="defaultCheck1">enchères ouvertes</label>
			  			<br>
			  			<input class="form-check-input" type="checkbox" value="encheresCours" id="encheresCours">
			  			<label class="form-check-label" for="encheresCours">mes enchères en cours</label>
			  			<br>
			  			<input class="form-check-input" type="checkbox" value="ecnheresRemportees" id="ecnheresRemportees">
			  			<label class="form-check-label" for="ecnheresRemportees">mes enchères remportées</label>
			  		</div>
			  		
	  				<div class="col">
			  			<input class="form-check-input" type="radio" name="achatVente" id="mesVentes" value="mesVentes" >
			  			<label class="form-check-label" for="exampleRadios1">Mes ventes</label>
			  			<br>
			  			<input class="form-check-input" type="checkbox" value="ventesEncours" id="ventesEncours" >
			  			<label class="form-check-label" for="ventesEncours">mes ventes en cours</label>
			  			<br>
			  			<input class="form-check-input" type="checkbox" value="ventesNondebutees" id="ventesNondebutees">
			  			<label class="form-check-label" for="ventesNondebutees">ventes non débutées</label>
			  			<br>
			  			<input class="form-check-input" type="checkbox" value="ventesTerminees" id="ventesTerminees">
			  			<label class="form-check-label" for="ventesTerminees">ventes terminées</label>
	  				</div>
			  		
			  	</div>
		</div>
<div class="container">
 <div id="box1">
 <h4>
  		<c:forEach items="${enchereModel.listeEnchere}" var="enchere">
			<table>
			  <tr>
			  <th>Date ench&egrave;re:</th><th>Prix:</th>
  			  </tr>
			  	<td>${enchere.dateEnchere}</td>
			    <td>${enchere.montantEnchere}</td>
			</table>
			<br/>
		</c:forEach>
		
</h4>
</div>
<div id="box2">
<h4>
<c:forEach items="${articlevenduModel.listearticles}" var="article">
			<table>
			  <tr>
			  <th>Nom:</th><th>Description:</th><th>Fin ench&egrave;re:</th>
  			  </tr>
			    <td>${article.nomArticle}</td>
			    <td>${article.description}</td>
			    <td>${article.dateFinEncheres}</td>
			</table>
			<br/>
		</c:forEach>
</h4>
</div>	

<div id="box3">
<h4>
		<c:forEach items="${utilisateurModel.listeUtilisateur}" var="utilisateur">
			<table>
			  <tr>
			  <th>Vendeur:</th>
  			  </tr>
			    <td>${utilisateur.pseudo}</td>
			</table>
			<br/>
		</c:forEach>
</h4>
</div>	
</div>	
</form>
</body>
</html>