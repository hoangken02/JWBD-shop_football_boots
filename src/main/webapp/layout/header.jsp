<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +19008198</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> kenIT@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> xã Quỳnh Đôi, huyện Quỳnh Lưu, tỉnh Nghệ An</a>
                </li>
            </ul>
            <c:if test="${sessionScope.acc != null}">
                <ul class="header-links pull-right">
                    <li><a href="/home"><i class="fa fa-user-o"></i>${acc.getUserEmail()}</a></li>
                    <li><a href="/logout"><i class="fa fa-user-o"></i>Logout</a></li>
                </ul>
            </c:if>
            <c:if test="${sessionScope.acc == null}">
                <ul class="header-links pull-right">
                    <li><a href="/login"><i class="fa fa-user-o"></i> Login</a></li>
                    <li><a href="/show-register-form"><i class="fa fa-user-o"></i>Register</a></li>
                </ul>
            </c:if>
            <br>
            <ul class="header-links pull-right">
                <c:if test='${sessionScope["acc"].getUserRole().equals("admin")}'>
                    <li><a href="/home"><i class="fa fa-user-o"></i>Manager Account</a></li>
                </c:if>
                <c:if test='${sessionScope["acc"].getUserRole().equals("shop")}'>
                    <li><a href="/shop-manager"><i class="fa fa-user-o"></i>Manager Product</a></li>
                </c:if>
            </ul>
            <c:if test='${sessionScope["acc"].getUserRole().equals("customer")}'>
            <jsp:include page="cart.jsp"></jsp:include>
            </c:if>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-2">
                    <div class="header-logo">
                        <a href="/home" class="logo">
                            <img src="../img/amazon.jpg" alt="" width="100px">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-5">
                    <div class="header-search">
                        <form action="/search-by-name">
                            <input value="${names}" class="input" placeholder="Search by name" name="productName">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- SEARCH BAR -->
                <div class="col-md-5">
                    <div class="header-search">
                        <form action="/search-by-price">
                            <select style="width: 100px; height: 40px" name="price">
                                <option value="0,50"><$50</option>
                                <option value="50,500">$50-<$500</option>
                                <option value="500,10000">>=$500</option>
                            </select>
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->