<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Cart</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/customerCart.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/components/customerNavBar.jsp"/>
<main class="content">
    <div class="container">
        <c:if test="${not empty errorMessage}">
            <script>
                $(function() {
                    $('#error-modal').modal('show');
                });
            </script>
        </c:if>
        <c:if test="${not empty successMessage}">
            <script>
                $(function() {
                    $('#success-modal').modal('show');
                });
            </script>
        </c:if>
        <form action="<%= ServletPage.CUSTOMER_CART.getUrl() %>" method="post">
            <div class="cart-items">
                <c:choose>
                    <c:when test="${not empty cartList}">
                        <c:forEach var="cart" items="${cartList}">
                            <jsp:include page="/components/cartCard.jsp">
                                <jsp:param name="image" value="/shopease/images?productId=${cart.product.id}"/>
                                <jsp:param name="id" value="${cart.id}"/>
                                <jsp:param name="name" value="${cart.product.name}"/>
                                <jsp:param name="price" value="${cart.price}"/>
                                <jsp:param name="quantity" value="${cart.quantity}"/>
                                <jsp:param name="deleteCart" value="/shopease/customer/delete/cart?cartId=${cart.id}"/>
                            </jsp:include>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2 class="font-tertiary">No item found.</h2>
                    </c:otherwise>
                </c:choose>
                <div class="checkout-button text-end">
                    <button type="submit" class="btn btn-primary">Proceed to Checkout</button>
                </div>
            </div>
        </form>
    </div>
</main>
<jsp:include page="../components/successModal.jsp" />
<jsp:include page="../components/errorModal.jsp" />
</body>
</html>
