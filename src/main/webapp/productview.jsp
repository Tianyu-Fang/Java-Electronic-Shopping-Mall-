<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ page import="com.Eshop.service.esm_cartDao"%> 
  <%@ page import="com.Eshop.entity.esm_user"%> 
<html>
<head>
    <meta charset="UTF-8">
    <title>Detail Page</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!------------------------------head---------------------------------->

<%@ include file="header.jsp" %>

<!-----------------------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    		<a href="indexselect">Home</a><span>/</span>
    		<a href="selectproductlist?fid=${p.PRODUCT_FID }">${parent.CATE_NAME }</a><span>/</span>
    		<a href="selectproductlist?cid=${p.PRODUCT_CID }">${child.CATE_NAME }</a><span>/</span>
    		<a href="#" class="on">${p.PRODUCT_NAME }</a>
    </div>
</div><!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
            <img class="det" src="images/product/${p.PRODUCT_FILENAME }"/>
                <div class="smallImg clearfix"><img src="images/product/${p.PRODUCT_FILENAME }"
                                                    data-src="images/product/${p.PRODUCT_FILENAME }"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4 style="line-height:1.2">【SWE306】${p.PRODUCT_NAME }</h4>
                    <p></p><p style="font-size:20px">${p.PRODUCT_DESCRIPTION }</p><p></p><span>￥${p.PRODUCT_PRICE }.00</span></div>
                <div class="proIntro"><p>Thumbnail</p>
                    <div class="smallImg clearfix categ"><p class="fl"><img alt="${p.PRODUCT_NAME}"src="images/product/${p.PRODUCT_FILENAME }"
                                                                            
                                                                            data-src="images/product/${p.PRODUCT_FILENAME }"></p>
                    </div>
                    <p>Quantity&nbsp;&nbsp;Stock&nbsp;<span>${p.PRODUCT_STOCK }</span>&nbsp;items</p>
                    <div class="num clearfix">
                    		<img class="fl sub" src="img/temp/sub.jpg">
                    		<span id="count" class="fl" contentEditable="true">1</span><img
                            class="fl add" src="img/temp/add.jpg">
                        <p class="please fl">Please select product attribute!</p></div>
                </div>
                <div class="btns clearfix">
                	<a href="javascript:shopAdd(${p.PRODUCT_ID },'z')"><p class="buy fl">Buy Now</p></a>
                	<a href="javascript:shopAdd(${p.PRODUCT_ID },'s')"><p class="cart fr"> Add to Cart</p></a></div>
            </div>
        </div>
    </div>
</div>

<script>
	function shopAdd(id, url) {
		var count = document.getElementById("count").innerHTML;
		
		location.href='cartadd?id='+id+'&count='+count+'&url='+url;
		
	}

</script>

<div class="introMsg wrapper clearfix">
    <div class="msgL fl">

        <div class="msgAll">
            <div class="msgImgs">
              <div class="msgTit clearfix"><a class="on">You may like</a></div>
        
            <div class="msgAll">
            <div class="msgImgs">
           
            <c:forEach var="cp" items="${classlist }">
        		<a href="selectproductview?id=${cp.PRODUCT_ID }">
            <dl>
                <dt><img class="bimg" src="images/product/${cp.PRODUCT_FILENAME }"></dt>
                <dd class="btitle">${cp.PRODUCT_NAME }</dd>
                <dd class="bprice">￥${cp.PRODUCT_PRICE }.00</dd>
            </dl>
        </a>
        </c:forEach>
		</div>
      	</div>  
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>
