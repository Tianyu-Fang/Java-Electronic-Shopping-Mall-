package com.Eshop.Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_UserDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set character set
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String userStatus = request.getParameter("userStatus");
		
		int status = 1;
		
		if(userStatus != null) {
			status = Integer.parseInt(userStatus);
		}
		
		//create user entity
		esm_user user = new esm_user(username, name, pwd, sex, birthday, null, email, mobile, address, status);
		
		//add into user table in database
		int count = esm_UserDao.update(user);
		

		//success or failure redirect to
		
		if(count >0 ) {
			
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('User Edit Failure')");
			out.write("location.href='manage/admin_touserupdate?id="+username+"'");
			out.write("</script>");
			
		}
		
	}

}
