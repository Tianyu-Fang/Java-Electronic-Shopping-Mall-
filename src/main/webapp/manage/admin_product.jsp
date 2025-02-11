<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Home</a><span class="crumb-step">&gt;</span><span class="crumb-name">Book Management</span></div>
        </div>
     
        <div id="register" class="result-wrap">
            <form action="/E-shop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/E-shop/manage/admin_toproductadd"><i class="icon-font"></i>Add New Book</a>
                     
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                        <tr>
            
                            <th>ID</th>
                            <th>Product Name</th>
                            <th>Operation</th>
                           
                        </tr>
                        
                        <c:forEach var="p" items="${plist }">
                        	<tr>
                        		<td>${p.PRODUCT_ID }</td>
                        		<td><img src="../images/product/${p.PRODUCT_FILENAME}" width="80" height="80">
                        			${p.PRODUCT_NAME }
                        		
                        		</td>
                        		<td>
                        			<a href="admin_toproductupdate?id=${p.PRODUCT_ID}">Edit</a>
                        			<a href="javascript:productdel(${p.PRODUCT_ID})">Delete</a>
                        		</td>
                        	</tr>
	                    </c:forEach>
                        
                        
                        <script>
                        	function productdel(id) {
                        		if(confirm("Are you sure to delete this product?")) {
                        			location.href="admin_doproductdel?id="+id;
                        			
                        		}
                        	}
                        	
                        	
                        </script>
                        
                    </table>
                    
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</body>
</html>