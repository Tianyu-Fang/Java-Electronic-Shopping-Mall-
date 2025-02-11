<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.Eshop.entity.esm_product"%>
<%@ page import="com.Eshop.service.esm_productDao"%>
<%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>E-shop</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>


<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><a href="selectproductlist?fid=1"><img src="img/banner11.jpg"/></a></div>
            </li>
            <li>
                <div class="slide"><a href="selectproductlist?fid=2"><img src="img/banner22.jpg"/></a></div>
            </li>
             <li>
                <div class="slide"><a href="selectproductlist?fid=3"><img src="img/server.jpg"/></a></div>
            </li>
             <li>
                <div class="slide"><a href="selectproductlist?fid=4"><img src="img/database.jpg"/></a></div>
            </li>
             <li>
                <div class="slide"><a href="selectproductlist?fid=5"><img src="img/tool.jpg"/></a></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">
    <a href="selectproductlist?fid=1"><img src="img/i1.jpg"/></a>
    <a href="selectproductlist?fid=2"><img src="img/i2.jpg"/></a>
    <a href="selectproductlist?fid=3"><img src="img/i3.jpg"/></a>
    <a href="selectproductlist?fid=4"><img src="img/i4.jpg"/></a>
    <a href="selectproductlist?fid=5"><img src="img/i5.png"/></a>
     </div>
</div><!------------------------------news------------------------------>
<%String a = (String)request.getAttribute("search");
System.out.println(a); %>
<%
ArrayList <String> img = new ArrayList<String>();
for(int i=0;i<flist.size();i++){
	img.add("img/ih"+i+".jpg");
}
%>
<c:if test="${search==null || search!='done'}">
<%
ArrayList <ArrayList<esm_product>> list = new ArrayList<ArrayList<esm_product>>();
for(int i=0;i<flist.size();i++)
{
	list.add(esm_productDao.selectAllByFid(flist.get(i).getCATE_ID()));
}
request.setAttribute("list", list);
int i=0;
%>
<c:forEach var="productlist" items="${list}">
<div class="people">
    <div class="wrapper"><h2><img src="<%=img.get(i)%>"/></h2>
    	<div>
    	<ul class="proList wrapper clearfix">
        <c:forEach var="p" items="${productlist}">
        	<li>
			<a href="selectproductview?id=${p.PRODUCT_ID }">
            <dl>
                <dt><img src="images/product/${p.PRODUCT_FILENAME }"/></dt>
                <dd>${p.PRODUCT_NAME}</dd>
                <dd><span>￥${p.PRODUCT_PRICE }.00</span></dd>
            </dl>
        	</a></li>
        </c:forEach>
        </ul>
        </div>
    </div>
    </div>
    <%i++; %>
</c:forEach>
</c:if>

<c:if test="${search=='done'}">
<ul style="margin-top:10%;" class="proList wrapper clearfix">
		<p style="text-align:center; color:#262626; font-size: 30px">There are ${number} books you might be looking for</p>
        <c:forEach var="p" items="${list}">
        	<li>
			<a href="selectproductview?id=${p.PRODUCT_ID }">
            <dl>
                <dt><img src="images/product/${p.PRODUCT_FILENAME }"/></dt>
                <dd>${p.PRODUCT_NAME}</dd>
                <dd><span>￥${p.PRODUCT_PRICE }.00</span></dd>
            </dl>
        	</a></li>
        </c:forEach>
        </ul>

</c:if>
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
    <p>400-800-8200</p></div><!-------------------login-------------------------->
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
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>