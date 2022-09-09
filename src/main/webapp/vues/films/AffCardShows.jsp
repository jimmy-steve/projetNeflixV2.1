<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>AffichageListe</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="../../includes/style.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>

<br><h1>Voici la liste des Shows de netflix</h1><br>

<div class="container">
    <div class="card-header my-3 bg-dark text-light">La liste en format Card </div>
    <div class="row">


        <c:forEach var="show" items="${requestScope.listeShows}">
            <div class="col-md-4 my-3 text-center ">
                <div class="card w-100 border-primary mb-3">
                    <div class="card-body ">

                        <form action="" name="forms1" method="post">

                            <table class="table-sm text-center" style="width: 85%; margin-left: auto; margin-right: auto" cellspacing="1" cellpadding="1">
                                <thead>
                                <tr>
                                    <th colspan="2">${show.title}</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Director</td>
                                    <td>${show.director}</td>
                                </tr>


                                <tr>
                                    <td>Release Year</td>
                                    <td>${show.releaseYear}</td>
                                </tr>
                                <tr>
                                    <td>Rating</td>
                                    <td>$ ${show.rating}</td>
                                </tr>

                                </tbody>
                            </table>
                            <div class="mt-3 d-flex justify-content-between my-3">
                                <input type="hidden" name="action" value="ADD">

                                <input class=" btn btn-primary " type="submit" value="AjoutCart"/>


                                <input class=" btn btn-primary " type="submit" value="Buy now"/>
                            </div>

                        </form>






                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>




<%@include file="/includes/footer.jsp" %>
</body>
</html>
