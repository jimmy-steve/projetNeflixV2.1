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

        <h1 class="text-light text-center"><fmt:message key="message.intro1"/></h1>
        <h1 class="text-light text-center"><fmt:message key="message.intro2"/></h1>
        <br>
        <h4 class="text-light text-center"><fmt:message key="message.intro3"/></h4>
        <h5 class="text-light text-center m-3"><fmt:message key="message.intro4"/></h5>
        <br><br><br><br><br>
        <form action="UserNameLogin" method="post">
            <div class="input-group mb-3 col-7 mx-auto input-group-lg">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">@</span>
                </div>
                <input type="text" class="form-control" id="username" name="username"
                       placeholder="<fmt:message key="placeholder"/>"
                       aria-label="Large" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button class="btn btn-danger" type="submit"><fmt:message key="btn.debuter"/></button>
                </div>
            </div>
        </form>
        <br><br>
    </div>

</section>
<br/>

<script src="js/langueChoisie.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
