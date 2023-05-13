<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a class="btn btn-danger position-absolute top-0 end-0 m-2" href="${param.deleteCart}" type="submit">
                    <i class="bi bi-x"></i>
                </a>
                <h5 class="card-title">${param.name}</h5>
                <p class="card-text">Total Price: ${param.price}</p>
                <p class="card-text">Quantity: ${param.quantity}</p>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="selectedCarts" value="${param.id}">
                    <label class="form-check-label">Select</label>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
