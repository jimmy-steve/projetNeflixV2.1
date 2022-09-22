<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Connected</title>
    <%@include file="/includes/head.jsp" %>
</head>
<body style="background-color: black">
<%@include file="/includes/navbarAdmin.jsp" %>
<br>

<h1 class="text-center text-light mb-3" style="margin:auto;margin-top:100px; margin-left: 100px">Netflix Administration
    - Abonnements</h1>


<div class="container-fluid">
    <div class="row">


        <div class="col-2">
            <nav class="navbar">
                <ul class="nav navbar-nav mt-5">
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn-outline-danger btn" href="GestionAdmin?src=home"> Home </a>
                    </li>
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn btn-outline-warning" href="GestionAdmin?src=client">Gestion Client</a>
                    </li>
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn-outline-danger btn" href="GestionAdmin?src=abonnement">Gestion
                            Abonnement</a>
                    </li>
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn btn-outline-warning" href="GestionAdmin?src=show"> Gestion Show </a>
                    </li>
                </ul>
            </nav>
        </div>


        <div class="col-6">
            <div class="card border border-dark" style="margin:auto;margin-top:50px">
                <h2 class="bg-primary text-light card-header text-center text-dark">Liste des Abonnements</h2>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Id User</th>
                        <th scope="col">Id Abonnement</th>
                        <th scope="col">Type Abonnement</th>
                        <th scope="col">Prix</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="abonnements" items="${sessionScope.listAbonnements}">

                        <tr>

                            <td>${abonnements.idUser}</td>
                            <td>${abonnements.idAbonnement}</td>
                            <td>${abonnements.typeAbonnement}</td>
                            <td>${abonnements.prix}</td>
                            <!--<td>
                                <a class="btn btn-outline-danger" href="GetAbonnement?id=${abonnements.typeAbonnement}">Modifié</a>
                                <a class="btn btn-outline-danger"
                                   href="deleteAbonnement?id=${abonnements.typeAbonnement}">Supprimer</a>
                            </td>-->

                        </tr>

                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>


    </div>
</div>

<%@include file="/includes/footer.jsp" %>
</body>
</html>
