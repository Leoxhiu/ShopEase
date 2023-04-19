<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>

    <%--    main css file--%>
    <style>
        <%@ include file="../css/main.css"%>
        <%@ include file="../css/index.css"%>
    </style>

    <%--    vendor css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <%--  vendor script  --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>

    <!--  vendor script  -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%--  main script  --%>
    <script><%@ include file="../js/guestCookie.js"%></script>

</head>
<body>
    <%
        // Get an array of Cookies associated with this domain
        Cookie[] cookies = null;
        cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("isGuest")) {
                   if (cookie.getValue().equals("0")){
                       // New location to be redirected
                       String site = new String("landing.jsp");
                       response.setStatus(response.SC_MOVED_TEMPORARILY);
                       response.setHeader("Location", site);
                    }
                }
            }
        }
    %>

    <div class="container-sm title">
        <main style="align-items: center">
            <lottie-player src="https://assets7.lottiefiles.com/packages/lf20_jcp3ub1x.json" background="transparent"  speed="1"  style="width: 50vw; height: 60vh;" loop autoplay></lottie-player>
        </main>

        <div class="title">
            <h1>Welcome to <img class="typing" src="https://readme-typing-svg.demolab.com?font=DM+Sans&size=80&duration=2000&pause=1000&color=0D6EFD&width=360&height=150&lines=ShopEase" alt="Typing SVG" />
            </h1>
        </div>

        <div class="container text-center">
            <div class="d-grid gap-2 btn-block d-md-block">
                <button type="button" class="btn btn-secondary btn-lg mx-2" onclick="window.location.href='/shopease/customer/sign-in'">Login</button>
                <button type="button" class="btn btn-primary btn-lg mx-2" onclick="window.location.href='/shopease/customer/sign-up'">Sign up</button>
            </div>
        </div>

        <p class="guest"><a href="/shopease/welcome" class="link-secondary">Explore as Guest</a></p>
    </div>

<%--    <script>--%>

<%--        This is use for get longitude and latitude of user--%>
<%--        function getlocation() {--%>
<%--            if(navigator.geolocation){--%>
<%--                navigator.geolocation.getCurrentPosition(showPosition)--%>
<%--            }--%>
<%--            else--%>
<%--            {--%>
<%--                alert("Sorry! your browser is not supporting")--%>
<%--            } }--%>

<%--        function showPosition(position){--%>
<%--             console.log("Your current location is (" + "Latitude: " + position.coords.latitude + ", " + "Longitude: " +    position.coords.longitude + ")");--%>
<%--        }--%>
<%--    </script>--%>
</body>
</html>