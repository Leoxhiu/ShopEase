<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign In</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/index.css"%>
        <%@ include file="../css/forgotPassword.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%--  main script  --%>
<%--    <script><%@ include file="../js/guestCookie.js"%></script>--%>

</head>
<body>
<main>
  <!-- Section -->
  <section class="vh-lg-100 mt-5 mt-lg-0 bg-soft d-flex justify-content-center align-items-center">
    <div class="container">

      <div class="row justify-content-evenly">
        <div class="col-lg-7 d-flex align-items-center justify-content-center">
          <%@include file="../images/others/forgot_password.svg" %>
        </div>
        <div class="col-lg-5">

          <div class="row justify-content-center">
            <p class="text-center"><a href="/shopease/sign-in" class="d-flex align-items-center justify-content-center">
              <i class="bi bi-arrow-left text-primary" style="padding-right: 5px;"></i>
              Back to log in
            </a>
            </p>
            <div class="col-12 d-flex align-items-center justify-content-center">
              <div class="signin-inner my-3 my-lg-0 bg-white shadow border-0 rounded p-4 p-lg-5 w-100 fmxw-500">
                <h3 class="font-secondary font-bold">Forgot your password?</h3>
                <p class="mb-4">Don't fret! Just type in your email and we will send you a code to reset your password!</p>
                <form action="#">
                  <!-- Form -->
                  <div class="mb-4">
                    <label for="email">Your Email</label>
                    <div class="input-group">
                      <input type="email" class="form-control" id="email" placeholder="example@gmail.com" required autofocus>
                    </div>
                  </div>
                  <!-- End of Form -->
                  <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Recover password</button>
                  </div>
                </form>
              </div>
            </div>
          </div>

        </div>
      </div>

    </div>
  </section>
</main>

</body>
</html>
