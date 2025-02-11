<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>E-shop Background Management</title>
	<link rel="stylesheet" type="text/css" href="css/login_admin.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>Background Management</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="/E-shop/manage/adminlogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">Admin Name:</label>
                        <input type="text" name="userName" value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">Password:</label>
                        <input type="password" name="passWord" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="Submit" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">Return Home</a> &copy; 2021 Powered by</p>
</div>
</body>
</html>