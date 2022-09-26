<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-30
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbarAcceuil.jsp" %>
<br><br><br><br><br>

<!-- La banière d'acceuil -->
<section class="cc-menu d-flex justify-content-center align-items-center">

    <div class="mx-auto">

        <div class="container  ml-4 mr-4 mt-4"
             style="border-radius: 25px;background: linear-gradient(rgba(0, 0, 0, 0.85), rgba(0, 0, 0, 0.85))">

            <div class="row ">


                <form action="Register" method="post" class="needs-validation"
                      style="margin-left: auto; margin-right: auto;">
                    <br>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label class="text-light" for="prenomNew">First name</label>
                            <input type="text" class="form-control" id="prenomNew" name="prenomNew"
                                   placeholder="First name"
                                   value="" required minlength="2"
                                   maxlength="45">
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label class="text-light" for="nomNew">Last name</label>
                            <input type="text" class="form-control" id="nomNew" name="nomNew" placeholder="Last name"
                                   value="" required minlength="2"
                                   maxlength="45">
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label class="text-light" for="emailNew">Email</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                                </div>
                                <input type="email" class="form-control" id="emailNew" name="emailNew"
                                       placeholder="email@gmail.com"
                                       aria-describedby="inputGroupPrepend" required minlength="8" maxlength="45">
                                <div class="invalid-feedback">
                                    Please choose a username.
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label class="text-light" for="adresseNew">Adress</label>
                            <input type="text" class="form-control" id="adresseNew" name="adresseNew"
                                   placeholder="adresse"
                                   required minlength="2"
                                   maxlength="45">
                            <div class="invalid-feedback">
                                Please provide a valid city.
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label class="text-light" for="telephoneNew">Phone</label>
                            <input type="text" class="form-control" id="telephoneNew" name="telephoneNew"
                                   placeholder="phone"
                                   required>
                            <div class="invalid-feedback">
                                Please provide a valid phone Number
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label class="text-light" for="typeAbonnementNew">Type Abonnement</label>
                            <select class="form-control" id="typeAbonnementNew" name="typeAbonnementNew">
                                <option value="annuel">Annuel</option>
                                <option value="3mois">3 mois</option>
                                <option value="6mois">6 mois</option>
                                <option value="2ans">2 ans</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label class="text-light" for="userNameNew">User Name</label>
                            <input type="text" class="form-control" id="userNameNew" name="userNameNew"
                                   placeholder="username"
                                   value="" required minlength="2"
                                   maxlength="45">
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label class="text-light" for="passWordNew">Password</label>
                            <input type="password" class="form-control" id="passWordNew" name="passWordNew"
                                   placeholder="******"
                                   value="" required minlength="5"
                                   maxlength="45"
                                   onchange="verifiedPassword()">
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label class="text-light" for="confirmPassword">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                                   placeholder="******"
                                   value="" required minlength="5"
                                   maxlength="45"
                                    onchange="verifiedPassword()">
                            <div id="messageValidation" class="mt-1 text-center">
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                            <label class="form-check-label text-light" for="invalidCheck">
                                Agree to terms and conditions
                            </label>
                            <div class="invalid-feedback">
                                You must agree before submitting.
                            </div>

                        </div>
                    </div>
                    <div class="text-center">
                        <input type="hidden" name="admin" value="null">
                        <input type="hidden" name="source" value="registerForms">
                        <button class="btn btn-danger" style="width: 30%" type="submit" id="btnSignIn" disabled>SignIn</button>
                    </div>
                    <br>

                </form>

            </div>

        </div>
        <br><br>


    </div>

</section>
<br/>

<%@include file="/includes/footer.jsp" %>
</body>
</html>
