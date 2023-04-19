<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--  vendor script  -->
    <script src="https://kit.fontawesome.com/aec1025d0d.js" crossorigin="anonymous"></script>
</head>
<body>

    <div class="card text-center mb-3" style="width: 15rem;">
        <div class="card-body">
            <i class="${param.icon}" style="color: #0d6efd;"></i>
            <h5 class="card-title font-bold font-secondary">${param.title}</h5>
            <p class="card-text">${param.content}</p>
        </div>
    </div>

</body>
</html>
