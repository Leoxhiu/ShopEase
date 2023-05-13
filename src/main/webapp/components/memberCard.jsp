<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        <%@ include file="../css/memberCard.css"%>
    </style>
</head>
<body>
<div class="col-md-3 mb-4">
    <div class="card h-100 text-decoration-none">
        <!-- User avatar -->
        <div class="text-center mt-3">
            <img class="rounded-circle avatar" src="${param.image}" alt="user-avatar">
        </div>
        <!-- User details -->
        <div class="card-body p-4">
            <div class="text-center">
                <!-- User name -->
                <h5 class="font-primary font-bold">${param.name}</h5>
                <!-- User email -->
                <p class="card-text text-truncate font-tertiary">${param.email}</p>
                <c:choose>
                    <c:when test="${param.userType == 'a'}">
                        <p class="card-text text-primary">ADMIN</p>
                    </c:when>
                    <c:when test="${param.userType == 's'}">
<%--                        <p class="card-text font-tertiary">Balance: ${param.balance}</p>--%>
                        <c:choose>
                            <c:when test="${param.isApproved == '0'}">
                                <p class="card-text text-danger">Not Approved</p>
                            </c:when>
                            <c:when test="${param.isApproved == '1'}">
                                <p class="card-text text-success">Approved</p>
                            </c:when>
                            <c:otherwise>
                                <p></p>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <p></p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <a href="${param.checkMember}" class="stretched-link"></a>
    </div>
</div>
</body>
</html>
