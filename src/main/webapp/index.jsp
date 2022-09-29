<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/styleIndex.css">
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>

<br><br><br><br>

<c:if test="${listFavoris.size < 0 }">
    <br><br><br><br><br><br>
    <div class="alert alert-success alert-dismissible fade show container" role="alert">
        <h3 class="text-center"><strong>Vous avez ajouter un article a votre panier ! ! </strong></h3>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<c:set var="Num1" value="10" scope="page"/>


<div class="container-fluid">
    <div class="row m-4">


        <div class="col-3">


            <div class="card">

                <c:if test="${show.id > 0 }">
                    <table class="table table-striped table-hover table-bordered ">
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
                            <td>${show.type}</td>
                        </tr>
                        <tr>
                            <th scope="row">Title :</th>
                            <td>${show.title}</td>
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

                        <tr class="text-center">
                            <td colspan="2" class="text-center">
                                <a href="AjouterArticlePanier?id=${show.id}"
                                   class=" btn btn-success ">Ajouter</a>
                            </td>
                        </tr>


                        </tbody>
                    </table>
                </c:if>
                <c:if test="${show.id <= 0 || show.id == null}">

                    <c:if test="${suppressionFavoris != null}">
                        <br>
                        <div class="container">
                            <div class="alert alert-danger alert-dismissible fade show container" role="alert">
                                <h4 class="alert-heading">Well done!</h4>
                                <p>Vous venez de supprimer un film à votre liste de favoris</p>
                                <hr>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${confirmationFavoris != null}">
                        <br>
                        <div class="container">
                            <div class="alert alert-success alert-dismissible fade show container" role="alert">
                                <h4 class="alert-heading">Well done!</h4>
                                <p>Vous venez d'ajouter un film à votre liste de favoris</p>
                                <hr>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>
                    </c:if>

                    <blockquote class="blockquote mb-0 card-body">
                        <p>Bonjour ${user.username} !! </p>
                        <p>Bienvenue sur votre portail.</p>
                        <p>Vous pouvez ...</p>
                        <ul>
                            <li>Ajouter à vos favoris</li>
                            <li>Voir les détails</li>
                            <li>Voir les nouveautées</li>
                        </ul>
                        <footer class="blockquote-footer">
                            <small class="text-muted">
                                Someone famous in <cite title="Source Title">Source Title</cite>
                            </small>
                        </footer>
                    </blockquote>

                    <div class="card">
                        <div class="card-header my-3 bg-dark text-light">Faire une recherche</div>
                        <form action="ShowCtr" method="post">
                            <div class="row">
                                <div class="col-3 mx-auto">
                                    <div class="form-group">
                                        <br>
                                        <select class="form-control form-control-sm" id="pays" name="pays">
                                            <option value="all">All</option>
                                            <option value="usa">Etats-Unis</option>
                                            <option value="canada">Canadien</option>
                                            <option value="recentCanadianTV">More recent canadian TV show</option>
                                            <option value="chinese" >Chinois</option>
                                        </select>

                                    </div>

                                </div>
                                <div class="col-4">

                                    <div class="form-group">
                                        <br>
                                        <select class="form-control form-control-sm mx-auto" id="type" name="type">
                                            <option value="type">Type</option>
                                            <option value="kids">Kids</option>
                                            <option value="scPhy">Science Fiction</option>
                                            <option value="thrillers">Thrillers</option>
                                        </select>


                                    </div>


                                </div>

                                <div class="col">
                                    <div class=" mt-4">
                                        <input type="hidden" name="action" value="PasAdmin">
                                        <input type="hidden" name="currentPage" value="${requestScope.currentPage+1}">
                                        <button type="submit" class="btn btn-danger">Appliquer</button>
                                    </div>
                                </div>


                            </div>
                        </form>
                    </div>


                </c:if>


            </div>

        </div>

        <div class="col-9 mx-auto">

            <iframe class="container-fluid" width="1000" height="500"
                    src="https://www.youtube.com/embed/r9PeYPHdpNo"
                    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay;
            clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

            <iframe class="container-fluid" width="1000" height="500" src="https://www.youtube.com/embed/b9EkMc79ZSU"
                    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
                    encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>

    </div>
    <div class="container-fluid">

        <div class="row">
            <div class="col-3 text-center">
                <a href="DetailShow?source=client&id=376">
                    <div class="card">
                        <img class="img-fluid"
                             src="https://www.escapistmagazine.com/wp-content/uploads/2020/07/inception1-702x395.jpg.webp"
                        />
                    </div>
                </a>
            </div>
            <div class="col-3 text-center ">
                <a href="DetailShow?source=client&id=54">
                    <div class="card">
                        <img class="img-fluid"
                             src="https://www.denofgeek.com/wp-content/uploads/2021/09/squid-game-anime-comic-manga-source-material.jpeg?fit=1440%2C1080"
                        />
                    </div>
                </a>
            </div>


            <div class="col-3 text-center">
                <a href="DetailShow?source=client&id=740">
                    <div class="card">
                        <img class="img-fluid"
                             src="https://www.denofgeek.com/wp-content/uploads/2019/12/fast-and-furious-spy-racers-scaled.jpg?resize=768%2C432"
                        />
                    </div>
                </a>
            </div>
            <div class="col-3 text-center ">
                <a href="DetailShow?source=client&id=122">
                    <div class="card">
                        <img class="img-fluid"
                             src="https://img.phonandroid.com/2020/04/casa-de-papel-saison-4.jpg"
                        />
                    </div>
                </a>
            </div>

        </div>
    </div>
