<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Eshop.service.esm_cartDao"%>
<%@ page import="com.Eshop.entity.esm_user"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>E-shop</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>

</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix" style="margin-top:-4%;"><a href="indexselect" class="fl">Home</a><span>/</span><a
            href="mygxin.jsp">Personal Center</a><span>/</span><a href="ToAddressAdd?id=${name.USER_ID}" class="on">Address Management</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
     
                <p class="clearfix"><span class="fl">${name.USER_NAME}</span><span class="fr">[<a href="logout">Logout</a>]</span></p></h3>
            <div><h4>My Deal</h4>
                <ul>
                    <li><a href="showcart">My Cart</a></li>
                    <li><a href="doorderselect">My Order</a></li>
                </ul>
                <h4>Personal Center</h4>
                <ul>
                    <li><a href="mygxin.jsp">My Center</a></li>
                    <li class="on"><a href="ToAddressAdd?id=${name.USER_ID }" >Address Management</a></li>
                </ul>

            </div>
        </div>
        
        
        
        
        
        
        <div class="you fl"><h2>Delivery Address</h2>
            <div class="add">
                <div><a href="#2" id="addxad"><img src="img/jia.png"/></a><span>Add New</span></div>
      
                   
            	         
                <c:forEach var="ad" items="${addresslist }">
                <div id="dizhi">
                
               		<p>${ad.NAME}</p>
                    <p>${ad.PHONE}</p>
                    <p>${ad.STATE}</p>
                    <p>${ad.COUNTY}</p>
                    <p>${ad.CODE}</p>
                    <p>${ad.COMMENT}</p>
                	<p class="addp">
                     <a href="ToAddressUpdate?ADDRESS_ID=${ad.ADDRESS_ID}"  id="readd">Edit</a>
                     <a href="AddressDel?id=${ad.ADDRESS_ID }&USER_ID=${ad.USER_ID}" >Delete</a></p>
                    </div>    
					</c:forEach>
       		
 
         </div>
         
   
   </div> 
    
</div><!----><!--MASK-->
<div class="mask"></div>
<div class="adddz">
    <form action="AddressAdd" method="post">
    
	<input type="hidden" name="USER_ID" value="${name.USER_ID}"></input>
		
    	<input type="text" name="NAME" value="" placeholder="Name" class="on"/>
   		<input type="text" name="PHONE" value="" placeholder="Phone No."/>
        <div class="city">
        	<select name="STATE" value="State">
           	 <option  value="WP Kuala Lumpur">WP Kuala Lumpur</option>
           	 <option  value="Johor">Johor</option>
           	 <option  value="Kedah">Kedah</option>
           	 <option  value="Kelaka">Kelaka</option>
           	 <option  value="Pehang">Pehang</option>
           	 <option  value="Penang">Penang</option>
           	 <option  value="Sabah">Sabah</option>
           	 <option  value="Selangor">Selangor</option>
           	 <option  value="Putrajaya">Putrajaya</option>
        	</select>
        	
        	<select name="COUNTY" value="County">
            <option  value="Kuala Lumpur">Kuala Lumpur</option>
            <option  value="Bandar Penawar">Bandar Penawar</option>
            <option  value="Karangan">Karangan</option>
            <option  value="Kuala Selangor">Kuala Selangor</option>
            <option  value="Petaling Jaya">Petaling Jaya</option>
            <option  value="Pulau Indah">Pulau Indah</option>
            <option  value="Sabak Bernam">Sabak Bernam</option>
            <option  value="Sepang">Sepang</option>
            <option  value="Subang Jaya">Subang Jaya</option>
        	</select>
        	<select name="CODE">
            <option  value="50000">50000</option>
            <option  value="50050">50050</option>
            <option  value="50088">50088</option>
            <option  value="50100">50100</option>
            <option  value="50150">50150</option>
            <option  value="50200">50200</option>
            </select>
        </div>
        <textarea name="COMMENT" rows="" cols="" placeholder="Remark"></textarea>

        <div class="bc">
        	<input type="submit" value="Save"/>
        	
        	<input type="button" value="Cancle"/> 
        </div>

    </form>
