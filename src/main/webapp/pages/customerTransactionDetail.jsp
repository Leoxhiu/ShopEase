<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Transaction Detail</title>

    <!--    main css-->
    <style>
        <%@ include file="../css/customerTransactionDetail.css"%>
    </style>

    <!--    vendor css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <!--  vendor script  -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/aec1025d0d.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/components/customerNavBar.jsp"/>
<main>
    <section>
        <div class="container">
            <h1 class="font-secondary">Order detail</h1>
            <div class="row">
                <jsp:include page="/components/transactionCard.jsp">
                    <jsp:param name="totalItem" value="${totalItem}"/>
                    <jsp:param name="amount" value="${amount}"/>
                    <jsp:param name="date" value="${date}"/>
                </jsp:include>
            </div>
        </div>
    </section>
    <section>
        <div class="container mt-4">
            <c:choose>
                <c:when test="${not empty cartList}">
                    <c:forEach var="cart" items="${cartList}">
                        <jsp:include page="/components/cartDisplayCard.jsp">
                            <jsp:param name="image" value="/shopease/images?productId=${cart.product.id}"/>
                            <jsp:param name="name" value="${cart.product.name}"/>
                            <jsp:param name="price" value="${cart.price}"/>
                            <jsp:param name="quantity" value="${cart.quantity}"/>
                            <jsp:param name="reviewDirect" value="/shopease/customer/review/detail?cartId=${cart.id}"/>
                        </jsp:include>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2 class="font-tertiary">Some errors occured when displaying the items.</h2>
                </c:otherwise>
            </c:choose>
        </div>
    </section>
</main>
</body>
</html>
