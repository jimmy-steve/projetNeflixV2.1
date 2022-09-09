<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-30
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbarAdmin.jsp" %>
<br><br><br>

<div class="container-fluid">

    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <h3 class="text-center"><strong>Great guacamole
            ! </strong>Votre client ayant comme nom ${client.prenom} ${client.nom}
            et comme Id ${client.idClient} a été sauvegardé avec succès</h3>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>


</div>


<div class="container">


</div>


<%@include file="/includes/footer.jsp" %>
</body>
</html>
