<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<!-- La barre de navigation en haut -->
<nav class="cc-navbar navbar navbar-expand-lg position-fixed navbar-dark w-100" style="background-color: black">
    <div class="container-fluid">
        <a class="navbar-brand text-uppercase fw-bolder mx-4 py-3 ml-5" href="index.jsp" style="color: red">Netflix Admin</a>
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
                <li class="nav-item dropdown pe-4 mr-4">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        TOP
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">TOP 12</a></li>
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



                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>


                <li class="nav-item">

                    <div class="text-center">
                        <a href="Acceuil.jsp" class=" btn btn-outline-danger ml-2 mr-2" style="margin-right: 10px">
                            LogOut
                        </a>
                    </div>
                </li>

            </ul>

        </div>
    </div>
</nav>




