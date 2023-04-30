<%@ page import="java.util.ArrayList" %>
<%@ page import="kzz.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bitlab</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="d-flex justify-content-center mt-4">Welcome to BITLAB SHOP</h1>
            <p class="d-flex justify-content-center mt-2"> Electronic devices with high quality and service</p>
        </div>
    </div>
</div>
<div class="container" >
    <div class="row" style="height: 250px">
        <%
            ArrayList<Items> item = (ArrayList<Items>) request.getAttribute("items");
            if (item != null) {
                for (Items items : item) {
        %>
        <div class="col-4">
            <div class="card text-dark bg light mb-3" >
                <div class="card-header text-center">
                    <p class="font-size:29px;"><%=items.getName()%>
                    </p>
                </div>
                <div class="card-body">
                    <h3 class="card-title text-center text-success">$<%=items.getPrice()%>
                    </h3>
                    <p class="card-text text-center" mb-0><%=items.getDescription()%>
                    </p>
                </div>
                <a href="/details?item_id=<%=items.getId()%>" type="submit" class="btn btn-success d-flex justify-content-center w-100">BUY NOW</a>

            </div>
        </div>
        <%
                }
            }
        %>

    </div>
</div>
</body>
</html>
