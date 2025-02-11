<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post"><h1><a href="indexselect"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>Automatic login is not recommended in public places</div>
        <p><input type="text" name="userName" value="" placeholder="UserName"></p>
        <p><input type="text" name="passWord" value="" placeholder="Password"></p>
        <p><input type="submit" name="" value="Login"></p>
        <p class="txt"><a class="" href="reg.jsp">Free Registration</a><a style="margin-left:5%;"href="forget.jsp">Forget Password?</a></p></form>
</div>
</body>
</html>