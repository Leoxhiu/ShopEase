<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="card">
    <div class="card-body d-flex">
        <div class="user-profile">
            <img src="${param.image}" alt="User Profile" class="rounded-circle" style="width: 50px; height: 50px;">
        </div>
        <div class="user-info ms-3">
            <h5 class="card-title mb-0 font-bold font-secondary">${param.name}</h5>
            <p class="card-text">${param.comment}</p>
        </div>
    </div>
</div>
</body>
</html>
