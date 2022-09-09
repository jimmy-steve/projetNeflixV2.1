<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-09-01
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style.css">
</head>
<body>
<%@include file="/includes/navbar.jsp" %>
<br><br><br>
<h1>Voici votre panier le panier</h1>

<div class="col-12 " style="margin-right: auto; margin-left: auto">
    <div class="card">
        <table class="table table-hover table-striped">
            <thead class="thead-light">

            <tr>
                <th scope="col">#</th>
                <th scope="col">Type</th>
                <th scope="col">Title</th>
                <%--                        <th scope="col">Director</th>--%>
                <%--                        <th scope="col">Cast</th>--%>
                <th scope="col">Country</th>
                <th scope="col">date Added</th>

                <th scope="col">Release year</th>
                <th scope="col">rating</th>
                <th scope="col">duration</th>
                <th scope="col">listed_in</th>
                <%--                        <th scope="col">description</th>--%>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="show" items="${sessionScope.listePersonnel}">
                <form action="" name="forms2" method="post">
                    <tr>

                        <td>${show.showId}</td>
                        <td>${show.type}</td>
                        <td>${show.title}</td>
                            <%--                                <td>${show.director}</td>--%>
                            <%--                                <td>${show.cast}</td>--%>
                        <td>${show.country}</td>

                        <td>${show.dateAdded}</td>
                        <td>${show.releaseYear}</td>
                        <td>${show.rating}</td>
                        <td>${show.duration}</td>
                        <td>${show.listedIn}</td>
                            <%--                                <td>${show.description}</td>--%>


                        <td>
                            <a href="DetailShow?id=${show.id}"
                               class=" btn btn-success ">Detail</a>
                        </td>
                        <td>
                            <a class=" btn btn-danger ">Supprimer</a>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

<div class="container">
    <div class="card-header my-3 bg-dark text-light">La liste en format Card</div>
    <div class="row">


        <c:forEach var="show" items="${sessionScope.listePersonnel}">
            <div class="col-md-4 my-3 text-center ">
                <div class="card w-100 border-primary mb-3">
                    <div class="card-body ">

                        <form action="" name="forms1" method="post">

                            <table class="table-sm text-center"
                                   style="width: 85%; margin-left: auto; margin-right: auto" cellspacing="1"
                                   cellpadding="1">
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
                                <a href="DetailShow?id=${show.id}"
                                   class=" btn btn-success ">Detail</a>

                                <a class=" btn btn-danger ">Supprimer</a>
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
