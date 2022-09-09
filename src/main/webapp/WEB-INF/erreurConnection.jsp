<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erreur de connection</title>
    <%@include file="/includes/head.jsp" %>
</head>
<body style="background-color: black">
<%@include file="/includes/navbarAcceuil.jsp"%>
<br><br><br><br>
<br><h1 class="text-center text-light"> Erreur de connection</h1><br>
<br><br>
<div class="alert alert-danger container" role="alert">
    <h3 class="text-center" style="color: red">Bravo !!!! Le système à planté .....C'est un erreur de saisie de mot de passe ou de de username<br><!-- comment --></h3>

</div>
<br>

<br>

<div class="container bg-secondary rounded-0">
    <div class="px-4 py-5 my-5 text-center">
        <img class="d-block mx-auto mb-4 img-fluid" src="images/oopss.jpg" >
        <h1 class="display-5 fw-bold text-light">!!! Erreur 404 !!!</h1>
        <div class="col-lg-6 mx-auto">
            <p class="lead mb-4 text-light">Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular front-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
            <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                <a href="Acceuil.jsp" class="btn btn-primary btn-lg px-4 gap-3">Home</a>
                <a href="Acceuil.jsp" class="btn btn-primary btn-lg px-4">Maison</a>
            </div>
        </div>
    </div>
</div>

<div class="b-example-divider"></div>

<%@include file="/includes/footer.jsp"%>

</body>
</html>

