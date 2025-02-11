<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>ok</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!----------------------------------------order------------------>
<%@ include file="header.jsp" %>
<div class="order mt cart">
    <div style="margin-top:-4%;" class="site"><p class="wrapper clearfix"><span class="fl">Payment Done Successfully!</span><img class="top"
                                                                                   src="img/finish.png"></p>
    </div>
    <p class="ok">Payment &nbsp Finished!&nbsp&nbspRemaining&nbsp<span>&nbsp5&nbsp</span>&nbsp second(s) &nbsp for &nbsp auto &nbsp transfer<a href="doorderselect">Back to Order</a></p></div>
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
        
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
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