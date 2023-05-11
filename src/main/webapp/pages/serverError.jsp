<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Server Error</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/serverError.css"%>
    </style>

    <!--    vendor css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <!--  vendor script  -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <div class="d-flex align-items-center justify-content-center mt-5">
        <%@include file="../images/page/serverError.svg" %>
    </div>
</div>
<div class="container text-center mt-5">
    <h1 class="font-primary">Server Error</h1>
    <h4 class="font-tertiary">Strange...Something is wrong...</h4>
    <a type="button" class="btn btn-primary btn-lg mx-2 mt-3" href="<%= JspPage.LANDING.getUrl() %>">Home</a>
</div>
</body>
</html>