<%@ page import="utility.ServletPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/mainHeader.jsp" %>
    <title>ShopEase - Wallet</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/sellerWallet.css"%>
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
<jsp:include page="/components/sellerNavBar.jsp" />
<main>
    <div class="wallet-container">
        <h1 class="text-center">Wallet</h1>

        <div class="balance">
            <span id="balanceAmount" class="text-primary">RM ${sessionScope.sellerBalance}</span>
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
        <form class="reload-form" action="<%= ServletPage.SELLER_WALLET.getUrl() %>" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">RM</span>
                <input type="number" class="form-control" id="withDrawAmount" name="withDrawAmount" placeholder="Amount to Withdraw" required>
            </div>
            <button type="submit" class="btn btn-primary d-block mx-auto">Reload</button>
        </form>
    </div>
</main>
<jsp:include page="../components/successModal.jsp" />
<jsp:include page="../components/errorModal.jsp" />
</body>
</html>
