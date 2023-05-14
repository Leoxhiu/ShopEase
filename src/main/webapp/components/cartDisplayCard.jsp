<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="card mb-3">
    <div class="row g-0">
        <div class="col-md-4">
            <img src="${param.image}" class="img-fluid rounded-start" alt="Product Image">
        </div>
        <div class="col-md-8">
            <div class="card-body position-relative">
                <h5 class="card-title">${param.name}</h5>
                <p class="card-text price">Total Price: ${param.price}</p>
                <p class="card-text">Quantity: ${param.quantity}</p>
            </div>
        </div>
    </div>
    <a href="${param.reviewDirect}" class="stretched-link"></a>
</div>
</body>
</html>
