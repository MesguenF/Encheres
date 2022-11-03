<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Connexion ENI-Enchères</title>
</head>
	<body>
		<br/>
		<h4>ENI-Enchères</h4>
		<br/><br/>	
		 <div style="text-align: center">
		   <form action="LoginServlet" method="POST">
				<label>Identifiant :</label>
				<input type="text" name="identifiant" size="30" maxlength="30"/><br/><br/>
				
				<label>Mot de passe :</label>
				<input type="password" name="motdepasse" size="30" maxlength="30"/><br/><br/>
				
				<input type="submit" value="Connexion"/><br/><br/>
				<br/><br/><br/><br/>
				<input type="submit" value="Créer un compte"/>
			</form>
		</div>	
	</body>
</html>