<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-09-03
  Time: 08:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Detail Show</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="../includes/style.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>
<br><h1>Admin Modfié Detail Show</h1><br>


<div class="container">

    <br>
    <div class="row">
        <div class="col-7" style="margin-left: auto; margin-right: auto">
            <div class="card ">
                <div class="card-body ">
                    <h5 class="card-title">Detail d'un Show </h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                </div>
                <table class="table table-striped table-hover table-bordered border-primary">
                    <thead>
                    <tr>
                        <th scope="col">Information</th>
                        <th scope="col">Donnée</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Id :</th>
                        <td>${show.showId}</td>
                    </tr>
                    <tr>
                        <th scope="row">Type :</th>
                        <td><input type="text" id="type" name="type" value="${show.type}"/></td>
                    </tr>
                    <tr>
                        <th scope="row">Title :</th>
                        <td><input type="text" id="title" name="title" value="${show.title}"/></td>
                    </tr>
                    <tr>
                        <th scope="row">Director :</th>
                        <td>${show.director}</td>
                    </tr>
                    <tr>
                        <th scope="row">Cast :</th>
                        <td>${show.cast}</td>
                    </tr>

                    <tr>
                        <th scope="row">Country :</th>
                        <td>${show.country}</td>
                    </tr>

                    <tr>
                        <th scope="row">Date Added :</th>
                        <td>${show.dateAdded}</td>
                    </tr>
                    <tr>
                        <th scope="row">Release year :</th>
                        <td>${show.releaseYear}</td>
                    </tr>

                    <tr>
                        <th scope="row">Rating :</th>
                        <td>${show.rating}</td>
                    </tr>

                    <tr>
                        <th scope="row">Duration :</th>
                        <td>${show.duration}</td>
                    </tr>

                    <tr>
                        <th scope="row">Listed In:</th>
                        <td>${show.listedIn}</td>
                    </tr>


                    <tr>
                        <th scope="row">Description :</th>
                        <td>${show.description}</td>
                    </tr>

                    <tr class="text-center">

                        <td colspan="2" class="text-center">
                            <a  class="btn btn-danger" href="GestionAdmin?src=show">Retour</a>

                        </td>
                    </tr>


                    </tbody>
                </table>
            </div>
        </div>


    </div>


</div>




<%@include file="/includes/footer.jsp" %>
</body>
</html>

