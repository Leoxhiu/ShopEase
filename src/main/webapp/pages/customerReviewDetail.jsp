<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Review</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/customerReviewDetail.css"%>
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

    <script>
        <%@ include file="../js/customerReviewDetail.js"%>
    </script>

</head>
<body>
<jsp:include page="/components/customerNavBar.jsp" />
<main>
    <section>
        <div class="container">
            <h1 class="font-secondary">Review Detail</h1>
            <jsp:include page="/components/cartDisplayCard.jsp">
                <jsp:param name="image" value="/shopease/images?productId=${cart.product.id}"/>
                <jsp:param name="name" value="${cart.product.name}"/>
                <jsp:param name="price" value="${cart.price}"/>
                <jsp:param name="quantity" value="${cart.quantity}"/>
                <jsp:param name="reviewDirect" value="/shopease/customer/review/detail?cartId=${cart.id}"/>
            </jsp:include>
        </div>
    </section>

    <section class="mt-5">
        <div class="container">
            <div class="row">
                <div class="">
                    <h2 class="font-secondary">Rating & Feedback</h2>
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
                    <form action="<%= ServletPage.CUSTOMER_REVIEW_DETAIL.getUrl() +"?reviewId=" + request.getAttribute("reviewId") + "&postFeedback=true" %>" method="post">
                        <div class="mb-3">
                            <div class="star-rating">
                                <div class="star-rating">
                                    <c:choose>
                                        <c:when test="${review.rating == '5'}">
                                            <input id="star-5" type="radio" name="rating" value="5" checked />
                                        </c:when>
                                        <c:otherwise>
                                            <input id="star-5" type="radio" name="rating" value="5" />
                                        </c:otherwise>
                                    </c:choose>
                                    <label for="star-5" title="5" class="stars">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </label>

                                    <c:choose>
                                        <c:when test="${review.rating == '4'}">
                                            <input id="star-4" type="radio" name="rating" value="4" checked />
                                        </c:when>
                                        <c:otherwise>
                                            <input id="star-4" type="radio" name="rating" value="4" />
                                        </c:otherwise>
                                    </c:choose>
                                    <label for="star-4" title="4" class="stars">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </label>

                                    <c:choose>
                                        <c:when test="${review.rating == '3'}">
                                            <input id="star-3" type="radio" name="rating" value="3" checked />
                                        </c:when>
                                        <c:otherwise>
                                            <input id="star-3" type="radio" name="rating" value="3" />
                                        </c:otherwise>
                                    </c:choose>
                                    <label for="star-3" title="3" class="stars">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </label>

                                    <c:choose>
                                        <c:when test="${review.rating == '2'}">
                                            <input id="star-2" type="radio" name="rating" value="2" checked />
                                        </c:when>
                                        <c:otherwise>
                                            <input id="star-2" type="radio" name="rating" value="2" />
                                        </c:otherwise>
                                    </c:choose>
                                    <label for="star-2" title="2" class="stars">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </label>

                                    <c:choose>
                                        <c:when test="${review.rating == '1'}">
                                            <input id="star-1" type="radio" name="rating" value="1" checked />
                                        </c:when>
                                        <c:otherwise>
                                            <input id="star-1" type="radio" name="rating" value="1" />
                                        </c:otherwise>
                                    </c:choose>
                                    <label for="star-1" title="1" class="stars">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="feedback" class="form-label">Leave your feedback:</label>
                            <textarea class="form-control" id="feedback" name="feedback" rows="5" placeholder="Enter your feedback here">${review.feedback}</textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section id="comment-section" class="mt-5">
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
        <form action="<%= ServletPage.CUSTOMER_REVIEW_DETAIL.getUrl() +"?reviewId=" + request.getAttribute("reviewId") + "&postComment=true" %>" method="post">
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
