<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<script src="https://kit.fontawesome.com/d1158a7200.js" crossorigin="anonymous"></script>
<title>Liste des Utilisateurs</title>
        <div style="text-align:right">
			<a href="PageListeEncheresMesVentes.jsp" >Enchères</a>
			<a href="PageVendreUnArticle.jsp" >Vendre un article</a>
			<a href="MonProfilServlet" >Mon profil</a>	
			<a href="ListingProfilServlet" >Listing des Profil</a>				
			<a href="LogoutServlet" >Déconnexion</a>
		</div>
</head>
<body><br/>
	<h4>Liste des Utilisateurs</h4>
	Cliquez sur l'icône d'un utilisateur pour accéder à son profil

		<c:forEach items="${model.listeUtilisateur}" var="user">
			<table>
				<tr>
				 	<th>
				 		<a href="MonProfilServlet?idProfil=${user.noUtilisateur}"> <i class="far fa-user-circle"></i></a>
				 	</th>
					<td>
						 ${user.pseudo}
				 	</td>
				</tr>			    
			</table>
		</c:forEach>

	</body>
</html>