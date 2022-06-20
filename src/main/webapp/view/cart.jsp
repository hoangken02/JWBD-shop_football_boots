<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Gio hang</title>
</head>
<body>
<h2>Thong tin gio hang:</h2>
<table border="1">
    <tr>
        <td>Id SP</td>
        <td>Ten SP</td>
        <td>Anh</td>
        <td>So luong</td>
        <td>Gia</td>
        <td>Tong tien</td>
        <td>Lua chon</td>
    </tr>
    <c:forEach items="${sessionScope.cart}" var="entry">
        <tr>
            <td>${entry.getProductName()}</td>
            <td>${entry.getProductName()}</td>
            <td><img src="${entry.getProductImage()}" width="100" /></td>
            <td>${entry.getPurchaseQuantity() }</td>
            <td>${entry.getProductPrice() }</td>
            <td>${entry.getProductPrice() * entry.getPurchaseQuantity()}</td>
            <td><a href="/delete-cart?purchaseId=${entry.getPurchaseID()}&customerID=${entry.getUserId()}">Xoa</a></td>
        </tr>
    </c:forEach>
    <a href="/add-order">Thanh toan</a>
</table>
</body>
</html>