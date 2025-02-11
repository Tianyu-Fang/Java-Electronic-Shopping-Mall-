<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Home</a><span class="crumb-step">&gt;</span><a class="crumb-name" href ="javascript:history.go(-1)">Category Management</a><span class="crumb-step">&gt;</span><span>Modify Category</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/E-shop/manage/admin_docateupdate" method="post" id="myform" name="myform">
                	<input type="hidden" name="id" value="${cate1.CATE_ID }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>Parent category: </th>
                                <td>
                                    <select class="common-text required"  name="parentId">
                                    	<option value="0">Root category</option>
                                    	<c:forEach var="cate" items="${catelist }">
                                    		<c:if test="${cate.CATE_PARENT_ID == 0 }">
                                    			<c:if test="${cate1.CATE_PARENT_ID == cate.CATE_ID}">
                                    				<option value="${cate.CATE_ID }" selected="selected"> ${cate.CATE_NAME } </option>
                                    			</c:if>
                                    			<c:if test="${cate1.CATE_PARENT_ID != cate.CATE_ID}">
                                    				<option value="${cate.CATE_ID }"> ${cate.CATE_NAME } </option>
                                    			</c:if>
                                    		</c:if>
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Category Name: </th>
                                <td>
                                    <input class="common-text required" id="title" name="className" size="50" value="${cate1.CATE_NAME }" type="text">
                                </td>
                            </tr>
                            
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="Modify" type="submit">
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

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>