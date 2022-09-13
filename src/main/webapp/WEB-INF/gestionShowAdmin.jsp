<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-30
  Time: 18:29
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

<h1 class="text-center text-light mb-3" style="margin:auto;margin-top:100px; margin-left: 100px">Liste de shows netflix
    Administration</h1>


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


        <div class="col-8 m-5" style="margin-right: auto; margin-left: auto">
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
                    <c:forEach var="netflix" items="${sessionScope.listShows}">
                    <tbody>


                        <tr>

                            <td>${netflix.showId}</td>
                            <td>${netflix.type}</td>
                            <td>${netflix.title}</td>
                            <td>${netflix.country}</td>
                            <td>${netflix.dateAdded}</td>
                            <td>${netflix.releaseYear}</td>
                            <td>${netflix.rating}</td>
                            <td>${netflix.duration}</td>
                            <td>${netflix.listedIn}</td>

                            <td>
                                <form action="" name="forms2" method="post">
                                    <a href="DetailShow?source=admin&id=${netflix.id}"
                                       class=" btn btn-success ">Modifié</a>
                                </form>
                            </td>
                        </tr>


                    </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>


    </div>
</div>


<%@include file="/includes/footer.jsp" %>
</body>
</html>
