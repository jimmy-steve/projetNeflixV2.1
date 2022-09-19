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
    <title>AffListe de show</title>
    <%@include file="/includes/head.jsp" %>
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>
<br>
<h1 class="text-center text-light" style="margin:auto;margin-top:100px">Liste de shows netflix version2</h1><br>


<div class="col-12 " style="margin-right: auto; margin-left: auto">
    <div class="card">
        <table class="table table-hover table-striped">
            <thead class="thead-light">

            <tr>
                <th scope="col">#</th>
                <th scope="col">Type</th>
                <th scope="col">Title</th>
                <th scope="col">Country</th>
                <th scope="col">date Added</th>
                <th scope="col">Release year</th>
                <th scope="col">rating</th>
                <th scope="col">duration</th>
                <th scope="col">listed_in</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="show" items="${requestScope.smallList}">
                <form action="" name="forms2" method="post">
                    <tr>

                        <td>${show.showId}</td>
                        <td>${show.type}</td>
                        <td>${show.title}</td>
                        <td>${show.country}</td>
                        <td>${show.dateAdded}</td>
                        <td>${show.releaseYear}</td>
                        <td>${show.rating}</td>
                        <td>${show.duration}</td>
                        <td>${show.listedIn}</td>

                        <td>
                            <a href="AjouterArticlePanier?id=${show.id}"
                               class=" btn btn-success ">Ajouter</a>
                            <a href="DetailShow?source=client&id=${show.id}"
                               class=" btn btn-success ">Detail</a>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>

        </table>
        <div class="container">
            <div class="row">

                <div class="col-2 mx-auto">
                    <c:if test="${requestScope.currentPage > 1}">

                        <form class="" action="ShowCtr" name="formsPrevious" method="post">

                            <input type="hidden" name="type" value="all">
                            <input type="hidden" name="action" value="PasAdmin">
                            <input type="hidden" name="pays" value="all">
                            <input type="hidden" name="currentPage" value="${requestScope.currentPage-1}">
                            <a>
                                <input class="text-black btn btn-outline-dark" type="submit" value="Page d'avant">
                            </a>
                        </form>

                    </c:if>
                </div>
                <div class="col-3 mx-auto">
                    Page actuelle : <span class="badge badge-warning">${requestScope.currentPage}</span>
                </div>
                <div class="col-2 mx-auto">
                    <c:if test="${requestScope.currentPage != requestScope.nbrPage}">
                        <form action="ShowCtr" name="formsNext" method="post">

                            <input type="hidden" name="type" value="all">
                            <input type="hidden" name="action" value="PasAdmin">
                            <input type="hidden" name="pays" value="all">
                            <input type="hidden" name="currentPage" value="${requestScope.currentPage+1}">
                            <a>
                                <input class="text-black btn btn-outline-dark" type="submit" value="Page suivante">
                            </a>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>

        <br><br>
    </div>
</div>


<%@include file="/includes/footer.jsp" %>
</body>
</html>
