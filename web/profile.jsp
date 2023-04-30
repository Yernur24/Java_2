<%@ page import="kzz.db.Users" %>
<head>
    <title>BITLAB SHOP</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-3">
    <div class="row">
        <div class="col-12 mx-auto">
            <h1>Hello <%=currentUser.getFullName()%></h1>
          <h1>Almaty, Qazaqstan</h1>

        </div>
    </div>
</div>

</body>
</html>
