<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/styleIndex.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>

<br><br><br><br>


<div class="container-fluid">
    <div class="row m-4">


        <div class="col-3">


            <div class="card">


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
                            <a class="btn btn-danger" href="">Acheter</a>
                            <a href="AjouterArticlePanier?id=${show.id}"
                               class=" btn btn-success ">Ajouter</a>
                        </td>


                    </tr>


                    </tbody>
                </table>


            </div>

        </div>

        <div class="col-9 mx-auto">

            <iframe class="container-fluid" width="1000" height="500" src="https://www.youtube.com/embed/r9PeYPHdpNo"
                    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay;
            clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

            <iframe class="container-fluid" width="560" height="315" src="https://www.youtube.com/embed/b9EkMc79ZSU"
                    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
                    encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>

    </div>
    <div class="container-fluid">

        <div class="row">
            <div class="col-3 text-center">


                <form action="ShowCtr" method="post">
                    <div class="row">
                        <div class="col-3">
                            <div class="form-group">
                                <br>
                                <select class="form-control form-control-sm" id="pays" name="pays">
                                    <option value="all">All</option>
                                    <option value="usa">Etats-Unis</option>
                                    <option value="canada">Canadien</option>
                                    <option value="recentCanadianTV">More recent canadian TV show</option>
                                    <option>4</option>
                                    <option>5</option>
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
                                    <option>4</option>
                                    <option>5</option>
                                </select>


                            </div>


                        </div>

                        <div class="col">
                            <div class=" mt-4">
                                <input type="hidden" name="action" value="aucune">
                                <button type="submit" class="btn btn-danger">Appliquer</button>
                            </div>
                        </div>


                    </div>
                </form>


            </div>
            <div class="col-3 text-center ">

                <div class="card">


                    <img class="img-fluid"
                         src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABbcCX42tsqGbBvO2y9CQv5-7QvYbCfoHtXsuc6NPCtZaKa4l4fBX3XWvUwG9F2A3CTsNpHVmulxBbdXKwK8Q6xGjejd9FoadGkZ7CnGrSl601TOQjzSHJ23NuIPC8j0QMGORL4uRIA.jpg"
                    />
                </div>
            </div>


            <div class="col-3 text-center">

                <div class="card">
                    <img class="img-fluid"
                         src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABVopDZ5Fy9_fk_HO5WxHTXKKjKhtWFupbSjuvPwfLK_vytzon4EwRUdGgYJ34JwPxOTK_NkV3aXfkULMB0Dcct-FyfqzH-X44VXuRMp4QeBHlvKwWeZFpZlGdItPzmmg4scmwhG7SQ.jpg"
                    />
                </div>

            </div>
            <div class="col-3 text-center ">

                <div class="card">
                    <img class="img-fluid"
                         src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABTOj1-116yVcgKWMU2dI3GFR4x0fSkiGsqtLLeLUxRR7STaksjAqBTrYlTfrB8nIGnGvXksi0ewXAhVGg6-pLxpFOIfcpjK-pf8D5xehFZo5a6vJbo4L0AGbrzglbyUoq255QBJgRQ.jpg"
                    />
                </div>
            </div>

        </div>
    </div>
</div>


