<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="com.Eshop.entity.esm_product"%>
<%@ page import="com.Eshop.entity.esm_order"%>
<%@ page import="com.Eshop.service.esm_orderDao"%>
<%@ page import="com.Eshop.service.esm_productDao"%>
<%@ page import="com.Eshop.entity.esm_orderitem"%>
<%@ page import="com.Eshop.service.esm_orderitemDao"%>
<%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Eshop</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body onload="setColor()"><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<div class="address mt">
    <div class="wrapper clearfix" style="margin-top:-4%;"><a href="indexselect" class="fl">Home</a><span>/</span><a
            href="mygxin.jsp">Personal Center</a><span>/</span><a href="" class="on">My Order</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${name.USER_NAME }]</span><span>[<a href="logout">Logout</a>]</span></p></h3>
            <div><h4>My deal</h4>
                <ul>
                    <li><a href="showcart">My Cart</a></li>
                    <li class="on"><a href="doorderselect">My Order</a></li>
                </ul>
                <h4>Personal Center</h4>
                <ul>
                    <li><a href="mygxin.jsp">My Center</a></li>
                    <li><a href="ToAddressAdd?id=${name.USER_ID }">Address Management</a></li>
                </ul>
                
            </div>
        </div>
       
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">My Order</h2></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li id="all_li" class="on"><a href="doorderselect?status=all&cp=1">All Orders</a></li>
                    <li id="received_li"><a href="doorderselect?status=received&cp=1">Received</a></li>
                    <li id="payed_li"><a href="doorderselect?status=payed&cp=1">Paid</a></li>
                </ul>
                <form action="doorderselect?status=all" method="post" class="fr clearfix"><input type="text" name="keywords" value="${param.keywords}" id="" 
                placeholder="Enter the Order ID"/>
                <input type="submit" name="" id="" value=""/>
                </form>
            </div>
            
             <%
             	int i=0; //same role as var="o"
             	ArrayList<esm_order> orderlist = (ArrayList<esm_order>) request.getAttribute("orderlist");
             %>
    		<c:forEach var="o" items="${orderlist}">
    			<% esm_order o = orderlist.get(i);
    			%>
    			<c:if test="${o.getSTATUS()=='received'}">
    			 <div class="dkuang" id="${o.getSTATUS()}"><p class="one">Received</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>${o.getORDER_TIME()}</li>
                        <li>${o.getUSER_ID()}</li>
                        <li>Order ID:${o.getORDER_ID()}</li>
                    </ul>
                    <p class="fr">Total Price:<span>${o.getTOTAL_PRICE()}</span></p></div>      
                    <%
                    ArrayList<esm_orderitem> items = esm_orderitemDao.selectByOrder(o.getORDER_ID()); 
                    request.setAttribute("items", items);
                    int j = 0;//same role as var="i"
                    %>
                    
                    <c:forEach var="i" items="${items}">
                    <%
                    esm_product p = esm_productDao.selectById(items.get(j).getPRODUCT_ID());
                    request.setAttribute("product", p);
                    request.setAttribute("j", j);
                    %>
                    <div class="shohou clearfix">
                     <a href="#" class="fl"><img src="images/product/${product.getPRODUCT_FILENAME()}"/></a>
                    <p class="fl"><a href="#">${product.getPRODUCT_NAME()}</a><a href="#">¥${product.getPRODUCT_PRICE()}×${i.getPRODUCT_NUM()}</a></p>
                    <c:if test="${j==0 }">
                     <p class="fr"><a href="orderdetail?order_id=${o.getORDER_ID()}">Order Details</a></p>
                     </c:if>
                     </div>
                    <%j++; %>
                    </c:forEach>
                   
            	</div>
    			</c:if>
    			
    			<c:if test="${o.getSTATUS()=='payed'}">
    			 <div class="dkuang clearfix deng" id="${o.getSTATUS()}"><p class="one fl" id="status">Paid</p>
                <div class="clearfix">
                </div>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>${o.getORDER_TIME()}</li>
                        <li>${o.getUSER_ID()}</li>
                        <li>Order ID:${o.getORDER_ID()}</li>
                    </ul>
                     <p class="fr">Total Price:<span>${o.getTOTAL_PRICE()}</span></p></div>
                 	<%
                    ArrayList<esm_orderitem> items = esm_orderitemDao.selectByOrder(o.getORDER_ID()); 
                    request.setAttribute("items", items);
                    int j = 0;//same role as var="i" 
                    %>  
                    <c:forEach var="i" items="${items}">
                    <%
                    esm_product p = esm_productDao.selectById(items.get(j).getPRODUCT_ID());
                    request.setAttribute("product", p);
                    request.setAttribute("j", j);
                    %>
                    <div class="shohou clearfix">
                     <a href="#" class="fl"><img src="images/product/${product.getPRODUCT_FILENAME()}"/></a>
                    <p class="fl"><a href="#">${product.getPRODUCT_NAME()}</a><a href="#">¥${product.getPRODUCT_PRICE()}×${i.getPRODUCT_NUM()}</a></p>
                    <c:if test="${j==0 }">
                     <p class="fr"><a id="confirm" href="doorderupdate?id=${o.getORDER_ID()}&cpage=${cpage}">Confirm Delivery</a><a href="orderdetail?order_id=${o.getORDER_ID()}">Order Detail</a></p>
                     </c:if>
                    </div>
                    <%j++;%>
                    </c:forEach>
                    
            	</div>
    			</c:if>
    			<%i++; %>
    		</c:forEach>
         
              <div class="list-page"> 
					       
                    	<a href="doorderselect?cp=1${searchParams}&status=${status}">First Page</a>
                    	<a href="doorderselect?cp=${cpage-1<1?1:cpage-1}${searchParams}&status=${status}">Previous</a>
                    						${cpage}/${tpage}
                    	<a href="doorderselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}&status=${status}">Next</a>
                    	<a href="doorderselect?cp=${tpage}${searchParams}&status=${status}">Final Page</a>

			</div>
        </div>
    </div>
</div>
<!--------------------------Back-to-Top------------------>

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
    <!--footer-->
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
        
<script>
function setColor(){
	var status = "${status}";
	console.log("${status}");
	if("${status}" =="received")
	{
		$("#received_li").addClass("on").siblings().removeClass("on");
		
	}
	else if("${status}"=="payed")
	{
		$("#payed_li").addClass("on").siblings().removeClass("on");

	}
	else
	{
		$("#all_li").addClass("on").siblings().removeClass("on");

	}
}
</script>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>