<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>E-shop Back End Management System </title>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/E-shop/manage/admin_index.jsp" class="navbar-brand">Back-end Management</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/E-shop/manage/admin_index.jsp">Home</a></li>
                <li><a href="/E-shop/indexselect" target="_blank">Website Home</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">Admin:${name.USER_NAME}</a></li>
                
                <li><a href="/E-shop/manage/admin_logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>Menu</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>Normal Operation</a>
                    <ul class="sub-menu">
                        <li><a href="/E-shop/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>User</a></li>
                        <li><a href="/E-shop/manage/admin_cateselect"><i class="icon-font">&#xe005;</i>Category</a></li>
                        <li><a href="/E-shop/manage/admin_productselect"><i class="icon-font">&#xe006;</i>Book</a></li>               
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>