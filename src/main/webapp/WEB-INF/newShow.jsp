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
<%@include file="/includes/navbarAdmin.jsp" %>
<br>
<h1>Admin Modfié Detail Show</h1><br>


<div class="container">

    <br>
    <div class="row">
        <div class="col-7" style="margin-left: auto; margin-right: auto">
            <div class="card ">
                <div class="card-body ">
                    <h5 class="card-title">Detail d'un Show </h5>
                </div>
                <form action="AddNewShow" method="post">
                    <table class="table table-striped table-hover table-bordered border-primary">
                        <thead>
                        <tr>
                            <th scope="col">Information</th>
                            <th scope="col">Donnée</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Show id :</th>
                            <td><input type="text" id="showId" name="showId" value=""/></td>
                        </tr>
                        <tr>
                            <th scope="row">Type :</th>
                            <td><input type="text" id="type" name="type" value=""/></td>
                        </tr>
                        <tr>
                            <th scope="row">Title :</th>
                            <td><input type="text" id="title" name="title" value=""/></td>
                        </tr>
                        <tr>
                            <th scope="row">Director :</th>
                            <td><input type="text" id="director" name="director" value=""/></td>
                        </tr>
                        <tr>
                            <th scope="row">Cast :</th>
                            <td><input type="text" id="cast" name="cast" value=""/></td>
                        </tr>

                        <tr>
                            <th scope="row">Country :</th>
                            <td><input type="text" id="country" name="country" value=""/></td>
                        </tr>

                        <tr>
                            <th scope="row">Date Added :</th>
                            <td><input type="text" id="dateAdded" name="dateAdded" value=""/></td>
                        </tr>
                        <tr>
                            <th scope="row">Release year :</th>
                            <td><input type="number" id="releaseYear" name="releaseYear" value=""/></td>
                        </tr>

                        <tr>
                            <th scope="row">Rating :</th>
                            <td><input type="text" id="rating" name="rating" value=""/></td>
                        </tr>

                        <tr>
                            <th scope="row">Duration :</th>
                            <td><input type="text" id="duration" name="duration" value=""/></td>
                        </tr>

                        <tr>
                            <th scope="row">Listed In:</th>
                            <td><input type="text" id="listedIn" name="listedIn" value=""/></td>
                        </tr>


                        <tr>
                            <th scope="row">Description :</th>
                            <td><input type="text" id="description" name="description" value=""/></td>
                        </tr>

                        <tr class="text-center">

                            <td colspan="2" class="text-center">
                                <a class="btn btn-danger" href="GestionAdmin?src=show">Retour</a>
                                <input type="hidden" name="id" value="">
                                <button class="btn btn-danger" type="submit">Sauvegarder</button>
                            </td>
                        </tr>


                        </tbody>
                    </table>
                </form>
            </div>
        </div>


    </div>


</div>


<%@include file="/includes/footer.jsp" %>
</body>
</html>

