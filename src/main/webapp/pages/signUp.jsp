<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign Up</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/main.css"%>
        <%@ include file="../css/signUp.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%--  main script  --%>
    <script>
        <%@ include file="../js/guestCookie.js"%>
<%--        <%@ include file="../js/signUp.js"%>--%>
    </script>

</head>
<body>
    <main>
        <!-- Section -->
        <section class="vh-lg-100 mt-5 mt-lg-0 bg-soft d-flex align-items-center">
            <div class="container">
                <div class="row justify-content-evenly">

                    <div class="col-lg-7 d-flex align-items-center justify-content-center">
                        <%@include file="../images/others/signUp.svg" %>
                    </div>

                    <div class="col-lg-5">
                        <p class="text-center">
                            <a href="/shopease/welcome" class="d-flex align-items-center justify-content-center">
                                <i class="bi bi-arrow-left text-primary" style="padding-right: 5px;"></i>
                                Back to homepage
                            </a>
                        </p>
                        <div class="row justify-content-center">
                            <div class="col-12 d-flex align-items-center justify-content-center main-form">
                                <div class="bg-white shadow border-0 rounded border-light p-4 p-lg-5 w-100 fmxw-500">
                                    <div class="text-center text-md-center mb-4 mt-md-0">
                                        <h3 class="mb-0 font-bold font-secondary">Create Account </h3>
                                    </div>
                                    <form action="/shopease/sign-up" class="mt-4" method="post" id="signUpForm">
                                        <input type="hidden" name="from" value="signUp">
                                        <!-- Form -->
                                        <div class="form-group mb-4">
                                            <label for="email">Your Email</label>
                                            <div class="input-group">
                                            <span class="input-group-text" id="basic-addon1">
                                                <i class="bi bi-envelope-fill"></i>
                                            </span>
                                                <input type="email" class="form-control" placeholder="example@gmail.com" id="email" name="email" autofocus required>
                                            </div>
                                        </div>
                                        <!-- End of Form -->
                                        <div class="form-group">
                                            <!-- Form -->
                                            <div class="form-group mb-4">
                                                <label for="password">Your Password</label>
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
                                                <label for="confirm_password">Confirm Password</label>
                                                <div class="input-group">
                                                <span class="input-group-text">
                                                    <i class="bi bi-lock-fill"></i>
                                                </span>
                                                    <input type="password" placeholder="Confirm Password" class="form-control" id="confirm_password" name="confirm_password" required>
                                                </div>
                                            </div>
                                            <!-- End of Form -->
                                            <div class="mb-4">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" value="c" id="account" name="account" required>
                                                    <label class="form-check-label fw-normal mb-0" for="account">
                                                        I agree to the <a href="#T&C" id="t-c" class="fw-bold" data-bs-toggle="modal" data-bs-target="#t-c-modal"> terms and conditions</a>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="d-grid">
                                            <button type="submit" class="btn btn-primary">Sign up</button>
                                        </div>
                                    </form>
                                    <div class="d-flex justify-content-center align-items-center mt-4">
                                    <span class="fw-normal">
                                        Already have an account?
                                        <a href="/shopease/customer/sign-in" class="fw-bold">Login here</a>
                                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="../components/termsConditions.jsp" />
                <jsp:include page="../components/successModal.jsp" />
                <jsp:include page="../components/errorModal.jsp" />
            </div>
        </section>
    </main>
</body>
</html>
