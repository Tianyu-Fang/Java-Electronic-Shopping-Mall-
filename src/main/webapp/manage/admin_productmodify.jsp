<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">
            	</i><a href="/E-shop/manage/admin_index.jsp">Home</a>
            	<span class="crumb-step">&gt;</span>
            	<a class="crumb-name" href="/E-shop/manage/admin_productselect">Book management</a>
            	<span class="crumb-step">&gt;</span><span>Modify Book</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/E-shop/manage/admin_doproductupdate" method="post" enctype="multipart/form-data" id="myform" name="myform">
				<input type="hidden" name="id" value="${product.PRODUCT_ID}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>Product name:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productName" size="50" value="${product.PRODUCT_NAME}" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Product description:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productDesc" size="50" value="${product.PRODUCT_DESCRIPTION }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Product price:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productPrice" size="50" value="${product.PRODUCT_PRICE }" type="text">
                                </td>
                            </tr>
                            
                            
              
                          <tr>
                                <th><i class="require-red">*</i>Product stock:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productStock" size="50" value="${product.PRODUCT_STOCK }" type="text">
                                </td>
                            </tr>

                            <tr>
                                <th><i class="require-red">*</i>Book Category:</th>
                                <td>
                                    <select class="common-text required"  name="parentId" >
                                    	
                                    	<c:forEach var="f" items="${flist }">
                                    		<option value="${f.CATE_ID }" disabled="disabled"> |-${f.CATE_NAME } </option>
                                    		<c:forEach var="c" items="${clist }">
                                    			<c:if test="${c.CATE_PARENT_ID == f.CATE_ID}">	
                                    				<c:if test="${c.CATE_ID == product.PRODUCT_CID}">	
                                    				<option selected="selected" value="${f.CATE_ID }-${c.CATE_ID }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.CATE_NAME } </option>
                                    				</c:if>
                                    				<c:if test="${c.CATE_ID != product.PRODUCT_CID}">	
                                    				<option value="${f.CATE_ID }-${c.CATE_ID }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.CATE_NAME } </option>
                                    				</c:if>
                                    			</c:if>
                                    		</c:forEach>
                                    	</c:forEach>
                                 
                                    </select>
                                </td>
                            </tr>
                          <tr>
                                <th><i class="require-red">*</i>Book Picture:</th>
                                <td>
                                    <input class="common-text required" id="title" name="photo" size="50" value="${product.PRODUCT_FILENAME }" type="file">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="Submit" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="Return" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>