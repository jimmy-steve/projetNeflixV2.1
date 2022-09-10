<!-- La barre de navigation en haut -->
<nav class="cc-navbar navbar navbar-expand-lg position-fixed navbar-dark w-100" style="background-color: black">
    <div class="container-fluid">


        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>


            <section class="h-100 h-custom" style="background-color: black">
                <div class="container py-5 ">
                    <div class="row d-flex justify-content-center align-items-center h-100">


                        <div class="container-fluid">
                            <h5 class="mb-3">
                                <h2 class="text-light">
                                    Liste de Favoris
                                </h2>
                            </h5>
                            <hr>

                            <div class="d-flex justify-content-between align-items-center mb-4 text-light">
                                <div>
                                    <p class="mb-1">test de detail et description</p>
                                    <p class="mb-0">
                                        You have
                                        <span class="badge badge-warning">
                                            ${sessionScope.cart.quantite}
                                        </span>
                                        items in your cart
                                    </p>
                                </div>
                                <div>
                                    <p>Description </p>
                                </div>
                            </div>


                            <table class="table table-hover table-striped table-danger table-bordered text-dark">
                                <thead class="thead-light">

                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Title</th>
                                    <th scope="col" colspan="2" class="text-center">Action</th>
                                </tr>
                                </thead>
                                <c:forEach var="show" items="${sessionScope.listePersonnel}">
                                    <tbody>


                                    <tr>

                                        <td>${show.showId}</td>
                                        <td>${show.title}</td>
                                        <td>
                                            <form action="DetailShow" method="get">
                                                <input type="hidden" name="id" value="${show.id}">
                                                <input type="submit" class="btn-success btn-sm" value="Detail">
                                            </form>
                                        </td>
                                        <td>
                                            <form action="" name="BoutonSupprimerFavoris" method="post">
                                                <input type="submit" class="btn-danger btn-sm" value="Supprimer">
                                            </form>
                                        </td>
                                    </tr>


                                    </tbody>
                                </c:forEach>
                            </table>

                            <br><br>


                            <table class="table table-striped table-hover table-bordered bg-light">
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
                </div>
            </section>


        </div>

        <a class="nav-link mr-4 text-light btn-outline-danger btn" onclick="openNav()" style="margin-right: 10px">Favoris
            V2
            <span class="badge badge-warning">${sessionScope.cart.quantite}</span> </a>


        <a class="navbar-brand text-uppercase fw-bolder mx-4 py-3 ml-5" href="index.jsp"
           style="color: red">Frenchflix </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">


                <li class="nav-item pe-4 mr-4">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Accueil</a>
                </li>

                <li class="nav-item mr-4"><a class="nav-link" href="cart.jsp" style="margin-right: 10px">Cart
                    <span class="badge badge-danger">${sessionScope.cart.quantite}</span> </a></li>

                <li class="nav-item dropdown pe-4 mr-4">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        TOP
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li>
                            <form action="AffTopFilms" method="post">
                                <button type="submit" class="dropdown-item">TOP 12</button>
                            </form>
                        </li>
                        <li><a class="dropdown-item" href="#">News</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>


                <li class="nav-item dropdown pe-4 mr-4">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Abonnement
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Jeux</a></li>

                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">New</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <form action="ShowCardSpecial" name="forms1" method="post">
                        <div class="text-center">
                            <input type="hidden" name="type" value="all">
                            <input type="hidden" name="action" value="PasAdmin">
                            <input type="hidden" name="pays" value="all">
                            <a>
                                <button type="submit" style="background-color: black;" class="nav-link text-light btn">
                                    Special Edition
                                </button>
                            </a>
                        </div>
                    </form>
                </li>

                <li class="nav-item">
                    <form action="ShowCtr" name="forms1" method="post">
                        <div class="text-center">
                            <input type="hidden" name="type" value="all">
                            <input type="hidden" id="action" name="action" value="PasAdmin">
                            <input type="hidden" name="pays" value="all">
                            <a>
                                <input class="nav-link text-light btn " style="margin-right: 10px" type="submit"
                                       value="Liste "/>
                            </a>

                        </div>
                    </form>
                </li>


                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>


                <li class="nav-item">

                    <div class="text-center">
                        <form action="LogOut" method="post">
                            <button href="Acceuil.jsp" class=" btn btn-outline-danger ml-2 mr-2" type="submit"
                                    style="margin-right: 10px">
                                LogOut
                            </button>
                        </form>
                    </div>
                </li>

            </ul>

        </div>
    </div>
</nav>



