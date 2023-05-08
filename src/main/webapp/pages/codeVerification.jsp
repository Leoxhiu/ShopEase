<%@ page import="utility.JspPage" %>
<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../components/mainHeader.jsp"%>
    <title>ShopEase - Code Verification</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/codeVerification.css"%>
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
        String actualCode = (String) session.getAttribute("actualCode");
        if(actualCode == null){
            response.sendRedirect(JspPage.LANDING.getUrl());
        }
    %>
    <main>
        <!-- Section -->
        <section class="vh-lg-100 mt-5 mt-lg-0 bg-soft d-flex justify-content-center align-items-center">
            <div class="container">

                <div class="row justify-content-evenly">
                    <div class="col-lg-7 d-flex align-items-center justify-content-center">
                        <%@include file="../images/others/email.svg"%>
                    </div>
                    <div class="col-lg-5">

                        <div class="row justify-content-center">
                            <p class="text-center"><a href="<%= JspPage.SIGN_IN.getUrl() %>" class="d-flex align-items-center justify-content-center">
                                <i class="bi bi-arrow-left text-primary" style="padding-right: 5px;"></i>
                                Back to log in
                            </a>
                            </p>
                            <div class="col-12 d-flex align-items-center justify-content-center">
                                <div class="signin-inner my-3 my-lg-0 bg-white shadow border-0 rounded p-4 p-lg-5 w-100 fmxw-500">
                                    <h3 class="font-secondary font-bold">Code Verification</h3>
                                    <p class="mb-4">Insert the code that is sent into your email.</p>
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
                                    <form action="<%= ServletPage.CODE_VERIFICATION.getUrl() %>" method="post">
                                        <!-- Form -->
                                        <div class="mb-4">
                                            <label for="code">Code</label>
                                            <div class="input-group">
                                                <input type="text" class="form-control" id="code" name="code" placeholder="######" required autofocus>
                                            </div>
                                        </div>
                                        <!-- End of Form -->
                                        <div class="d-grid">
                                            <button type="submit" class="btn btn-primary">Verify code</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <jsp:include page="../components/successModal.jsp" />
                <jsp:include page="../components/errorModal.jsp" />
            </div>
        </section>
    </main>
</body>
</html>