<!-- <section class="cc-menu">
    <br><br><br><br>


    <div class="container " style="background-color: black;">

        <form action="ShowCtr" method="post">
            <div class="row">
                <div class="col-3">
                    <div class="form-group">
                        <br>
                        <select class="form-control form-control-sm" id="pays" name="pays">
                            <option value="all">All</option>
                            <option value="usa">Etats-Unis</option>
                            <option value="canada">Canadien</option>
                            <option value="recentCanadianTV">More recent canadian TV show</option>
                            <option>4</option>
                            <option>5</option>
                        </select>

                    </div>

                </div>
                <div class="col-3">

                    <div class="form-group">
                        <br>
                        <select class="form-control form-control-sm" id="type" name="type">
                            <option value="type">Type</option>
                            <option value="kids">Kids</option>
                            <option value="scPhy">Science Fiction</option>
                            <option value="thrillers">Thrillers</option>
                            <option>4</option>
                            <option>5</option>
                        </select>

                    </div>

                </div>


                <div class="col-4 mt-4">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                        <label class="form-check-label text-light" for="inlineCheckbox1">Francais</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                        <label class="form-check-label text-light" for="inlineCheckbox2">Anglais</label>
                    </div>
                </div>
                <div class=" mt-4">
                    <input type="hidden" name="action" value="aucune">
                    <button type="submit" class="btn btn-danger">Appliquer</button>
                </div>


            </div>
        </form>
    </div>


    <br>
    <h1>Nouveauté</h1>
            <br>

    <div class="row" style="width: 100%; margin: auto">


        <div class="container-fluid">
            <div class="row">
                <c:forEach var="show" items="${sessionScope.listeShows}">
                    <div class="col-2 col-md-2 col-sm-6 mx-auto">

                        <a href="DetailShow?source=client&id=${show.id}">

                        <div class="card m-2 mb-4" style="width: 12rem;">
                            <div class="img-holder">
                                <img class="card-img-top"   src="./images/netflixImage.jpg" alt="Card image cap">
                            </div>
                            <div class="card-body">
                                <h5 class="card-title text-center">${show.title}</h5>
                                <p>${show.type}</p>
                                <p>${show.dateAdded}</p>
                                <p>${show.duration}</p>
                            </div>
                        </div>
                        </a>
                    </div>
                </c:forEach>

            </div>
        </div>

    </div>


    <br><br>


</section> -->

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
                                                <input type="hidden" name="source"  value="client">
                                                <input type="hidden" name="id"  value="${show.id}">
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
                                                <input type="hidden" name="source"  value="client">
                                                <input type="hidden" name="id"  value="${show.id}">
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


<%--<section class="cc-menu">--%>
<%--    <br><br><br><br>--%>


<%--    <div class="container " style="background-color: black;">--%>

<%--        <form action="ShowCtr" method="post">--%>
<%--            <div class="row">--%>
<%--                <div class="col-3">--%>
<%--                    <div class="form-group">--%>
<%--                        <br>--%>
<%--                        <select class="form-control form-control-sm" id="pays" name="pays">--%>
<%--                            <option value="all">All</option>--%>
<%--                            <option value="usa">Etats-Unis</option>--%>
<%--                            <option value="canada">Canadien</option>--%>
<%--                            <option value="recentCanadianTV">More recent canadian TV show</option>--%>
<%--                            <option>4</option>--%>
<%--                            <option>5</option>--%>
<%--                        </select>--%>

<%--                    </div>--%>

<%--                </div>--%>
<%--                <div class="col-3">--%>

<%--                    <div class="form-group">--%>
<%--                        <br>--%>
<%--                        <select class="form-control form-control-sm" id="type" name="type">--%>
<%--                            <option value="type">Type</option>--%>
<%--                            <option value="kids">Kids</option>--%>
<%--                            <option value="scPhy">Science Fiction</option>--%>
<%--                            <option value="thrillers">Thrillers</option>--%>
<%--                            <option>4</option>--%>
<%--                            <option>5</option>--%>
<%--                        </select>--%>

<%--                    </div>--%>

<%--                </div>--%>


<%--                <div class="col-4 mt-4">--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">--%>
<%--                        <label class="form-check-label text-light" for="inlineCheckbox1">Francais</label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">--%>
<%--                        <label class="form-check-label text-light" for="inlineCheckbox2">Anglais</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class=" mt-4">--%>
<%--                    <input type="hidden" name="action" value="aucune">--%>
<%--                    <button type="submit" class="btn btn-danger">Appliquer</button>--%>
<%--                </div>--%>


<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>


<%--    <br>--%>
<%--    <h1>Nouveauté</h1>--%>
<%--            <br>--%>

<%--    <div class="row" style="width: 100%; margin: auto">--%>


<%--        <div class="container-fluid">--%>
<%--            <div class="row">--%>
<%--                <c:forEach var="show" items="${sessionScope.listeShows}">--%>
<%--                    <div class="col-2 col-md-2 col-sm-6 mx-auto">--%>

