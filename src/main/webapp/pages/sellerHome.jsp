<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Seller Home</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/sellerHome.css"%>
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
<jsp:include page="/components/sellerNavBar.jsp"/>
<main class="container">
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
</main>
</body>
</html>
