<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="../css/productCard.css"%></style>
</head>
<body>
    <div class="col-md-3 mb-4">
        <div class="card h-100 text-decoration-none">
            <!-- Discount badge-->
            <span class="badge bg-danger text-white position-absolute discount-badge" style="top: 0.5rem; right: 0.5rem">${param.discount}</span>
            <!-- Product image-->
            <img class="card-img-top" src="${param.image}" alt="product-image" />
            <!-- Product details-->
            <div class="card-body p-4">
                <div class="text-center">
                    <!-- Product name-->
                    <h5 class="font-primary font-bold">${param.name}</h5>
                    <!-- Product description-->
                    <p class="card-text text-truncate font-tertiary">${param.description}</p>
                    <!-- Product reviews-->
                    <div class="d-flex justify-content-center small text-warning mb-2">
                        <c:forEach begin = "1" end = "${param.rating}">
                            <div class="bi-star-fill"></div>
                        </c:forEach>
                    </div>
                    <!-- Product price-->
<%--                    <span class="text-muted text-decoration-line-through">$20.00</span>--%>
                    ${param.price}
                </div>
                <a href="#" class="stretched-link"></a>
            </div>
            <!-- Product actions-->
            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent ">
                <form action="#addToCart" method="post">
                    <div class="text-center"><button type="submit" class="btn btn-outline-primary mt-auto">Add to cart</button></div>
                </form>
            </div>
        </div>

    </div>

</body>
</html>
