<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <fmt:setBundle basename="ma.ensa.Resources.messages"
                   var="resourceBundle"/>

    <meta charset="utf-8">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous"/>
    <title><fmt:message key="loginTitle" bundle="${resourceBundle}"/></title>
</head>

<body>
<header>
    <nav class="navbar sticky-top navbar-expand-md navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="collapsingNavbar">
            <ul class="navbar-nav ml-auto">
                <c:if test="${empty sessionScope.client}">
                    <li class="nav-item">
                        <a href="identification" class="btn btn-primary active mr-3" role="button"
                           aria-pressed="true"><fmt:message key="loginTitle" bundle="${resourceBundle}"/></a>
                    </li>
                    <li class="nav-item">
                        <a href="inscription" class="btn btn-warning active" role="button"
                           aria-pressed="true"><fmt:message key="signupTitle" bundle="${resourceBundle}"/></a>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.client}">
                    <li class="nav-item">
                        <a href="deconnexion" class="btn btn-danger active" role="button"
                           aria-pressed="true"><fmt:message key="logout" bundle="${resourceBundle}"/></a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>
<div class="container mt-4">


    <div>
        <a class="h6" href="index.jsp">&larr;<fmt:message key="retour"
                                                          bundle="${resourceBundle}"/></a><br>
    </div>
    <c:if test="${not empty sessionScope.msgErreur}">
        <div class="alert alert-danger alert-dismissible fade show"
             role="alert">
            <c:if test="${sessionScope.msgErreur eq 'nonExistant'}">
                <strong><fmt:message key="nonexistant" bundle="${resourceBundle}"/></strong>
            </c:if>
            <c:if test="${sessionScope.msgErreur eq 'other'}">
                <strong><fmt:message key="erreur" bundle="${resourceBundle}"/></strong>
            </c:if>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <c:remove var="msgErreur" scope="session"/>
    </c:if>
    <form action="identification" method="POST">
        <div class="form-group">
            <label for="email"><fmt:message key="email" bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                                    type="email"
                                                                                                    id="email"
                                                                                                    name="email"
                                                                                                    required/><br/>
        </div>
        <div class="form-group">
            <label for="password"><fmt:message key="password" bundle="${resourceBundle}"/></label> <input
                class="form-control"
                type="password" id="password"
                name="password"
                required/><br/>
        </div>
        <button type="submit" class="btn btn-primary">
            <fmt:message key="valider" bundle="${resourceBundle}"/>
        </button>
    </form>
</div>
<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>
</html>
