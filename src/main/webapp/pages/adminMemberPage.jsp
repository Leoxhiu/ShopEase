<%@ page import="utility.ServletPage" %>
<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopeEase - Admin Home</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/adminMemberPage.css"%>
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

    <%--    main script file--%>
    <script> <%@ include file="../js/adminCustomerPage.js"%></script>

</head>
<body>
<jsp:include page="/components/adminNavBar.jsp"/>
<main id="content" class="content">

    <section id="control" class="control sticky-top">
        <div class="container">
            <div class="row justify-content-evenly">
                <div class="col-6">
                    <form class="navbar-search" id="search-bar" action="<%= ServletPage.ADMIN_MEMBER_PAGE.getUrl() %>"
                          method="get">
                        <input hidden name="isSearch" value="true">
                        <div class="input-group search-bar">
                            <span class="input-group-text" id="topbar-addon">
                                <i class="bi bi-search"></i>
                            </span>
                            <input type="text" class="form-control" id="searchTerm" name="searchTerm"
                                   placeholder="Search"
                                   aria-label="Search" aria-describedby="topbar-addon">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </form>
                </div>
                <div class="col-6">
                    <button class="btn btn-outline-secondary" id="filter" data-bs-toggle="modal"
                            data-bs-target="#filter-modal">
                        <i class="bi bi-filter fa-lg"></i>
                    </button>
                </div>
            </div>
        </div>
    </section>

    <section id="products" class="products mt-4">
        <div class="container">
            <div class="row">
                <c:choose>
                    <c:when test="${not empty memberList}">
                        <c:forEach items="${memberList}" var="member">
                            <c:set var="image" value="/shopease/images?memberId=${member.id}" />
                            <c:set var="name" value="${member.name}" />
                            <c:set var="email" value="${member.email}" />
                            <c:set var="userType" value="${member.userType}" />
                            <c:set var="balance" value="" />
                            <c:set var="isApproved" value="" />
                            <c:set var="checkMember" value="/shopease/admin/member?memberId=${member.id}" />

                            <c:choose>
                                <c:when test="${userType == 'c'}">
                                    <c:forEach items="${customerList}" var="customer">
                                        <c:if test="${customer.member.id eq member.id}">
                                            <c:set var="balance" value="${customer.balance}" />
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:when test="${userType == 's'}">
                                    <c:forEach items="${sellerList}" var="seller">
                                        <c:if test="${seller.member.id eq member.id}">
                                            <c:set var="balance" value="${seller.balance}" />
                                            <c:set var="isApproved" value="${seller.isApproved}" />
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                            </c:choose>

                            <jsp:include page="/components/memberCard.jsp">
                                <jsp:param name="image" value="${image}" />
                                <jsp:param name="name" value="${name}" />
                                <jsp:param name="email" value="${email}" />
                                <jsp:param name="userType" value="${userType}" />
                                <jsp:param name="balance" value="${balance}" />
                                <jsp:param name="isApproved" value="${isApproved}" />
                                <jsp:param name="checkMember" value="${checkMember}" />
                            </jsp:include>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2 class="font-tertiary">No user found.</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>
    <jsp:include page="/components/memberFilter.jsp">
        <jsp:param name="formDirect" value="<%= ServletPage.ADMIN_MEMBER_PAGE.getUrl() %>"/>
        <jsp:param name="clearDirect" value="<%= JspPage.ADMIN_MEMBER_PAGE.getUrl() %>"/>
    </jsp:include>
</main>
</body>
</html>
