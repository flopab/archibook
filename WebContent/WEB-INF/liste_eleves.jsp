<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des eleves</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
    	<c:import url="/WEB-INF/deconnexion.jsp" />
    	<p><a href="<c:url value="/perso"/>">Revenir sur le profil</a></p>
        <h1>Liste des eleves</h1>

        <c:forEach items="${ messages }" var="message" varStatus="boucle">
            <p>${ boucle.count }. ${ message }</p>
        </c:forEach>
    </body>
</html>