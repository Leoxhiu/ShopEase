<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="utility.JspPage" %>
<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp"%>
    <title>ShopEase - Reset Password</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/resetPassword.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<%
    String email = (String) session.getAttribute("email");
    if(email == null){
        response.sendRedirect(JspPage.LANDING.getUrl());
    }
%>
<main>
    <!-- Section -->
    <section class="vh-lg-100 mt-5 mt-lg-0 bg-soft d-flex align-items-center">
        <div class="container">
            <div class="row justify-content-evenly">

                <div class="col-lg-7 d-flex align-items-center justify-content-center">
                    <%@ include file="../images/others/password.svg" %>
                </div>

                <div class="col-lg-5">
                    <div class="row justify-content-center">
                        <div class="col-12 d-flex align-items-center justify-content-center main-form">
                            <div class="bg-white shadow border-0 rounded border-light p-4 p-lg-5 w-100 fmxw-500">
                                <div class="text-center text-md-center mb-4 mt-md-0">
                                    <h3 class="mb-0 font-bold font-secondary"> Reset Password</h3>
                                </div>
                                <c:if test="${not empty errorMessage}">
                                    <script>
                                        $(function() {
                                            $('#error-modal').modal('show');
                                        });
                                    </script>
                                </c:if>
                                <c:if test="${not empty successMessage}">
                                    <script>
                                        $(function() {
                                            $('#success-modal').modal('show');
                                        });
                                    </script>
                                </c:if>
                                <form action="<%= ServletPage.RESET_PASSWORD.getUrl() %>" method="post" class="mt-4">
                                    <div class="form-group">
                                        <!-- Form -->
                                        <div class="form-group mb-4">
                                            <label for="password">New Password</label>
                                            <div class="input-group">
                                                <span class="input-group-text">
                                                    <i class="bi bi-lock-fill"></i>
                                                </span>
                                                <input type="password" placeholder="Password" class="form-control" id="password" name="password" required>
                                            </div>
                                        </div>
                                        <!-- End of Form -->
                                        <!-- Form -->
                                        <div class="form-group mb-4">
                                            <label for="confirmPassword">Confirm Password</label>
                                            <div class="input-group">
                                                <span class="input-group-text">
                                                    <i class="bi bi-lock-fill"></i>
                                                </span>
                                                <input type="password" placeholder="Confirm Password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                                            </div>
                                        </div>
                                        <!-- End of Form -->
                                    </div>
                                    <div class="d-grid">
                                        <button type="submit" class="btn btn-primary">Reset</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="../components/successModal.jsp" />
    <jsp:include page="../components/errorModal.jsp" />
</main>

</body>
</html>
