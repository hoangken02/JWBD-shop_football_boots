<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="view/managerBootstrap/css/style.css" type="text/css">
</head>
<body>
<!-- Edit Modal HTML -->
<div id="editProduct" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/shop-manager?action=edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Product</h4>
                </div>
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" class="form-control" required name="id" value="${product.getProductID()}">
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required name="name" value="${product.getProductName()}">
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input type="text" class="form-control" required name="img" value="${product.getProductImage()}">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input class="form-control" required name="price" value="${product.getProductPrice()}">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea type="text" class="form-control" required name="description" value="${product.getProductDescription()}"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Quantity</label>
                        <input type="text" class="form-control" required name="quantity" value="${product.getProductQuantity()}">
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.getId()}">
                                        ${category.getName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>