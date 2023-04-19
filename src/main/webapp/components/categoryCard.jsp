<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<body>

    <div class="col-md-4 col-sm-6">
        <div class="card mb-30"><a class="card-img-tiles" href=${param.link} data-abc="true">
            <div class="inner">
                <div class="main-img"><img src=${param.imageUrl1} alt="Category"></div>
                <div class="thumblist"><img src=${param.imageUrl2} alt="Category"><img src=${param.imageUrl3} alt="Category"></div>
            </div></a>
            <div class="card-body text-center">
                <h4 class="card-title">${param.title}</h4>
                <p class="text-muted">${param.price}</p><a class="btn btn-outline-primary btn-sm" href=${param.link} data-abc="true">View Products</a>
            </div>
        </div>
    </div>

</body>
</html>
