<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<div id="deleteProduct" class="modal fade" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" class="delete" data-toggle="modal">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
                <a href="/shop-manager" type="button" class="btn btn-default" data-dismiss="modal">Cancel</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