<%--                        <a href="DetailShow?source=client&id=${show.id}">--%>

<%--                        <div class="card m-2 mb-4" style="width: 12rem;">--%>
<%--                            <div class="img-holder">--%>
<%--                                <img class="card-img-top"   src="./images/netflixImage.jpg" alt="Card image cap">--%>
<%--                            </div>--%>
<%--                            <div class="card-body">--%>
<%--                                <h5 class="card-title text-center">${show.title}</h5>--%>
<%--                                <p>${show.type}</p>--%>
<%--                                <p>${show.dateAdded}</p>--%>
<%--                                <p>${show.duration}</p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>

<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>


<%--    <br><br>--%>


<%--</section>--%>
<%--<br><br><br><br><br><br>--%>
<%--<div class="row mt-5">--%>

<%--    <div class="col-12 mt-5">--%>
<%--        <div class="wrapper">--%>
<%--            <section id="section1">--%>
<%--                <a href="#section3" class="arrow__btn">‹</a>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-1567-1123.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABRvngexxF8H1-OzRWFSj6ddD-aB93tTBP9kMNz3cIVfuIfLEP1E_0saiNAwOtrM6xSOXvoiSCMsihWSkW0dq808-R7_lBnr6WHbjkKBX6I3sD0uCcS8kSPbRjEDdG8CeeVXEAEV6spQ.webp"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABZEK-7pZ1H5FD4cTyUb9qB_KeyJGz5p-kfPhCFv4GU_3mbdm8Xfsy4IBchlG9PFNdGff8cBNPaeMra72VFnot41nt0y3e8RLgaVwwh3UvyM2H2_MkmadWbQUeGuf811K7-cxJJh7gA.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABQCoK53qihwVPLRxPEDX98nyYpGbxgi5cc0ZOM4iHQu7KQvtgNyaNM5PsgI0vy5g3rLPZdjGCFr1EggrCPXpL77p2H08jV0tNEmIfs_e8KUfvBJ6Ay5nM4UM1dl-58xA6t1swmautOM.webp"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABdYtAqj8CyaJTWq5taD8Ro_UgwH3nne9QpFGVps-2J3IG-leqrfqXFii4jzZn48nPYTkrlwKQEV0R7_cEKlYBPRzdKqNODc-Oz26IL3LlLgFboXibIWXwxzeYxzuqn0I9TpARjeByw.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABbcCX42tsqGbBvO2y9CQv5-7QvYbCfoHtXsuc6NPCtZaKa4l4fBX3XWvUwG9F2A3CTsNpHVmulxBbdXKwK8Q6xGjejd9FoadGkZ7CnGrSl601TOQjzSHJ23NuIPC8j0QMGORL4uRIA.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <a href="#section2" class="arrow__btn">›</a>--%>
<%--            </section>--%>
<%--            <section id="section2">--%>
<%--                <a href="#section1" class="arrow__btn">‹</a>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABVopDZ5Fy9_fk_HO5WxHTXKKjKhtWFupbSjuvPwfLK_vytzon4EwRUdGgYJ34JwPxOTK_NkV3aXfkULMB0Dcct-FyfqzH-X44VXuRMp4QeBHlvKwWeZFpZlGdItPzmmg4scmwhG7SQ.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABTOj1-116yVcgKWMU2dI3GFR4x0fSkiGsqtLLeLUxRR7STaksjAqBTrYlTfrB8nIGnGvXksi0ewXAhVGg6-pLxpFOIfcpjK-pf8D5xehFZo5a6vJbo4L0AGbrzglbyUoq255QBJgRQ.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/a76057bcfd003711a76fb3985b1f2cf74beee3b8/AAAABd3IBDpxbRcHXvRMFCZeKa2aHLU1P4SJtrACMS9om3yhLjqPlvNlmR_fypPxjtbsbnKaC4JZhPSpDG4r_kdxSHHAltWguMcCB-1Y1OShr2zWfUv7Whf_39fNH5ZJ3_0gxQrs0akmQjQz44_LT7jXH5LMZ7iMBAzac5IEj4m7Fn_5OWEGYnVsDsKG-QTommDooULMDF9bEw.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/a76057bcfd003711a76fb3985b1f2cf74beee3b8/AAAABXSd7bhDddcwkq9XpksoQFCHVx29Sxl_h4hb2n3F2GIt32a4XWcOnctQfgnT5qdolv8UML6_xNB5CJ89h56wueb13mYmEBr0sx5e9iLPdtVcOQAOmKXKWHHXwFvJuCUwuNnL3s8eAQwqLXPVMHMEsujM684rUGrZNF2btN2GRy5-RyEslsxZO93V2Q_H2bWs8A8oayt1h5M.webp"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/a76057bcfd003711a76fb3985b1f2cf74beee3b8/AAAABbXWODpAWqVXcmmjMA7K-2mPkQpvwCLfSdeyhVXzR8A3MSpdSEnnjf4HEJJTYC-TnktU6njTUGAxmzWEYCaJbk4v_ZeL-7QGzmkvYBjg_N-evr2XmcX-Fanoyvu_nimFP4iigPe4O3Vr_WcgplhwkDrJwPUJa84wRLrNAx3TufN5V7cWRP4indqu5HQahvgFEqfL9zjp4g.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <a href="#section3" class="arrow__btn">›</a>--%>
<%--            </section>--%>
<%--            <section id="section3">--%>
<%--                <a href="#section2" class="arrow__btn">‹</a>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABRr4YxdaABuAuH_3FmSQZn7BCvLp-UUPsXE9MiYpvFP3CSUHV2zOew5oVqKqqdaOd3tbFVS0Uf67uIs7_eZydlCghg4nK0nMatRpPImABwTOhnNzCLCxdKrua7pPIcPCZqBYTeAO5g.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABTyWK1MKaw8GcObtz47R2Tj7wkLJ7qQu9tk6TVpcoyxpzD4B-zZ569bQ5vGrREBL-MWFkGilXUwy7tCDaj2XOGkUB4RsbbFAmp9NgSr6lygMpUGNHSlyfrFbUORsRkrxSIoh_ggOvg.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/a76057bcfd003711a76fb3985b1f2cf74beee3b8/AAAABY7NwkWEJIfXsn6t3Li4bGSCQ1nEErPisI5ZZtXlC-_VRBZOUrhWK5X3vt3t6SR_cpgVhCwxgQqFFDJhk62Kk8hawOnYGZMr0LKeLczMFV2zalCFjkcdLksvT4HB2LEi6LFyruyk3Uu0LmNGsHfC2A8Bly60smr_3sDbz4RruXcklPOG1qYq9wUVu3zfaiwNvqmG4b8aFA.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/a76057bcfd003711a76fb3985b1f2cf74beee3b8/AAAABemXHOga9feFnOux6I2YyACBD94wvM7N3vcTGIfMpQ_BcaXeoeM9XyzdVdamKtxt0SHXZfvsl6czcp3E48tXMLtHBxuQsh1BjHtPGgJDZ81je_FjItINiqzLtir0A30s_e4KR8G3d7AYAPDjZVOY97bNpzNqtkcHcGp7fGnJByVCps1uLfG9U9tK3Ma1A_3JbRt0NiT2_Q.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="item">--%>
<%--                    <img--%>
<%--                            src="https://occ-0-243-299.1.nflxso.net/dnm/api/v5/rendition/a76057bcfd003711a76fb3985b1f2cf74beee3b8/AAAABVxuRB932hvre-XP0gh6ar5ztoR3Oe3QjKHkyvcDnRak2MKXOrx5H7mFQSvggefMFOppwEs7ZCCpiqrJ_CYGvtvYB9NpU4SWUtNO6uV2u-DTID267AcHjHcGvGBQJ1ufddDkxcGOZyi5MlOQ5QUmBun4652FbYUnib3zMYQDgcna_Pvz8y_HO5fbokxezrRR1JZAAiqFSQ.jpg"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <a href="#section1" class="arrow__btn">›</a>--%>
<%--                                               </section>>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<br><br><br><br>


<%@include file="/includes/footer.jsp" %>
</body>
</html>