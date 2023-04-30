<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/add-items" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>Name</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="name">
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <label>Description</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="description">
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <label>Price</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="price">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-success">Add</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>