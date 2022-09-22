<%--
  Salut Francis, j'ai essaye d'afficher une page avant la page d'accueil afin de choisir la langue avant tout,
  mais je me suis dit que finalement cela ne permettrait pas le changement de langue on the fly, mais je le laisse
  ici just in case
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Chose Language</title>
</head>
<body>

<fmt:setBundle basename="ApplicationResource"/>

<form name="formLangue" action="ChoixLangue" method="get">
    <select class="form-select text-light text-center active mr-4 btn btn-secondary"
            aria-label="Default select example" name="langue" onchange="submit()">
        <option value="fr_CA"><fmt:message key="form.francais"/></option>
        <option value="en_US"><fmt:message key="form.anglais"/></option>
        <option value="es_ES"><fmt:message key="form.espagnol"/></option>
    </select>
    <input type="hidden" name="src" value="1"/>
</form>

</body>
</html>
