<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Reset Password</title>
    <link rel="stylesheet" type="text/css" href="css/forget.css"/>
	<link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!----------------------------------------order------------------>
<div class="order cart"><!-----------------logo------------------->
    <div class="logo"><h1 class="wrapper clearfix"><a href="index.jsp"><img class="fl" src="img/temp/logo.png"></a>
    </h1></div>
    <div class="forCon"><p style="font-size:25px;">Reset your password</p>
        <ul>
            <li class="on"><span>Step1/</span>Verify Email</li>
        </ul>
        <div class="formCon">
            <form action="ResetPassword" method="post" class="one">
            	
            	<p><label>Enter your username</label></p><br/>
            	<input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Enter your user name"><span></span></p>
        
           	 		
           	 	<p><label>Enter your email</label></p><br/>
           	 	<p><input type="text" name="email" value="" placeholder="Enter your Email"><span></span></p>
            	
            	
            	<p><label>Enter your new password</label></p><br/>
            	 <p><input type="text" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Enter your password"><span></span></p>
           	 
           	 	<input class="forsub" type="submit" value="Submit">
            </form>
        </div>
        </div>
        
</div>
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
</body>
</html>


    