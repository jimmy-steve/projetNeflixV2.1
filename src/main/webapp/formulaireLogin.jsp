<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbarAcceuil.jsp" %>



<!-- La banière d'acceuil -->
<section class="cc-menu d-flex justify-content-center align-items-center">

    <div class="mx-auto">


        <!-- module de connexion -->
        <div class="container-fluid">
            <div class="row ">
                <div id="login">
                    <div class="container card rounded-3" style="background: linear-gradient(rgba(0, 0, 0, 0.85), rgba(0, 0, 0, 0.85))">
                        <div id="login-row" class="row justify-content-center align-items-center">
                            <div id="login-column" class="col-md-12">
                                <div id="login-box" class="col-md-12 rounded-3">

                                    <form name="loginform" id="login-form" class="form" action="Login"
                                          method="post">

                                        <h3 class="text-center text-danger mt-5">Connexion</h3>
                                        <div class="form-group">
                                            <label for="username" class="text-light">Username:</label><br>
                                            <input value="${username}" placeholder="username" type="text" name="username" id="username" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="password" class="text-light">Password:</label><br>
                                            <input placeholder="1234" type="text" name="password" id="password" class="form-control">
                                        </div>


                                        <br>
                                        <div class="form-group text-center">
                                            <input class="btn btn-danger btn-md text-uppercase" type="submit" value="Login"
                                                   id="submit" />

                                        </div>
                                        <br>
                                        <div id="register-link" class="text-right">
                                            <a href="registerForms.jsp" class="text-primary ">Register here</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </div>

</section>
<br/>


<%@include file="/includes/footer.jsp" %>
</body>
</html>