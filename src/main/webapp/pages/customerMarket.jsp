<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Market</title>

    <!--    main css-->
    <style>
        <%@ include file="../css/customerMarket.css"%>
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

    <%--  main script  --%>

</head>
<body>
<jsp:include page="/components/customerNavBar.jsp"/>

<main id="content" class="content">

    <section id="control" class="control sticky-top">
        <div class="container">
            <div class="row justify-content-evenly">
                <div class="col-6">
                    <form class="navbar-search" id="search-bar" action="#" method="get">
                        <div class="input-group search-bar">
                                <span class="input-group-text" id="topbar-addon">
                                  <i class="bi bi-search"></i>
                                </span>
                            <input type="text" class="form-control" id="searchBar" placeholder="Search"
                                   aria-label="Search" aria-describedby="topbar-addon">
                        </div>
                    </form>
                </div>
                <div class="col-6">
                    <button class="btn btn-outline-secondary" id="filter" data-bs-toggle="modal"
                            data-bs-target="#filter-modal">
                        <i class="bi bi-filter fa-lg"></i>
                    </button>
                </div>
            </div>

        </div>
    </section>

    <section id="products" class="products mt-4">
        <div class="container">
            <div class="row">
                <c:choose>
                    <c:when test="${not empty productList}">
                        <c:forEach var="product" items="${productList}">
                            <jsp:include page="/components/productCard.jsp">
                                <jsp:param name="image" value="/shopease/images?productId=${product.id}"/>
                                <jsp:param name="name" value="${product.name}"/>
                                <jsp:param name="description" value="${product.description}"/>
                                <jsp:param name="rating" value="${product.rating}"/>
                                <jsp:param name="price" value="${product.price}"/>
                                <jsp:param name="discount" value="${product.discount}"/>
                                <jsp:param name="quantity" value="${product.quantity}"/>
                                <jsp:param name="checkProduct"
                                           value="/shopease/product/detail?productId=${product.id}"/>
                                <jsp:param name="addToCart" value="/shopease/add/to/cart?productId=${product.id}"/>
                            </jsp:include>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2 class="font-tertiary">No products found.</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>
    <jsp:include page="../components/productFilter.jsp"/>
</main>
</body>
</html>