</div>





<c:if test="${updateStatus=='true'}">
<div class="readd">
    <form action="AddressUpdate" method="post">
    <input type="hidden" name="ADDRESS_ID" value="${a.ADDRESS_ID }"></input>
	<input type="hidden" name="USER_ID" value="${a.USER_ID}"></input>
		
    	<input type="text" name="NAME" value="${a.NAME }" placeholder="Name" class="on"/>
   		<input type="text" name="PHONE" value="${a.PHONE }" placeholder="Phone No."/>
        <div class="city">
        	<select name="STATE" value="${a.STATE }">
           	 <option  value="WP Kuala Lumpur" ${a.STATE=="WP Kuala Lumpur"?"selected":"" }>WP Kuala Lumpur</option>
           	 <option  value="Johor" ${a.STATE=="Johor"?"selected":"" }>Johor</option>
           	 <option  value="Kedah" ${a.STATE=="Kedah"?"selected":"" }>Kedah</option>
           	 <option  value="Kelaka" ${a.STATE=="Kelaka"?"selected":"" }>Kelaka</option>
           	 <option  value="Pehang" ${a.STATE=="Pehang"?"selected":"" }>Pehang</option>
           	 <option  value="Penang" ${a.STATE=="Penang"?"selected":"" }>Penang</option>
           	 <option  value="Sabah" ${a.STATE=="Sabah"?"selected":"" }>Sabah</option>
           	 <option  value="Selangor" ${a.STATE=="Selangor"?"selected":"" }>Selangor</option>
           	 <option  value="Putrajaya" ${a.STATE=="Putrajaya"?"selected":"" }>Putrajaya</option>
        	</select>
        	
        	<select name="COUNTY" value="${a.COUNTY }">
            <option  value="Kuala Lumpur" ${a.COUNTY=="Kuala Lumpur"?"selected":"" }>Kuala Lumpur</option>
            <option  value="Bandar Penawar" ${a.COUNTY=="Bandar Penawar"?"selected":"" }>Bandar Penawar</option>
            <option  value="Karangan" ${a.COUNTY=="Karangan"?"selected":"" }>Karangan</option>
            <option  value="Kuala Selangor" ${a.COUNTY=="Kuala Selangor"?"selected":"" }>Kuala Selangor</option>
            <option  value="Petaling Jaya" ${a.COUNTY=="Petaling Jaya"?"selected":"" }>Petaling Jaya</option>
            <option  value="Pulau Indah" ${a.COUNTY=="Pulau Indah"?"selected":"" }>Pulau Indah</option>
            <option  value="Sabak Bernam" ${a.COUNTY=="Sabak Bernam"?"selected":"" }>Sabak Bernam</option>
            <option  value="Sepang" ${a.COUNTY=="Sepang"?"selected":"" }>Sepang</option>
            <option  value="Subang Jaya" ${a.COUNTY=="Subang Jaya"?"selected":"" }>Subang Jaya</option>
        	</select>
        	<select name="CODE" value="${a.CODE }">
            <option  value="50000">50000</option>
            <option  value="50050">50050</option>
            <option  value="50088">50088</option>
            <option  value="50100">50100</option>
            <option  value="50150">50150</option>
            <option  value="50200">50200</option>
            </select>
        </div>
        <textarea name="COMMENT" rows="" cols="" placeholder="Remark">${a.COMMENT}</textarea>

        <div class="bc">
        	<input type="submit" value="Update"/>
        	<input onClick="history.go(-1)" type="button" value="Cancle"/>
        </div>

    </form>
</div>
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
<script>
function show(){
	$(".readd").show();
}

</script>
</body>
</html>


