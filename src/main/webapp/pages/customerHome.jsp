<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShopEase</title>

    <!--    main css-->
    <style>
        <%@ include file="../css/main.css"%>
        <%@ include file="../css/customerHome.css"%>
    </style>

    <!--    vendor css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <!--  vendor script  -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/aec1025d0d.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%--  main script  --%>

</head>
<body>
    <jsp:include page="/components/customerNavBar.jsp" />

    <main id="main">
        <section id="carousel" class="carousel">
            <div class="container">
                <div id="carouselIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <a href="<%= JspPage.MARKET.getUrl() %>">
                                <img src="${pageContext.request.contextPath}/images/deals/deals1.png" class="d-block w-100" alt="deals">
                            </a>
                        </div>
                        <div class="carousel-item">
                            <a href="<%= JspPage.MARKET.getUrl() %>">
                                <img src="${pageContext.request.contextPath}/images/deals/deals2.png" class="d-block w-100" alt="deals">
                            </a>

                        </div>
                        <div class="carousel-item">
                            <a href="<%= JspPage.MARKET.getUrl() %>">
                                <img src="${pageContext.request.contextPath}/images/deals/deals3.png" class="d-block w-100" alt="deals">
                            </a>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselIndicators" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselIndicators" data-bs-slide="next">
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
                        <jsp:param name="image" value="${pageContext.request.contextPath}/images/product/beauty1.jpg"/>
                        <jsp:param name="name" value="First product"/>
                        <jsp:param name="description" value="Some quick example text to build on the card title and make up the bulk of the card's content"/>
                        <jsp:param name="rating" value="5"/>
                        <jsp:param name="price" value="RM 99"/>
                        <jsp:param name="discount" value="50%"/>
                    </jsp:include>
                    <jsp:include page="/components/productCard.jsp">
                        <jsp:param name="image" value="${pageContext.request.contextPath}/images/product/beauty3.jpg"/>
                        <jsp:param name="name" value="Second product"/>
                        <jsp:param name="description" value="Some quick example text to build on the card title and make up the bulk of the card's content"/>
                        <jsp:param name="rating" value="4"/>
                        <jsp:param name="price" value="RM 599"/>
                        <jsp:param name="discount" value="50%"/>
                    </jsp:include>
                    <jsp:include page="/components/productCard.jsp">
                        <jsp:param name="image" value="${pageContext.request.contextPath}/images/product/beauty1.jpg"/>
                        <jsp:param name="name" value="Third product"/>
                        <jsp:param name="description" value="Some quick example text to build on the card title and make up the bulk of the card's content"/>
                        <jsp:param name="rating" value="2"/>
                        <jsp:param name="price" value="RM 99999"/>
                        <jsp:param name="discount" value="20%"/>
                    </jsp:include>
                    <jsp:include page="/components/productCard.jsp">
                        <jsp:param name="image" value="${pageContext.request.contextPath}/images/product/beauty2.jpg"/>
                        <jsp:param name="name" value="Fourth product"/>
                        <jsp:param name="description" value="Introducing the all-new 'LuxeGlo' Wireless Earbuds! These sleek and stylish earbuds are designed for the modern music lover who demands high-quality audio and seamless connectivity. With advanced Bluetooth 5.0 technology, the 'LuxeGlo' Earbuds provide crystal-clear sound and deep bass, allowing you to immerse yourself in your favorite tunes like never before."/>
                        <jsp:param name="rating" value="1"/>
                        <jsp:param name="price" value="RM 999"/>
                        <jsp:param name="discount" value="50%"/>
                    </jsp:include>
                </div>

            </div>
        </section>

        <section id="seller" class="seller">
            <div class="container">
                <div class="services-container">
                    <h2 class="font-secondary">Recommended Seller</h2>
                    <p class="font-tertiary">
                        Discover our wide range of top-quality services designed to meet your needs and exceed your expectations.
                    </p>
                </div>
            </div>
        </section>

    </main>

    <footer>

    </footer>

</body>
</html>
