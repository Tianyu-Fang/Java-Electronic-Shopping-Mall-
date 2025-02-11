<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Eshop.service.esm_cartDao"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${title }</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>
<c:if test="${fid!=null }">
<div class="banner"><a href="#"><img src="img/category/category${fid}.jpg"/></a></div>
</c:if>
<c:if test="${cid!=null }">
<div class="banner"><a href="#"><img src="img/category/category${cid}.jpg"/></a></div>
</c:if>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    <a href="indexselect">Home</a><span>/</span>
    <c:if test="${parent!=null }">
    <a href="selectproductlist?fid=${parent.CATE_ID}">${parent.CATE_NAME}</a><span>/</span>
    </c:if>
    <a href="#" class="on">${title}</a>
    </div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">${title }</h3>
        <div class="fr choice">
            
        </div>
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">
  
  
  	<c:forEach var="p" items="${list }">
	    <li><a href="selectproductview?id=${p.PRODUCT_ID}">
	        <dl>
	            <dt><img src="images/product/${p.PRODUCT_FILENAME }"></dt>
	            <dd style="font-size:14px">${p.PRODUCT_NAME }</dd>
	            <dd></dd>
	            <dd>￥${p.PRODUCT_PRICE }.00</dd>
	        </dl>
	    </a></li>
    </c:forEach>
    
</ul>
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
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>