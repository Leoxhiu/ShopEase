<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--    main css-->
    <style><%@ include file="../css/guestNavBar.css"%></style>

    <!--  vendor script  -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- main js-->
    <script><%@ include file="../js/navigationBar.js"%></script>


</head>
<body>
    <div class="navigation_bar">
        <nav class="shadow-sm navbar navbar-expand-lg d-flex">
            <div class="container">
                <a class="navbar-brand font-tertiary brand-text" href="<%= JspPage.LANDING.getUrl() %>">ShopEase</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse"  id="navbarNav">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#services">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#market">Market</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Join as Seller</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0 main-buttons">
                        <li class="nav-but">
                            <a class="btn btn-register" href="<%= JspPage.SIGN_UP.getUrl() %>">Register</a>
                        </li>
                        <li class="nav-but">
                            <a class="btn btn-primary" href="<%= JspPage.SIGN_IN.getUrl() %>">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

</body>
</html>
