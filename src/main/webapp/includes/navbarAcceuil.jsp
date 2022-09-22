<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-31
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<!-- La barre de navigation en haut -->
<nav class="cc-navbar navbar navbar-expand-lg position-fixed navbar-dark w-100" style="background-color: black">
    <div class="container-fluid">
        <a class="navbar-brand text-uppercase fw-bolder mx-4 py-3 ml-5" href="Acceuil.jsp"
           style="color: red">FrenchFlix </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                <li class="nav-item pe-4">
                    <fmt:setBundle basename="ApplicationResource"/>
                    <fmt:setLocale value="${sessionScope.langue}"/>
                    <form name="formLangue" action="ChoixLangue" method="get">
                        <select class="form-select text-light text-center active mr-4 btn btn-secondary"
                                aria-label="Default select example" name="langue" id="FonctionLangue" onchange="submit()">
                            <option value="fr_CA"><fmt:message key="form.langue"/></option>
                            <option value="en_US"><fmt:message key="form.anglais"/></option>
                            <option value="es_ES"><fmt:message key="form.espagnol"/></option>
                            <option value="fr_CA"><fmt:message key="form.francais"/></option>
                        </select>
                        <input type="hidden" name="src" value="1"/>
                    </form>
                </li>

                <li class="nav-item pe-4">
                    <a class="nav-link active mr-4" aria-current="page" href="Acceuil.jsp">
                        <fmt:message key="menu.accueil"/>
                    </a>
                </li>

                <li class="nav-item dropdown pe-4">
                    <a class="nav-link dropdown-toggle mr-4" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <fmt:message key="menu.abonnement"/>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">
                            <fmt:message key="menu.forfait"/>
                        </a></li>
                    </ul>
                </li>


                <li class="nav-item">

                    <div class="text-center">
                        <a href="formulaireLogin.jsp" class=" btn btn-danger ml-2 mr-2" style="margin-right: 10px">
                            <fmt:message key="btn.seconnecter"/>
                        </a>
                        <a href="registerForms.jsp" class=" btn btn-outline-danger ml-2 mr-2" style="margin-right: 10px">
                            <fmt:message key="btn.sinscrire"/>
                        </a>
                    </div>
                </li>

            </ul>

        </div>
    </div>
</nav>