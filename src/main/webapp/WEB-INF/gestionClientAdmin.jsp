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

<h1 class="text-center text-light" style="margin:auto;margin-top:100px">Netflix Administration</h1>


<div class="container-fluid">
    <br>
    <div class="card-header my-3 bg-danger text-light text-center h3">Ajouter un client</div>
    <div class="row">


        <div class="col-12">
            <table class="table table-striped table-hover text-light bordered border-light">


                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Email</th>
                    <th>Adresse</th>
                    <th>Telephone</th>
                </tr>
                </thead>
                <tbody>
                <form action="Register" method="post">
                    <tr>

                        <td><input type="text" name="nomNew" id="nomNew" value=""/></td>
                        <td><input type="text" name="prenomNew" id="prenomNew" value=""/></td>
                        <td><input type="text" name="emailNew" id="emailNew" value=""/></td>
                        <td><input type="text" name="adresseNew" id="adresseNew" value=""/></td>
                        <td><input type="text" name="telephoneNew" id="telephoneNew" value=""/></td>


                    </tr>


                    <tr>
                        <th>Type abonnement</th>
                        <th>UserName</th>
                        <th>Password</th>
                        <th>Admin</th>
                        <th>Action</th>
                    </tr>

                    <tr>

                        <td>
                            <select class="form-control form-control-sm" id="typeAbonnementNew"
                                    name="typeAbonnementNew">
                                <option value="annuel">Annuel</option>
                                <option value="3mois">3 mois</option>
                                <option value="6mois">6 mois</option>
                            </select>

                        </td>

                        <td><input type="text" name="userNameNew" id="userNameNew" value=""/></td>
                        <td><input type="text" name="passWordNew" id="passWordNew" value=""/></td>
                        <td>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="admin">
                                <label class="form-check-label text-light" for="admin">
                                    Admin
                                </label>
                            </div>
                        </td>
                        <td>
                            <input type="hidden" name="source" value="gestionClientAdmin">
                            <input class="btn btn-danger " type="submit" value="AJOUTER"/>
                        </td>
                    </tr>
                </form>
                </tbody>


            </table>
        </div>


    </div>


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


        <div class="col-4">
            <div class="card border border-dark" style="width:600px;margin:auto;margin-top:50px ">
                <h2 class="bg-warning text-light card-header text-center text-dark ">Modification d'un client</h2>
                <form class="form" action="UpdateClient" method="post">
                    <table class="table table-hover table-striped table-bordered table-responsible">

                        <thead>
                        <tr>
                            <th scope="col">Information</th>
                            <th scope="col">Donnée</th>
                        </tr>
                        </thead>
                        <tbody>
                        <form action="UpdateClient" method="post">
                            <tr>
                                <th scope="row">Id Client :</th>
                                <td>
                                    <input type="number" id="id" name="id" disabled="disabled"
                                           value="${requestScope.client.idClient}"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="prenom">Prénom :</label></th>
                                <td><input type="text" id="prenom" name="prenom" value="${requestScope.client.prenom}"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="nom">Nom :</label></th>
                                <td><input type="text" id="nom" name="nom" value="${requestScope.client.nom}"/></td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="email">Email :</label></th>
                                <td><input type="email" id="email" name="email" value="${requestScope.client.email}"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="adresse">Adresse :</label></th>
                                <td><input type="text" id="adresse" name="adresse"
                                           value="${requestScope.client.adresse}"/></td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="telephone">Téléphone :</label></th>
                                <td><input type="text" id="telephone" name="telephone"
                                           value="${requestScope.client.telephone}"/>
                                </td>
                            </tr>


                            <tr class="bg-dark">
                                <th scope="row" class="text-light">IdUser :</th>
                                <td class="text-light">
                                    <input disabled="disabled" type="number" id="idUser" name="idUser"
                                           value="${requestScope.user.idUser}"/>
                                </td>
                            </tr>
                            <tr class="bg-dark">
                                <th scope="row" class="text-light"><label for="userName">Username:</label></th>
                                <td><input type="text" id="userName" name="userName"
                                           value="${requestScope.user.username}"/></td>
                            </tr>


                        </form>
                        </tbody>


                        <tr class="text-center">

                            <td>
                                <button type="submit" class="btn btn-outline-success">Submit</button>
                            </td>
                            <td>
                                <button type="reset" class="btn btn-outline-danger">Reset</button>
                            </td>

                        </tr>
                    </table>
                </form>
            </div>


        </div>
        <div class="col-6">
            <div class="card border border-dark" style="margin:auto;margin-top:50px">
                <h2 class="bg-primary text-light card-header text-center text-dark">Liste des Clients</h2>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nom Complet</th>
                        <th scope="col">Email</th>
                        <th scope="col">Id Abonnement</th>
                        <th scope="col">Id User</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="client" items="${sessionScope.listClients}">

                        <tr>


                            <th scope="row">${sessionScope.client.idClient}</th>
                            <td>${client.prenom} ${client.nom}</td>
                            <td>${client.email}</td>
                            <td>${client.idAbonnement}</td>
                            <td>${client.idUser}</td>
                            <td>
                                <a class="btn btn-outline-danger" href="GetClient?id=${client.idClient}">Modifié</a>
                                <a class="btn btn-outline-danger"
                                   href="deleteClient?id=${client.idClient}">Supprimer</a>
                            </td>

                        </tr>

                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<br><br>

<%@include file="/includes/footer.jsp" %>
</body>
</html>






