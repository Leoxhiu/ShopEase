<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShopEase</title>

    <!--    main css-->
    <style>
        <%@ include file="../css/main.css"%>
        <%@ include file="../css/landing.css"%>
        <%@ include file="../css/categoryCard.css"%>
    </style>

    <!--    vendor css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <!--  vendor script  -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/aec1025d0d.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>

    <jsp:include page="/components/guestNavBar.jsp" />

    <main id="main">
        <section id="home" class="home">

            <div class="container">
                <div class="row justify-content-evenly">
                    <div class="col-lg-5 d-flex flex-column justify-content-evenly">
                        <h1 class="title font-primary font-bold">Your One-Stop Shop for Online Shopping</h1>
                        <h4 class="subtitle font-tertiary">Discover a Wide Range of Products at Unbeatable Prices - Shop Now and Enjoy Fast, Secure Shipping!</h4>
                        <a class="btn btn-primary btn-lg w-50 explore-button" href="<%= JspPage.SIGN_UP.getUrl() %>">Explore</a>
                    </div>
                    <div class="col-lg-5 d-flex align-items-center justify-content-center svg1">
                        <%@ include file="../images/shopping/web_shopping.svg"%>
                    </div>
                </div>
            </div>

        </section>

        <section id="about" class="about">

            <div class="container">
                <div class="about-container">
                    <div class="row justify-content-evenly">
                        <div class="col-lg-5 d-flex align-items-center justify-content-center svg2">
                            <%@ include file="../images/shopping/delivery.svg"%>
                        </div>
                        <div class="col-lg-5 d-flex flex-column justify-content-evenly">
                            <h2 class="subtitle font-secondary">About Us</h2>
                            <p class="font-tertiary">
                                Welcome to our shopping e-commerce! We're dedicated to providing you with a seamless and enjoyable online shopping experience. We offer a wide selection of high-quality products at competitive prices, and our friendly customer service team is here to help you every step of the way. Thank you for choosing our e-commerce as your go-to destination for all your shopping needs.
                            </p>
                        </div>
                    </div>
                </div>

            </div>

        </section>

        <section id="services" class="services">

            <div class="container">
                <div class="services-container">
                    <h2 class="font-secondary">Services</h2>
                    <p class="font-tertiary">
                        Discover our wide range of top-quality services designed to meet your needs and exceed your expectations.
                    </p>
                </div>

                <div class="services-card">
                    <div class="row justify-content-evenly">
                        <jsp:include page="/components/serviceCard.jsp">
                            <jsp:param name="icon" value="fa-solid fa-truck-fast fa-3x"/>
                            <jsp:param name="title" value="Fast & Reliable"/>
                            <jsp:param name="content" value="Always ensure customers receive their orders in a timely manner."/>
                        </jsp:include>
                        <jsp:include page="/components/serviceCard.jsp">
                            <jsp:param name="icon" value="fa-sharp fa-solid fa-certificate fa-3x"/>
                            <jsp:param name="title" value="High Quality"/>
                            <jsp:param name="content" value="A wide selection of high-quality products to cater to various customer needs and preferences."/>
                        </jsp:include>
                        <jsp:include page="/components/serviceCard.jsp">
                            <jsp:param name="icon" value="fa-sharp fa-solid fa-shield fa-3x"/>
                            <jsp:param name="title" value="Easy & Secure"/>
                            <jsp:param name="content" value="Easy and secure payment methods to provide a hassle-free checkout experience for customers."/>
                        </jsp:include>
                        <jsp:include page="/components/serviceCard.jsp">
                            <jsp:param name="icon" value="fa-solid fa-headset fa-3x"/>
                            <jsp:param name="title" value="Excellent customer service"/>
                            <jsp:param name="content" value="Excellent customer service to address any questions, concerns, or issues that customers may have."/>
                        </jsp:include>
                    </div>
                </div>
            </div>
        </section>

        <section id="market" class="market">
            <div class="container">
                <div class="market-container">
                    <h2 class="font-secondary">Market</h2>
                    <p class="font-tertiary">
                        Discover Endless Possibilities: Explore Our Market of Treasures!
                    </p>
                </div>
                <div class="row ">
                    <jsp:include page="/components/categoryCard.jsp">
                        <jsp:param name="imageUrl1" value="https://i.imgur.com/O0GMYuw.jpg" />
                        <jsp:param name="imageUrl2" value="https://i.imgur.com/ILEU18M.jpg" />
                        <jsp:param name="imageUrl3" value="https://i.imgur.com/2kePJmX.jpg" />
                        <jsp:param name="title" value="Laptops" />
                        <jsp:param name="price" value="Starting from RM 1999" />
                        <jsp:param name="link" value="/shopease/customer/sign-up" />
                    </jsp:include>
                    <jsp:include page="/components/categoryCard.jsp">
                        <jsp:param name="imageUrl1" value="https://i.imgur.com/uRgdVY1.jpg" />
                        <jsp:param name="imageUrl2" value="https://i.imgur.com/VwSKS7A.jpg" />
                        <jsp:param name="imageUrl3" value="https://i.imgur.com/gTvZ2H5.jpg" />
                        <jsp:param name="title" value="Mobiles" />
                        <jsp:param name="price" value="Starting from RM 999" />
                        <jsp:param name="link" value="/shopease/customer/sign-up" />
                    </jsp:include>
                    <jsp:include page="/components/categoryCard.jsp">
                        <jsp:param name="imageUrl1" value="https://i.imgur.com/0jO40CF.jpg" />
                        <jsp:param name="imageUrl2" value="https://i.imgur.com/dWYAg41.jpg" />
                        <jsp:param name="imageUrl3" value="https://i.imgur.com/5oQEZSC.jpg" />
                        <jsp:param name="title" value="Accesories" />
                        <jsp:param name="price" value="Starting from RM 49" />
                        <jsp:param name="link" value="/shopease/customer/sign-up" />
                    </jsp:include>
                </div>
            </div>
        </section>
    </main>

    <footer id="footer">
        <div class="container">
            <div class="footer-container">
                <div class="copyright">
                    Copyright © 2023 <strong><span>ShopEase</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    Designed by Hiu Wen Xuan</a>
                </div>
            </div>
        </div>
    </footer>


</body>
</html>
