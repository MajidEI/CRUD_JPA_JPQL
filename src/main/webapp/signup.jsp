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
    <title><fmt:message key="signupTitle" bundle="${resourceBundle}"/></title>
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
    <c:if test="${ errors != null }">
        <div class="alert alert-danger">
            <ul class="mb-0">
                <c:forEach var="error" items="${errors}">
                    <li>
                        <fmt:message key="${error}" bundle="${resourceBundle}"/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form action="inscription" method="POST">
        <div class="form-group">
            <label for="fname"><fmt:message key="prenom"
                                            bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                        type="text" id="fname"
                                                                                        name="fname"
                                                                                        value="${client.prenom}"
                                                                                        required/>
        </div>
        <div class="form-group">
            <label for="lname"><fmt:message key="nom"
                                            bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                        type="text" id="lname"
                                                                                        name="lname"
                                                                                        value="${client.nom}" required/>
        </div>
        <div class=" form-group">
            <label for="address"><fmt:message key="adresse"
                                              bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                          type="text" id="address"
                                                                                          name="address"
                                                                                          value="${requestScope.client.adresse}"
                                                                                          required/>
        </div>
        <div class=" form-group">
            <label for="zip"><fmt:message key="codepostal"
                                          bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                      type="text" id="zip" name="zip"
                                                                                      value="${requestScope.client.codePostal}"/>
        </div>
        <div class=" form-group">
            <label for="city"><fmt:message key="ville"
                                           bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                       type="text" id="city" name="city"
                                                                                       value="${requestScope.client.ville}"/>
        </div>
        <div class=" form-group">
            <label for="phone"><fmt:message key="telephone"
                                            bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                        type="text" id="phone"
                                                                                        name="phone"
                                                                                        value="${requestScope.client.tel}"/>
        </div>
        <div class=" form-group">
            <label for="email"><fmt:message key="email"
                                            bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                        type="email" id="email"
                                                                                        name="email" required/>
        </div>
        <div class="form-group">
            <label for="password"><fmt:message key="password"
                                               bundle="${resourceBundle}"/></label> <input class="form-control"
                                                                                           type="password" id="password"
                                                                                           name="password" required/>
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
