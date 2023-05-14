<%@ page import="utility.ServletNavigation" %>
<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopeEase - Admin Home</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/adminHome.css"%>
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
<jsp:include page="/components/adminNavBar.jsp"/>
<main class="container">
    <section class="row">
        <h1 class="font-secondary">User insight</h1>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-people-fill"></i> Total users</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${totalUser}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-person-fill"></i> Total customers</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${totalCustomer}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-person-fill"></i> Total sellers</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${totalSeller}</h1>
                </div>
            </div>
        </div>
    </section>

    <section class="row mt-5">
        <h1 class="font-secondary">Rating insight</h1>
        <div class="col-md-2">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-star-fill"></i> 5 stars products</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${fiveStar}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-star-fill"></i> 4 stars products</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${fourStar}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-star-fill"></i> 3 stars products</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${threeStar}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-star-fill"></i> 2 stars products</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${twoStar}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-star-fill"></i> 1 star products</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${oneStar}</h1>
                </div>
            </div>
        </div>
    </section>

    <section class="row mt-5">
        <h1 class="font-secondary">Product insight</h1>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-grid-fill"></i> Total products</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${totalProduct}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-basket-fill"></i> Total orders</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">${totalOrder}</h1>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-currency-dollar"></i> Total sales</h5>
                </div>
                <div class="card-body">
                    <h1 class="card-text text-center">RM ${totalSales}</h1>
                </div>
            </div>
        </div>
    </section>

    <section class="row mt-4">
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><i class="bi bi-grid-fill"></i> Top rated product</h5>
                </div>
                <c:choose>
                    <c:when test="${not empty topRatedProducts}">
                        <c:forEach var="product" items="${topRatedProducts}">
                            <h3 class="card-text text-center">${product.name}</h3>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h1 class="card-text text-center">No item found.</h1>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <section class="row mt-4 mb-5">
        <div class="col-md-4">
            <a href="<%= ServletPage.CSV_GENERATOR.getUrl() %>" class="btn btn-primary">Download product list</a>
        </div>
    </section>
</main>
</body>
</html>
