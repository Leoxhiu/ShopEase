<%@ page import="utility.ServletPage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp"%>
    <title>ShopEase - ${productName}</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/customerProductDetail.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/components/customerNavBar.jsp"/>
<main class="content">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card border-0 shadow mb-4">
                    <div class="card-body">
                        <h2 class="h5 mb-4 font-bold font-primary">Product Information</h2>
                        <div class="text-center mb-3">
                            <img src="/shopease/images?productId=${productId}" class="avatar" alt="Avatar" />
                        </div>
                        <div class="mb-3">
                            <label for="productName" class="form-label">Product Name</label>
                            <p id="productName" class="form-text">${productName}</p>
                        </div>
                        <div class="mb-3">
                            <label for="productDescription" class="form-label">Product Description</label>
                            <p id="productDescription" class="form-text">${productDescription}</p>
                        </div>
                        <div class="mb-3">
                            <label for="productCategory" class="form-label">Category</label>
                            <p id="productCategory" class="form-text">${productCategory}</p>
                        </div>
                        <div class="mb-3">
                            <label for="productDiscount" class="form-label">Price</label>
                            <c:choose>
                                <c:when test="${productDiscount > 0}">
                                    <p class="form-text"><span class="text-muted text-decoration-line-through">RM ${productPrice}</span>
                                        RM ${productDiscountedPrice}</p>
                                </c:when>
                                <c:otherwise>
                                    <p id="productDiscount" class="form-text">RM ${productPrice}</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="mb-3">
                            <label for="productRating" class="form-label">Rating</label>
                            <div id="productRating" class="rating">
                                <c:choose>
                                    <c:when test="${productRating == 0}">
                                        <span class="text-muted">No Rating</span>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach begin="1" end="${productRating}">
                                            <i class="bi-star-fill text-warning mr-1 star-icon"></i>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="totalQuantity" class="form-label">Total Quantity</label>
                            <p id="totalQuantity" class="form-text">${productQuantity}</p>
                        </div>
                        <div class="text-end">
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
                            <form action="<%= ServletPage.CUSTOMER_PRODUCT_DETAIL.getUrl() +"?productId=" + request.getParameter("productId") %>" method="post">
                                <div class="input-group mb-3">
                                    <input class="form-control" id="quantity" name="quantity" type="number" placeholder="Desired quantity" required>
                                    <button class="btn btn-primary" type="submit">Add to Cart</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="../components/successModal.jsp" />
<jsp:include page="../components/errorModal.jsp" />
</body>
</html>
