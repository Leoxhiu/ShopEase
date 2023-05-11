<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ include file="../components/mainHeader.jsp"%>
  <title>ShopEase - Customer Profile</title>

  <%--    main css file--%>
  <style>
    <%@ include file="../css/customerProfile.css"%>
  </style>

  <%--    vendor css--%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

  <%--  vendor script  --%>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/components/adminNavBar.jsp" />
<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card border-0 shadow mb-4">
                    <div class="card-body">
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
                        <form action="<%= ServletPage.ADMIN_PROFILE.getUrl() %>" method="post" enctype="multipart/form-data">
                            <div class="text-center mb-4">
                                <div class="avatar-upload">
                                    <label for="memberProfile">
                                        <img src="/shopease/images?memberId=${sessionScope.memberId}" class="avatar rounded-circle" alt="Avatar" />
                                    </label>
                                    <input class="form-control mt-3" type="file" id="memberProfile" name="memberProfile" accept="image/*">
                                </div>
                            </div>
                            <h2 class="h5 mb-4 font-bold font-primary">Account information</h2>
                            <div class="row mb-3">
                                <div class="">
                                    <div class="form-group">
                                        <label for="memberEmail">Email</label>
                                        <input class="form-control" id="memberEmail" name="memberEmail" type="email" placeholder="example@gmail.com" readonly required value="${memberEmail}">
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="">
                                    <div class="form-group">
                                        <label for="memberPassword">Password</label>
                                        <input class="form-control" id="memberPassword" name="memberPassword" type="password" placeholder="Password" required value="${memberPassword}">
                                    </div>
                                </div>
                            </div>
                            <h2 class="h5 mb-4 font-bold font-primary">Personal information</h2>
                            <div class="row mb-3">
                                <div class="">
                                    <div class="form-group">
                                        <label for="memberName">Name</label>
                                        <input class="form-control" id="memberName" name="memberName" type="text" placeholder="Name" required value="${memberName}">
                                    </div>
                                </div>
                            </div>
                            <div class="text-end">
                                <button class="btn btn-primary mt-2 animate-up-2" type="submit">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../components/successModal.jsp" />
        <jsp:include page="../components/errorModal.jsp" />
    </div>
</main>
</body>
</html>
