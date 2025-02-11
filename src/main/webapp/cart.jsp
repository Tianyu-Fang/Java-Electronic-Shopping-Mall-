<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="com.Eshop.service.esm_categoryDao"%>
    <%@ page import="com.Eshop.service.esm_productDao"%>
       <%@ page import="com.Eshop.entity.esm_category"%>
    <%@ page import="com.Eshop.entity.esm_product"%>     
     <%@ page import="com.Eshop.entity.esm_cart"%>
     <%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html style="height:100%;">
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body style="height:100%;"><!--------------------------------------cart--------------------->
<%@ include file="header.jsp" %>
<div class="cart mt"><!-----------------logo------------------->
    <div class="site" style="margin-top:-4%;"><p class=" wrapper clearfix"><span class="fl">Shopping Cart</span><img class="top"
                                                                                   src="img/cart.png"><a
            href="indexselect" class="fr">Continue Shopping&gt;</a></p></div><!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>Product</div>
            <div>Unit Price</div>
            <div>Quantity</div>
            <div>Total</div>
            <div>Operation</div>
        </div>
       <% int i=0; %>
       <c:forEach var="rs" items="${requestScope.shoplist }">
       <% 
       ArrayList<esm_cart> cart = new ArrayList<esm_cart>();
       cart = (ArrayList<esm_cart>) request.getAttribute("shoplist");
       esm_cart c = cart.get(i);
       int pid = c.CART_P_ID;
       esm_product product= esm_productDao.selectById(pid);
       esm_category category = esm_categoryDao.selectById(product.getPRODUCT_CID());
       String category_name = category.getCATE_NAME();
       request.setAttribute("name", category_name);
       %>
        <div class="th">
            <div class="pro clearfix"><label class="fl">
            	<input name="ck" type="checkbox" value="${rs.cart_id }"/>
            	
            	<span></span></label>
            	<a class="fl" href="selectproductview?id=${rs.cart_p_id }">
                <dl class="clearfix">
                    <dt class="fl"><img width="90" height="90" src="images/product/${rs.cart_p_filename }"></dt>
                    <dd class="fl"><p>${rs.cart_p_name }</p>
                        <p>Category</p>
                        <p>${name}</p></dd>
                </dl>
            </a></div>
            <div class="price" style="text-align:center;">￥${rs.cart_p_price }.00</div>
            <div class="number" style="text-align:center;">
            	<p class="num clearfix">
            	<img class="fl sub" src="img/temp/sub.jpg">
            	<span datasrc="${rs.cart_id }" class="fl">${rs.cart_quantity }</span>
            	<img class="fl add" src="img/temp/add.jpg"></p>
           </div>
            <div class="price sAll" style="text-align:center;">￥${rs.cart_p_price * rs.cart_quantity }.00</div>
            <div class="price" style="text-align:center;"><a class="del" datasrc="${rs.cart_id }" href="#2">Delete</a></div>
        </div>
       <%i++; %>
       </c:forEach>
       
        
        <div class="goOn">Nothing~<a href="indexselect">Go Shopping</a></div>
        <div class="tr clearfix"><label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl"><a href="#">All select</a></p>
            <p class="fr"><span>Total&nbsp<small id="sl">0</small>&nbspProduct</span><span>Total:&nbsp;<small id="all">￥0.00</small></span><a
                    href="javascript:toorder()" class="count">Check Out</a></p></div>
    </div>
</div>

<script>
	function toorder() {
			var str = "";
			
			$("input[name='ck']:checked").each(function(index, item){
				if($("input[name='ck']:checked").length-1 == index){
					str+= $(this).val();
				}else{
					str+= $(this).val()+",";
				}
				
			});
			
			location.href="orderselect?eids="+str;
		
	}
</script>
<div class="mask"></div>
<div class="tipDel"><p>Are you sure to delete?</p>
    <p class="clearfix"><a class="fl cer" href="#">Sure</a><a class="fr cancel" href="#">Cancel</a></p></div>
    <!--Return Top-->
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

<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>