<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Customer Home</title>

    <!--    main css-->
    <style>
        <%@ include file="../css/customerHome.css"%>
    </style>

    <!--    vendor css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

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

<main id="main">
    <section id="carousel" class="carousel">
        <div class="container">
            <div id="carouselIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <a href="<%= JspPage.CUSTOMER_MARKET.getUrl() %>">
                            <img src="/shopease/images/deals/deals1.png" class="d-block w-100" alt="deals">
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="<%= JspPage.CUSTOMER_MARKET.getUrl() %>">
                            <img src="/shopease/images/deals/deals2.png" class="d-block w-100" alt="deals">
                        </a>

                    </div>
                    <div class="carousel-item">
                        <a href="<%= JspPage.CUSTOMER_MARKET.getUrl() %>">
                            <img src="/shopease/images/deals/deals3.png" class="d-block w-100" alt="deals">
                        </a>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselIndicators"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselIndicators"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </section>

    <section id="product" class="product">
        <div class="container">
            <div class="product-container">
                <h2 class="font-secondary">For you</h2>
                <h5 class="font-tertiary">
                    Your Perfect Fit: Discover Products That Match Your Preferences
                </h5>
            </div>

            <div class="product-cards row mt-4">
                <jsp:include page="/components/productCard.jsp">
                    <jsp:param name="image" value="/shopease/images/product/beauty1.jpg"/>
                    <jsp:param name="name" value="First product"/>
                    <jsp:param name="description"
                               value="Some quick example text to build on the card title and make up the bulk of the card's content"/>
                    <jsp:param name="rating" value="5"/>
                    <jsp:param name="price" value="99"/>
                    <jsp:param name="discount" value="50"/>
                </jsp:include>
            </div>

        </div>
    </section>

</main>

<footer>

</footer>

</body>
</html>
