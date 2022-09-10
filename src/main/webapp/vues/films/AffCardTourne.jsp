<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Affichage de card qui tourne</title>
    <%@include file="/includes/head.jsp" %>
    <%--    on dirais que le liens ne fonctione pas--%>
    <%--    <link type="text/css" rel="stylesheet" href="../../style3.css">--%>


    <script>
        /* Set the width of the side navigation to 250px */
        function openNav() {
            document.getElementById("mySidenav").style.width = "500px";
        }

        /* Set the width of the side navigation to 0 */
        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
    <style>


        .card-container {
            width: 300px;
            height: 400px;
        }

        .card {
            width: 100%;
            height: 100%;
            transition: transform 1.5s ease-in-out;
            transform-style: preserve-3d;
            backface-visibility: hidden;
        }

        .card-container:hover .card {
            transform: rotateY(180deg);
        }

        .card figure {
            width: 100%;
            height: 100%;
            position: absolute;
            margin: 0;
            border-radius: 5px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            backface-visibility: hidden;


        }

        .card .front {
            background-color: white;
            color: white;
            text-align: center;
        }

        .card .back {
            border: 2px solid black;
            color: black;
            transform: rotateY(180deg);
            backface-visibility: hidden;
        }

        .back button {
            background: red;;
            color: white;
            border: none;
            padding: 10px 20px;
        }

    </style>
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>
<br>
<h1 class="text-center text-light" style="margin:auto;margin-top:100px">Format Card Special </h1><br>

<h3 class="text-center text-light">Notre sélection des plus récent Films Canadien </h3><br>
<div class="container-fluid ml-4" style="margin-top: 50px;">
    <div class="row mx-auto">
        <c:forEach var="show" items="${requestScope.listeShows}">
            <div class="col-2">
                <div class="card-container ml-5 mb-4 mt-5">


                    <div class="card">

                        <figure class="back">

                            <img src="${pageContext.request.contextPath}/images/photo21.jpg"
                                 class="card-img-top img-fluid"
                                 alt="...">
                        </figure>
                        <figure class="front bg-light">
                            <div class="card-body">
                                <h5 class="card-title text-center text-dark">${show.title}</h5>
                            </div>

                            <table class="table table-hover text-center">
                                <thead>
                                <tr>
                                    <th scope="col">Title</th>
                                    <th scope="col">${show.title}</th>

                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">Year</th>
                                    <td>${show.releaseYear}</td>

                                </tr>
                                <tr>
                                    <th scope="row">Rating</th>
                                    <td>${show.rating}</td>

                                </tr>
                                <tr>
                                    <th colspan="2" class="text-center">
                                        <a href="AjouterArticlePanier?id=${show.id}"
                                           class=" btn btn-success ">Ajouter</a>
                                        <a href="DetailShow?source=client&id=${show.id}"
                                           class=" btn btn-danger ">Detail</a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>
                        </figure>
                    </div>

                </div>
            </div>
        </c:forEach>

    </div>
</div>

<%@include file="/includes/footer.jsp" %>
</body>
</html>
