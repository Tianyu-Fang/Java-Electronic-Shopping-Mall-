<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="com.Eshop.service.esm_orderDao"%>   
<%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Personal Information</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<div class="address mt" id="add">
    <div style="margin-top:-4%;" class="wrapper clearfix"><a href="indexselect" class="fl">Home</a><span>/</span><a href="mygxin.jsp" class="on">Personal Center</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${name.USER_NAME }]</span><span>[<a href="logout">Logout</a>]</span></p></h3>
            <div><h4>My Deal</h4>
                <ul>
                    <li><a href="showcart">My Cart</a></li>
                    <li><a href="doorderselect">My Order</a></li>
                </ul>
                <h4>Personal Center</h4>
                <ul>
                    <li><a href="mygxin.jsp">My Center</a></li>
                    <li><a href="ToAddressAdd?id=${name.USER_ID}">Address Management</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix"><a href="#" class="fl"><img src="img/tx.png"/></a>
                    <p class="fl"><span>${name.USER_NAME }</span></p></div>
                <div class="fr">Email: ${name.USER_EMAIL }</div>
            </div>
			   <%esm_user user = (esm_user) session.getAttribute("name"); %>
            <div class="bott">
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin1.jpg"/></a>
                    <p class="fl"><span>Order that have been received:
                    <c:if test="${name.USER_ID!=null }">
                 
                    <strong><%=esm_orderDao.countReceived(user.getUSER_ID()) %></strong>
                    </c:if>
                    </span><a href="doorderselect?status=received&cp=1">View order that have been received></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin2.jpg"/></a>
                    <p class="fl"><span>Order to be received:
                    <c:if test="${name.USER_ID!=null }">
                    <strong><%=esm_orderDao.countPayed(user.getUSER_ID()) %></strong>
                    </c:if>
                    </span><a href="doorderselect?status=payed&cp=1">View order to be received></a></p></div>
            </div>
        </div>
    </div>
</div><!--Return-to-Top-->
<c:if test="${isLogin=='1'}">
<div class="gotop"><a href="showcart">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>To<br/>Cart</dd>
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
</a><a href="mygxin.jsp" style=" font-size:10px;">
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
    <p>400-800-8200</p></div>
<!-------------footer------------->
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