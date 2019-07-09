<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Perso</title>
    </head>
    <body>
    	<c:import url="/WEB-INF/deconnexion.jsp" />
    	<p><a href="<c:url value="/listeeleves"/>">Afficher la liste des eleves</a></p>
        <p>Bienvenue sur votre page.</p>
    </body>
</html>