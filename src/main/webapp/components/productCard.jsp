<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../css/productCard.css" %>
    </style>
</head>
<body>
<div class="col-md-3 mb-4">
    <div class="card h-100 text-decoration-none">
        <!-- Discount badge -->
        <c:if test="${param.discount > 0}">
            <span class="badge bg-danger text-white position-absolute discount-badge" style="top: 0.5rem; right: 0.5rem"> -${param.discount}%</span>
        </c:if>
        <!-- Product image -->
        <img class="card-img-top" src="${param.image}" alt="product-image">
        <!-- Product details -->
        <div class="card-body p-4">
            <div class="text-center">
                <!-- Product name -->
                <h5 class="font-primary font-bold">${param.name}</h5>
                <!-- Product description -->
                <p class="card-text text-truncate font-tertiary">${param.description}</p>
                <!-- Product reviews -->
                <div class="d-flex justify-content-center small mb-2">
                    <c:choose>
                        <c:when test="${param.rating == 0}">
                            <span class="text-muted">No Rating</span>
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="1" end="${param.rating}">
                                <i class="bi-star-fill text-warning mr-1 star-icon"></i>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- Product price -->
                <c:choose>
                    <c:when test="${param.discount > 0}">
                        <span class="text-muted text-decoration-line-through">RM ${param.price}</span>
                        RM ${String.format("%.2f", param.price - (param.price * param.discount / 100))}
                    </c:when>
                    <c:otherwise>
                        RM ${param.price}
                    </c:otherwise>
                </c:choose>
            </div>
            <a href="${param.checkProduct}" class="stretched-link"></a>
        </div>
        <!-- Quantity available -->
        <div class="text-center mt-3">
            <p>Quantity Available: ${param.quantity}</p>
        </div>
        <!-- Product actions -->
        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
            <form action="${param.addToCart}" method="post">
                <div class="text-center">
                    <button type="submit" class="btn btn-outline-primary mt-auto">Add to cart</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