</div>


<%--Section pour la bande défilante en bas de la page--%>

<div class="row">

    <div class="col-12 mt-5">
        <div class="wrapper">
            <section id="section1">

                <a href="#section3" class="arrow__btn">‹</a>
                <c:forEach var="show" items="${sessionScope.listTop5}">

                    <div class="item">

                        <div class="card ">

                            <div class="card-body">
                                <h5 class="card-title text-center">${show.title}</h5>
                                <table class="table-sm text-center"
                                       style="width: 85%; margin-left: auto; margin-right: auto" cellspacing="1"
                                       cellpadding="1">
                                    <thead>
                                    <tr>
                                        <th colspan="2" class="text-center">${show.description}</th>
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
                                    <tr class="text-center">
                                        <td colspan="2" class="text-center">
                                            <form action="DetailShow" method="get">
                                                <input type="hidden" name="source" id="source" value="client">
                                                <input type="hidden" name="id" id="id" value="${show.id}">
                                                <button class="btn btn-primary" type="submit">Voir Detail</button>
                                            </form>
                                        </td>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div>

                </c:forEach>
                <a href="#section2" class="arrow__btn">›</a>
            </section>
            <section id="section2">
                <a href="#section1" class="arrow__btn">‹</a>
                <c:forEach var="show" items="${sessionScope.listTop5ScienceFiction}">


                    <div class="item">

                        <div class="card ">

                            <div class="card-body">
                                <h5 class="card-title text-center">${show.title}</h5>
                                <table class="table-sm text-center"
                                       style="width: 85%; margin-left: auto; margin-right: auto" cellspacing="1"
                                       cellpadding="1">
                                    <thead>
                                    <tr>
                                        <th colspan="2" class="text-center">${show.description}</th>
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
                                    <tr class="text-center">
                                        <td colspan="2" class="text-center">
                                            <form action="DetailShow" method="get">
                                                <input type="hidden" name="source" value="client">
                                                <input type="hidden" name="id" value="${show.id}">
                                                <button class="btn btn-primary" type="submit">Voir Detail</button>
                                            </form>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                </c:forEach>
                <a href="#section3" class="arrow__btn">›</a>
            </section>


            <section id="section3">
                <a href="#section2" class="arrow__btn">‹</a>
                <c:forEach var="show" items="${sessionScope.listeShowsFantasy}">

                    <div class="item">

                        <div class="card ">

                            <div class="card-body">
                                <h5 class="card-title text-center">${show.title}</h5>
                                <table class="table-sm text-center"
                                       style="width: 85%; margin-left: auto; margin-right: auto" cellspacing="1"
                                       cellpadding="1">
                                    <thead>
                                    <tr>
                                        <th colspan="2" class="text-center">${show.description}</th>
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

                                    <tr class="text-center">
                                        <td colspan="2" class="text-center">
                                            <form action="DetailShow" method="get">
                                                <input type="hidden" name="source" value="client">
                                                <input type="hidden" name="id" value="${show.id}">
                                                <button class="btn btn-primary" type="submit">Voir Detail</button>
                                            </form>
                                        </td>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                </c:forEach>
                <a href="#section1" class="arrow__btn">›</a>
            </section>
        </div>
    </div>
</div>
<br><br><br><br>
<%@include file="/includes/footer.jsp" %>
</body>
</html>