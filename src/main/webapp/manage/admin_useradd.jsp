<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Home</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="href ="javascript:history.go(-1)"">User Management</a><span class="crumb-step">&gt;</span><span>Add User</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admin_douseradd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>Username:</th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>Name:</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>Password:</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>Confirm Password:</th>
                                <td>
                                    <input class="common-text required" id="title" name="rePassWord" size="50" value="" type="text">
                                </td>
                            </tr>
                        
                            <tr>
                                <th>Sex:</th>
                                <td> 
                                	<input type="radio" name="sex" value="T" checked="checked">Male
                                	<input type="radio" name="sex" value="F" checked="checked">Female
                                	
                                </td>
                            </tr>
                            <tr>
                                <th>DoB:</th>
                                <td> 
                                	<input class="common-text"  name="birthday" size="50" value="" type="text">
                                
                                </td>
                            </tr>    
                             <tr>
                                <th><i class="require-red">*</i>Email:</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="" type="text">
                                </td>
                            </tr>
                              
                             <tr>
                                <th><i class="require-red">*</i>Phone Number:</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="" type="text">
                                </td>
                            </tr>
                               
                             <tr>
                                <th><i class="require-red">*</i>Address:</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="" type="text">
                                </td>
                            </tr>

                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="submit" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="return" type="button">
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