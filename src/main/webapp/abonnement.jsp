<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-31
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style.css">
</head>
<body style="background-color: black">
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ApplicationResource"/>

<%@include file="/includes/navbarAcceuil.jsp" %>

<br><br><br>
<!-- La banière d'acceuil -->

<section class="cc-menu d-flex justify-content-center align-items-center">

    <br><br>

    <div class="mx-auto " style="border-radius: 25px;
    background: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75))">



        <main>
            <div class="container">
                <div class="row row-cols-1 row-cols-md-3 mb-3 text-center mx-auto">
                    <div class="col">
                        <div class="card mb-4 rounded-3 shadow-sm">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">6 mois</h4>
                            </div>
                            <div class="card-body">
                                <h1 class="card-title pricing-card-title">$44.99</h1>
                                <ul class="list-unstyled mt-3 mb-4">
                                    <li>10 users included</li>
                                    <li>2 GB of storage</li>
                                    <li>Email support</li>
                                    <li>Help center access</li>
                                </ul>
                                <a href="registerForms.jsp" class="w-100 btn btn-lg btn-outline-primary">S'inscrire</a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card mb-4 rounded-3 shadow-sm">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">Annuel</h4>
                            </div>
                            <div class="card-body">
                                <h1 class="card-title pricing-card-title">$79.99<small class="text-muted fw-light">/an</small></h1>
                                <ul class="list-unstyled mt-3 mb-4">
                                    <li>20 users included</li>
                                    <li>10 GB of storage</li>
                                    <li>Priority email support</li>
                                    <li>Help center access</li>
                                </ul>
                                <a href="registerForms.jsp" class="w-100 btn btn-lg btn-outline-primary">S'inscrire</a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card mb-4 rounded-3 shadow-sm border-primary">
                            <div class="card-header py-3 text-white bg-primary border-primary">
                                <h4 class="my-0 fw-normal">2 ans</h4>
                            </div>
                            <div class="card-body">
                                <h1 class="card-title pricing-card-title">$129.99</h1>
                                <ul class="list-unstyled mt-3 mb-4">
                                    <li>30 users included</li>
                                    <li>15 GB of storage</li>
                                    <li>Phone and email support</li>
                                    <li>Help center access</li>
                                </ul>
                                <a href="registerForms.jsp" class="w-100 btn btn-lg btn-outline-primary">S'inscrire</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </main>





        <br><br>
    </div>

</section>
<br/>

<script src="js/langueChoisie.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
