<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.Eshop.entity.esm_cart"%>
<%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>order</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!----------------------------------------order------------------>
<%@ include file="header.jsp" %>

<div class="order cart mt"><!-----------------site------------------->
    <div class="site" style="margin-top:-4%;"><p class="wrapper clearfix"><span class="fl">Confirm Order</span><img class="top"
                                                                                   src="img/confirm.png"></p>
    </div><!-----------------orderCon------------------->
    <div class="orderCon wrapper clearfix">
        <div class="orderL fl"><!--------h3----------------><h3>Receive Information<a href="ToAddressAdd?id=${name.USER_ID}" class="fr">Add Address</a></h3>
            <!--------addres---------------->
            <div class="addres clearfix">
            <c:forEach var="a" items="${address }">
                <div class="addre fl">
                	<input id="address_id" type="hidden" value="${a.ADDRESS_ID }"/>
                    <div class="tit clearfix"><p class="fl">${a.NAME}</p>
                        <p class="fr"><a
                                href="AddressDel?eids=${eids}&id=${a.ADDRESS_ID}">Delete</a><span>|</span><a href="ToAddressAdd?id=${name.USER_ID}" class="edit">Edit</a></p></div>
                    <div class="addCon"><p>${a.STATE }&nbsp;${a.COUNTY}</p>
                    	<p>${a.CODE}</p>
                        <p>${a.PHONE }</p>
                        <p>${a.COMMENT}</p>
                        </div>
                </div> 
                </c:forEach>
            </div>
        </div>
        <div class="orderR fr">
            <div class="msg"><h3>Order Content<a href="showcart" class="fr">Return Shopping Cart</a></h3><!--------ul---------------->
              
              <c:forEach var="rs" items="${requestScope.shoplist }">
              
                <ul class="clearfix">
                    <li class="fl"><img width="100" height="100" src="images/product/${rs.cart_p_filename}"></li>
                    
                    <li class="fl"><p>${rs.cart_p_name }</p>
                        <p>Amount:&nbsp${rs.cart_quantity}</p></li>
                    <li class="fr">￥${rs.cart_p_price * rs.cart_quantity}.00</li>
                </ul>
                
                </c:forEach>
           
            </div><!--------tips---------------->
            <div class="tips"><p><span class="fl">Product Amount:</span><span class="fr">￥${totalprice}.00</span></p>
                <p><span class="fl">Discount:</span><span class="fr">￥0.00</span></p>
                <p><span class="fl">Freight:</span><span class="fr">Free</span></p></div><!--------tips count---------------->
            <div class="count tips"><p><span class="fl">Total:</span><span class="fr">￥${totalprice}.00</span></p></div>
            <%  
            	ArrayList<esm_cart> shoplist = (ArrayList<esm_cart>)request.getAttribute("shoplist");
            	session.setAttribute("shoplist", shoplist); 
            %>
            <form action="doorderadd" method="post">
             <input name="address_id" id="address" type="hidden" value=""/>
             <input name="user_id"  type="hidden" value="${name.USER_ID}"/>
             <input name="total_price"  type="hidden" value="${totalprice}"/>
             <input name="eids"  type="hidden" value="${eids}"/>
            <input type="submit" class="pay" value="To Pay"/></form>
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
    <p>400-800-8200</p></div>
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script>
$(function(){
$(".addre").click(function(){
	var address_id = $(".on #address_id").val();
	$("#address").val(address_id);
})
})
</script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>