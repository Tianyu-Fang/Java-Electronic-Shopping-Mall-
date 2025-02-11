<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Eshop.entity.esm_product"%>
<%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Personal Information</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<div class="address mt">
    <div class="wrapper clearfix" style="margin-top:-4%;"><a href="indexselect" class="fl">Home</a><span>/</span>
    <a href="doorderselect"  class="on">My Order</a><span>/</span><ahref="#" class="on">Order Detail</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${name.USER_NAME }]</span><span>[<a href="logout">Logout</a>]</span></p></h3>
            <div><h4>My deal</h4>
                <ul>
                    <li><a href="cart.jsp">My Cart</a></li>
                    <li class="on"><a href="doorderselect">My Order</a></li>
                </ul>
                <h4>Personal Center</h4>
                <ul>
                    <li><a href="mygxin.jsp">My Center</a></li>
                    <li><a href="ToAddressAdd?id=${name.USER_ID}">Address Management</a></li>
                </ul>
                
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2>Order Details</h2>
                <h3>Order ID: <span>${order.ORDER_ID}</span></h3></div>
                <% 
                int i=0; 
                ArrayList<esm_product> products = (ArrayList<esm_product>)request.getAttribute("products");
                %>
                <div class="orderList">
                <c:forEach var="i" items="${order_items}">
                <%esm_product p = products.get(i); %>
				<div class="orderList1">
                    <div class="clearfix"><a href="#" class="fl"><img style="width:65px; height:65px;" src="images/product/<%=p.getPRODUCT_FILENAME()%>"/></a>
                        <p class="fl"><a href="#"><%=p.getPRODUCT_NAME()%></a><a href="#">¥<%=p.getPRODUCT_PRICE()%>×${i.PRODUCT_NUM}</a></p></div>
                </div>
                <%i++; %>
                </c:forEach>
                <div class="orderList1"><h3>Delivery Information</h3>
                    <p>Name:&nbsp&nbsp<span>${address.NAME }</span></p>
                    <p>Phone:&nbsp&nbsp<span>${address.PHONE}</span></p>
                    <p>Address:&nbsp&nbsp<span>${address.STATE}&nbsp&nbsp${address.COUNTY}</span></p></div>
                <div class="orderList1"><h3>Order Status</h3>
                    <p>Payment Method: <span>Online Payment</span></p>
                    <p>Delivery Status: <span>
                    <c:if test="${order.getSTATUS()=='payed'}">
                    Not Received
                    </c:if>
                    <c:if test="${order.getSTATUS()=='received'}">
                    Received
                    </c:if>
                    </span></p></div>
                <div class="orderList1 hei"><h3><strong>Total Price: </strong><span>¥${total_price }</span></h3>
                    <p><strong>Freightage: </strong><span>¥0</span></p>
                    <p><strong>Order Amount: </strong><span>¥${total_price}</span></p>
                    <p><strong>Actual Payed: </strong><span>¥${total_price }</span></p></div>
            </div>
        </div>
    </div>
</div>
<!-------------------Back-to-Top--------------------->
<c:if test="${isLogin=='1'}">
<div class="gotop"><a href="showcart">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>To<br/>Cart</dd>
        <%esm_user user = (esm_user) session.getAttribute("name"); %>
        <span><%=esm_cartDao.returnNum(user.getUSER_ID())%></span>
    </dl>
</c:if>
<c:if test="${isLogin!='1'}">
<div class="gotop"><a href="showcart" style=" font-size:10px;">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>To<br/>Cart</dd>
    </dl>
</c:if>
</a>
<a href="mygxin.jsp" style=" font-size:10px;">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>Personal<br/>Center</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none; font-size:10px;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>To<br/>Top</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">Unconditional Return within 7 Days</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">Free Exchange within 15 Days</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">Free Delivery over ￥599</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">Attentive Customer Service</span>
            </div>
        </div>
    </div>
    <p class="dibu">SWE306&copy;E-Shop<br/>
        Fang Tianyu&copy;Tang Jiacheng&copy;Huang Yuxin</p></div>
        
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>