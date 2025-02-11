<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    
    <style>
    	.reg p .error {
    		display:inline-block;
    		border:1px solid #ff855a;
    		background-color:#ffe8e0;
    		height:25px;
    		line-height:25px;
    		padding:0px 20px;
    		margin-left:20px;
    	}
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)">
    	<h1><a href="indexselect"><img src="img/temp/logo.png"></a></h1>
        <h1 style="padding:0px;
        	magin:0px;
        	font-size:30px;
        	background:#3344AA;
        	text-align:center;
        	line-height:40px;
        	color:#FFFFFF">User Register</h1>
        	
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Enter your user name"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Enter your real name"><span></span></p>
        <p><input type="text" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Enter your password"><span></span></p>
        <p><input type="text" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Confirm your password"><span></span></p>
        <p>
        	<input style="width:45px;height:15px" type="radio" name="sex" value="T" checked="checked">Male
        	<input style="width:45px;height:15px" type="radio" name="sex" value="F" >Female
        </p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="Enter your DoB(xxxx-xx-xx)"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="Enter your Email"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="Enter your phone number"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="Enter your address"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" 
        		  style="width:270px; height:40px" 
        		  onfocus="FocusItem(this)" onblur="CheckItem(this)" 
        		  placeholder="Verification Code">

        <img height="25" src="getcode" alt="Change one image" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="Register"></p>
        <p class="txtL txt">By completing this registration, you agree to our<a href="#">
            &ltTerm of use and privacy policy&gt
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>Already has an account? log in</a></p>
        
</div>
</body>
</html>