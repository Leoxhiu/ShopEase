<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Sales Review</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/sellerSalesReview.css"%>
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
    <script src="https://kit.fontawesome.com/aec1025d0d.js" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="/components/sellerNavBar.jsp" />
<main>
    <section>
        <div class="container">
            <h1 class="font-secondary">Sales Review</h1>
            <jsp:include page="/components/cartDisplayCard.jsp">
                <jsp:param name="image" value="/shopease/images?productId=${cart.product.id}"/>
                <jsp:param name="name" value="${cart.product.name}"/>
                <jsp:param name="price" value="${cart.price}"/>
                <jsp:param name="quantity" value="${cart.quantity}"/>
                <jsp:param name="reviewDirect" value="/shopease/seller/sales/review?cartId=${cart.id}"/>
            </jsp:include>
        </div>
    </section>

        <section class="mt-5">
            <div class="container">
                <div class="row">
                    <div class="">
                        <h2 class="font-secondary">Customer Rating & Feedback</h2>
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
                        <div class="mb-3">
                            <div class="star-rating">
                                <c:choose>
                                    <c:when test="${review.rating == '0'}">
                                        <span class="text-muted">No Rating</span>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach begin="1" end="${review.rating}">
                                            <i class="bi-star-fill text-warning mr-1 star-icon" style="font-size: 2rem;"></i>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="feedback" class="form-label">Feedback</label>
                            <c:choose>
                                <c:when test="${review.feedback == ''}">
                                    <p class="text-muted">No Feedback</p>
                                </c:when>
                                <c:otherwise>
                                    <textarea readonly class="form-control" id="feedback" name="feedback" rows="5" placeholder="Enter your feedback here">${review.feedback}</textarea>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="comment-section" class="mt-4">
            <div class="container">
                <h2 class="font-secondary">Comments</h2>
                <c:choose>
                    <c:when test="${not empty reviewReplyList}">
                        <c:forEach var="reviewReply" items="${reviewReplyList}">
                            <jsp:include page="/components/commentCard.jsp">
                                <jsp:param name="image" value="/shopease/images?memberId=${reviewReply.member.id}"/>
                                <jsp:param name="name" value="${reviewReply.member.name}"/>
                                <jsp:param name="comment" value="${reviewReply.reply}"/>
                            </jsp:include>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h4 class="font-tertiary">No comment found.</h4>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>


        <section id="comment-input-section">
            <form action="<%= ServletPage.SELLER_SALES_REVIEW.getUrl() +"?reviewId=" + request.getAttribute("reviewId")%>" method="post">
                <div class="input-group">
                    <input type="text" name="comment" class="form-control" placeholder="Enter your comment" aria-label="Comment input" aria-describedby="comment-button">
                    <button class="btn btn-primary" type="submit" id="comment-button">Send</button>
                </div>
            </form>
        </section>

</main>
<jsp:include page="../components/successModal.jsp" />
<jsp:include page="../components/errorModal.jsp" />

</body>
</html>
