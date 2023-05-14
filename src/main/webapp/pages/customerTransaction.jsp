<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Transaction</title>

    <!--    main css-->
    <style>
        <%@ include file="../css/customerTransaction.css"%>
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
    <div class="container">
        <h1 class="font-secondary">Purchase history</h1>
        <div class="row">
            <c:choose>
                <c:when test="${not empty customerOrderList}">
                    <c:forEach var="customerOrder" items="${customerOrderList}">
                        <c:set var="totalItem" value="${0}" />
                        <c:set var="amount" value="${customerOrder.amount}" />
                        <c:set var="date" value="${customerOrder.date}" />
                        <c:set var="checkTransaction" value="/shopease/customer/transaction/detail?customerOrderId=${customerOrder.id}" />

                        <c:forEach var="orderCart" items="${orderCartList}">
                            <c:if test="${orderCart.customerOrder.id eq customerOrder.id}">
                                <c:set var="totalItem" value="${totalItem + 1}" />
                            </c:if>
                        </c:forEach>

                        <jsp:include page="/components/transactionCard.jsp">
                            <jsp:param name="totalItem" value="${totalItem}"/>
                            <jsp:param name="amount" value="${amount}"/>
                            <jsp:param name="date" value="${date}"/>
                            <jsp:param name="checkTransaction" value="${checkTransaction}"/>
                        </jsp:include>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2 class="font-tertiary">No transaction found.</h2>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</main>
</body>
</html>
