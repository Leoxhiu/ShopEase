<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShopEase</title>

    <!--    main css-->
    <style>
      <%@ include file="../css/main.css"%>
      <%@ include file="../css/market.css"%>
    </style>

    <!--    vendor css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <!--  vendor script  -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/aec1025d0d.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%--  main script  --%>

</head>
<body>
    <jsp:include page="/components/customerNavBar.jsp" />

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
                                <input type="text" class="form-control" id="searchBar" placeholder="Search" aria-label="Search" aria-describedby="topbar-addon">
                            </div>
                        </form>
                    </div>
                    <div class="col-6">
                        <button class="btn btn-outline-secondary" id="filter" data-bs-toggle="modal" data-bs-target="#filter-modal">
                            <i class="bi bi-filter fa-lg"></i>
                        </button>
                    </div>
                </div>

            </div>
        </section>

        <section id="products" class="products mt-4">
            <div class="container">
                <div class="row">
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

        <jsp:include page="../components/productFilter.jsp" />

    </main>
</body>
</html>
