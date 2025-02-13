<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.Eshop.service.esm_categoryDao"%>
<%@ page import="com.Eshop.entity.esm_category"%>
<%@ page import="java.util.ArrayList"%>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            	<c:if test="${isLogin!='1' }">
            		<a href="login.jsp" id="login">Login</a><a href="reg.jsp" id="reg">Registration</a>
            	
            	</c:if>
            	
            	<c:if test="${isLogin=='1'}">
            		<b>Hi</b><a>${name.USER_NAME }</a>
            	
            	</c:if>
            	
            	<c:if test="${isAdminLogin =='1'}">
            		<a href="manage/admin_index.jsp" id="login1">Enter Backstage</a>
            	
            	</c:if>
            </p>
                <form action="productsearch" method="post" class="fl"><input value="${param.keywords}" name="keywords" type="text" placeholder="Search by Book Name"/>
                <input value="" type="submit"/></form>
                 <div class="btn fl clearfix">
                 <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                 
                        
                        <a href="showcart"><img src="img/gwc.png"/></a>
                        
                        
                    </div>                   
                    
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">Home</a></li>
            
            <%
            ArrayList<esm_category> flist =  esm_categoryDao.selectCat("father");
            request.setAttribute("flist", flist);
            ArrayList<esm_category> clist =  esm_categoryDao.selectCat("child");
            request.setAttribute("clist", clist);
            %>
            <c:forEach var="f" items="${flist}">
            
            <li><a href="selectproductlist?fid=${f.CATE_ID }">${f.CATE_NAME }</a>
                <div class="sList2">
                    <div class="clearfix">
                    	<c:forEach var="c" items="${clist }">
                    		<c:if test="${f.CATE_ID == c.CATE_PARENT_ID }">
                    			<a href="selectproductlist?cid=${c.CATE_ID }">${c.CATE_NAME }</a>
                    		</c:if>
                    	</c:forEach>
                    </div>
                </div>
            </li>
           </c:forEach>
        </ul>
    </div>
</div>