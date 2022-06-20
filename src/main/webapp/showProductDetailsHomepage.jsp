<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Ken Shop</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div>
    <jsp:include page="layout/header.jsp"></jsp:include>

    <!-- NAVIGATION -->
    <jsp:include page="layout/navigation.jsp"></jsp:include>
    <!-- /NAVIGATION -->

    <!-- SECTION -->
    <%--<div class="section">--%>
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <%--        category--%>
            <jsp:include page="layout/category.jsp"></jsp:include>
            <%--        category--%>

            <!-- Products tab & slick -->
            <div class="col-md-10 col-sm-6 col-12">
                <!-- SECTION -->
                <%--<div class="section">--%>
                <!-- container -->
                <%--điền chi tiết thông tin sản phẩm vào đây???????????????????????????????????--%>


                <%--bat dau neu sp do so luong = 0--%>
                <c:if test="${product.getProductQuantity() == 0}">
                    <div class="container" style="width: 50%; height: 50%; margin-bottom: 200px">
                        <div class="card">
                            <div class="container-fliud">
                                <div class="wrapper row">
                                    <div class="preview col-md-6">

                                        <div class="preview-pic tab-content">
                                            <div class="tab-pane active"><img src="${product.getProductImage()}"
                                                                              style="height: 400px;width: 400px"/></div>
                                        </div>


                                        <h3 class="product-title">${product.getProductName()}</h3>

                                        <p class="product-description">${product.getProductDescription()}</p>
                                        <h4 class="price">price: <span>${product.getProductPrice()}</span></h4>

                                            <%--                                        <h5 class="sizes">shop name:--%>
                                            <%--                                            <span class="size" data-toggle="tooltip" title="small">${product.getShopName()}</span>--%>
                                            <%--                                        </h5>--%>
                                        <br>
                                        <h5 class="colors">
                        <span style="color: red">
                            Out of stock</span>
                                        </h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
                <%--ket thuc neu sp do so luong = 0--%>


                <%--bat dau neu sp do co so luong > 0--%>
                <c:if test="${product.getProductQuantity() > 0}">
                    <div class="container" style="width: 50%; height: 50%; margin-bottom: 200px">
                        <div class="card">
                            <div class="container-fliud">
                                <div class="wrapper row">
                                    <div class="preview col-md-6">

                                        <div class="preview-pic tab-content">
                                            <div class="tab-pane active" id="pic-1"><img
                                                    src="${product.getProductImage()}"
                                                    style="width: 400px;height: 400px"/></div>
                                        </div>
                                        <h3 class="product-title">${product.getProductName()}</h3>

                                        <p class="product-description">${product.getProductDescription()}</p>
                                        <h4 class="price">price: <span>${product.getProductPrice()}</span></h4>

                                            <%--                                        <h5 class="sizes">shop name:--%>
                                            <%--                                            <span class="size" data-toggle="tooltip" title="small">${product.getShopName()}</span>--%>
                                            <%--                                        </h5>--%>
                                        <h5 class="colors">Available Quantity:
                                            <span>
                                                    ${product.getProductQuantity()}</span>
                                        </h5>
                                        <a href="logincontroller">
                                            <div class="action">
                                                <button class="add-to-cart btn btn-default" type="submit">Buy Now
                                                </button>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
                <%--ket thuc neu sp do co so luong > 0--%>

                <%--kết thúc chi tiết thông tin sản phầm????????????????????????????????????????????--%>
                <!-- /container -->
                <%--</div>--%>
                <!-- /SECTION -->

            </div>
        </div>
    </div>

    <%--<!-- HOT DEAL SECTION -->--%>
    <%--<div id="hot-deal" class="section">--%>
    <%--    <!-- container -->--%>
    <%--    <div class="container">--%>
    <%--        <!-- row -->--%>
    <%--        <div class="row">--%>
    <%--            <div class="col-md-12">--%>
    <%--                <div class="hot-deal">--%>
    <%--                    <ul class="hot-deal-countdown">--%>
    <%--                        <li>--%>
    <%--                            <div>--%>
    <%--                                <h3>01</h3>--%>
    <%--                                <span>Days</span>--%>
    <%--                            </div>--%>
    <%--                        </li>--%>
    <%--                        <li>--%>
    <%--                            <div>--%>
    <%--                                <h3>5</h3>--%>
    <%--                                <span>Hours</span>--%>
    <%--                            </div>--%>
    <%--                        </li>--%>
    <%--                        <li>--%>
    <%--                            <div>--%>
    <%--                                <h3>32</h3>--%>
    <%--                                <span>Mins</span>--%>
    <%--                            </div>--%>
    <%--                        </li>--%>
    <%--                        <li>--%>
    <%--                            <div>--%>
    <%--                                <h3>55</h3>--%>
    <%--                                <span>Secs</span>--%>
    <%--                            </div>--%>
    <%--                        </li>--%>
    <%--                    </ul>--%>
    <%--                    <h2 class="text-uppercase">SHOP NOW SALE UPTO 69%</h2>--%>
    <%--                    <a href="logincontroller" class="primary-btn cta-btn" href="#">Shop now</a>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <!-- /row -->--%>
    <%--    </div>--%>
    <%--    <!-- /container -->--%>
    <%--</div>--%>
    <%--<!-- /HOT DEAL SECTION -->--%>

    <jsp:include page="layout/footer.jsp"></jsp:include>


    <!-- jQuery Plugins -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/nouislider.min.js"></script>
    <script src="js/jquery.zoom.min.js"></script>
    <script src="js/main.js"></script>
</div>
</body>
</html>
