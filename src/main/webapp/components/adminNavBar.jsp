<%@ page import="utility.ServletPage" %>
<%@ page import="utility.JspPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    <style>
        <%@ include file="../css/adminNavBar.css"%>
    </style>


    <script><%@ include file="../js/navigationBar.js"%></script>
</head>
<body>

<div class="navigation_bar">
    <nav class="shadow-sm navbar navbar-expand-lg d-flex">
        <div class="container">
            <a class="navbar-brand font-tertiary brand-text" href="<%= JspPage.ADMIN_HOME.getUrl() %>">ShopEase</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse"  id="navbarNav">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item main-item">
                        <a class="nav-link nav-direct" aria-current="page" href="<%= JspPage.ADMIN_HOME.getUrl() %>">Home</a>
                    </li>
                    <li class="nav-item main-item">
                        <a class="nav-link nav-direct" href="<%= JspPage.ADMIN_MEMBER_PAGE.getUrl() %>">User</a>
                    </li>
                </ul>
                <ul class="navbar-nav mb-2 mb-lg-0 right-items">
                    <li class="nav-item customer-dropdown">
                        <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a id="customerName" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        ${sessionScope.memberName}
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuOffset">
                                        <li><a class="dropdown-item" href="<%= JspPage.ADMIN_PROFILE.getUrl() %>">Profile</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        <li>
                                            <form action="<%= ServletPage.SIGN_OUT.getUrl() %>" method="post" class="logout">
                                                <button class="dropdown-item" type="submit">Logout</button>
                                            </form>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

</body>
</html>
