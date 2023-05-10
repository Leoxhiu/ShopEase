<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="utility.JspPage" %>
<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopeEase - Admin Auth</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/adminSignIn.css"%>
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
<section>
    <div class="container mt-5 pt-5">
        <div class="row">
            <div class="col-12 col-sm-7 col-md-6 m-auto">
                <div class="card border-0 shadow">
                    <div class="text-center mt-5">
                        <h1 class="font-primary">ShopEase Admin</h1>
                        <i class="bi bi-key-fill text-primary" style="font-size: 5rem;"></i>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty errorMessage}">
                            <script>
                                $(function () {
                                    $('#error-modal').modal('show');
                                });
                            </script>
                        </c:if>
                        <form action="<%= ServletPage.ADMIN_SIGN_IN.getUrl() %>" method="post">
                            <input type="email" name="email" id="email" class="form-control my-4 py-2" placeholder="Email"/>
                            <input type="password" name="password" id="password" class="form-control my-4 py-2" placeholder="Password"/>
                            <div class="text-center mt-3">
                                <button class="btn btn-primary">Sign In</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../components/errorModal.jsp"/>
</body>


</html>
