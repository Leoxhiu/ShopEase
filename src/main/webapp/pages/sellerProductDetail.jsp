<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp"%>
    <title>ShopEase - ${productName}</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/sellerProductDetail.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%--    main script file--%>
    <script>
        <%@ include file="../js/sellerProductDetail.js"%>
    </script>
</head>
<body>
<jsp:include page="/components/sellerNavBar.jsp"/>
<main class="content">
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
                        <form action="<%= ServletPage.SELLER_PRODUCT_DETAIL.getUrl() +"?productId=" + request.getParameter("productId") %>" method="post" enctype="multipart/form-data">
                            <h2 class="h5 mb-4 font-bold font-primary">Product Information</h2>
                            <div class="text-center mb-3">
                                <label for="productImage" class="form-label">
                                    <img src="/shopease/images?productId=${productId}" class="avatar" alt="Avatar" />
                                </label>
                                <input class="form-control" id="productImage" name="productImage" type="file" accept="image/*">
                            </div>
                            <div class="mb-3">
                                <label for="productName" class="form-label">Product Name</label>
                                <input class="form-control" id="productName" name="productName" type="text" placeholder="Product Name" required value="${productName}">
                            </div>
                            <div class="mb-3">
                                <label for="productDescription" class="form-label">Product Description</label>
                                <textarea class="form-control" id="productDescription" name="productDescription" rows="3" placeholder="Product Description" required >${productDescription}</textarea>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="productPrice" class="form-label">Price</label>
                                    <div class="input-group">
                                        <span class="input-group-text">RM</span>
                                        <input class="form-control" id="productPrice" name="productPrice" type="text" placeholder="Price" required value="${productPrice}">
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="productQuantity" class="form-label">Quantity</label>
                                    <input class="form-control" id="productQuantity" name="productQuantity" type="number" placeholder="Quantity" required value="${productQuantity}">
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="productCategory" class="form-label">Category</label>
                                <select class="form-select" id="productCategory" name="productCategory" required>
                                    <option value="">Select Category</option>
                                    <option value="ETR" ${productCategory eq 'ETR' ? 'selected' : ''}>Electronics</option>
                                    <option value="CLT" ${productCategory eq 'CLT' ? 'selected' : ''}>Clothing</option>
                                    <option value="BTY" ${productCategory eq 'BTY' ? 'selected' : ''}>Beauty</option>
                                    <option value="HAK" ${productCategory eq 'HAK' ? 'selected' : ''}>Home & Kitchen</option>
                                    <option value="SAO" ${productCategory eq 'SAO' ? 'selected' : ''}>Sports & Outdoors</option>
                                    <option value="BAM" ${productCategory eq 'BAM' ? 'selected' : ''}>Books & Media</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="productDiscount" class="form-label">Discount</label>
                                <div class="input-group">
                                    <input class="form-control" id="productDiscount" name="productDiscount" type="number" placeholder="Discount" required value="${productDiscount}">
                                    <span class="input-group-text">%</span>
                                </div>
                            </div>
                            <small id="discountedPrice" class="form-text text-muted"></small>
                            <div class="text-end">
                                <a class="btn btn-danger mt-2" href="" id="delete" data-bs-toggle="modal" data-bs-target="#confirmation-modal">Delete</a>
                                <button class="btn btn-primary mt-2" type="submit">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="../components/successModal.jsp" />
<jsp:include page="../components/errorModal.jsp" />
<jsp:include page="/components/confirmationModal.jsp">
    <jsp:param name="formDirect" value="<%= ServletPage.SELLER_DELETE_PRODUCT.getUrl() +"?productId=" + request.getParameter("productId") %>"/>
</jsp:include>
</body>
</html>
