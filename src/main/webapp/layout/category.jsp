<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-2 col-sm-6 col-12">
  <div class="row">
    <div class="col-sm-8">
      <div class="card bg-light mb-2">
        <div class="card-header bg-primary text-while text-uppercase"><i
                class="fa fa-list">CATEGORY</i></div>
        <ul class="list-group category_block">
          <c:forEach items="${categoryList}" var="category">
            <li class="list-group-item text-while ${tag == category.getId()?"active":""}"><a
                    href="/category?id=${category.getId()}">${category.getName()}</a></li>
          </c:forEach>
        </ul>
      </div>

      <div class="card bg-light mb-2">
        <div class="card-header bg-primary glyphicon-text-color text-uppercase">New Product</div>
        <div class="card-body">
          <div style="background-color: gray" ;width="100%">
            <img style="width: 100%;height: 100%" src="${productLast.getProductImage()}">
          </div>
          <div><h5 class="card-title">${productLast.getProductName()}</h5></div>
          <div><p class="card-text">${productLast.getProductDescription()}</p></div>
          <div><p class="bloc_left_price">$${productLast.getProductPrice()}</p></div>
        </div>

      </div>
    </div>
  </div>
</div>