<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="card bg-light mt-3">
    <div class="card-body d-flex justify-content-between align-items-center">
        <div>
            <h2 class="card-title display-5 text-primary">${param.totalItem} items</h2>
            <p class="card-text small"><fmt:parseDate value="${param.date}" var="parsedDate" pattern="yyyy-MM-dd'T'HH:mm:ss" /></p>
            <p><fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd hh:mm a" /></p>

        </div>
        <p class="card-text h4 text-danger">-RM ${param.amount}</p>
    </div>
    <a href="${param.checkTransaction}" class="stretched-link"></a>
</div>
</body>
</html>
