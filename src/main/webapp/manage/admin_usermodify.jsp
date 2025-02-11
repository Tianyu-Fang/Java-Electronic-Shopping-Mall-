<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">
            	</i><a href="/E-shop/manage/admin_index.jsp">Main Page</a>
            	<span class="crumb-step">&gt;</span>
            	<a class="crumb-name" href="/E-shop/manage/admin_douserselect">User Management</a>
            	<span class="crumb-step">&gt;</span><span>Modify User</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/E-shop/manage/admin_douserupdate" method="post" id="myform" name="myform">
                	<input type="hidden" name="userStatus" value="${user.USER_STATUS }">
                
                	<input type="hidden" name="cpage" value="${cpage }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>Username:</th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="${user.USER_ID }" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Name:</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${user.USER_NAME }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Password:</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" size="50" value="${user.USER_PASSWORD }" type="text">
                                </td>
                            </tr>
                            
                            
                            
                             <tr>
                                <th>Sex:</th>
                                <td>
                                	<input type="radio" name="sex" value="T" ${user.USER_SEX=='T'?"checked":"" }>Male
                                	<input  type="radio" name="sex" value="F" ${user.USER_SEX=='F'?"checked":"" }>Female
                                </td>
                            </tr>
                            
                            
                            <tr>
                                <th>DoB:</th>
                                <td><input class="common-text" name="birthday" size="50" value="${user.USER_BIRTHDAY }" type="text"></td>
                            </tr>
                           
                              <tr>
                                <th><i class="require-red">*</i>Email:</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="${user.USER_EMAIL }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Phone Number:</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="${user.USER_MOBILE }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Address:</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="${user.USER_ADDRESS }" type="text">
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