package com.Eshop.Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_UserDao;
import com.Eshop.entity.esm_user;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")


public class DoUserAdd extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//create user entity
		esm_user u = new esm_user(username, name, pwd, sex, year, null, email, mobile, address, 1);
		
		//insert to table in the database
		int count = esm_UserDao.insert(u);
		

		//success or fail
		
		if(count >0 ) {
			
			response.sendRedirect("admin_douserselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('Fail to add user')");
			out.write("location.href='manage/admin_useradd.jsp'");
			out.write("</script>");
			
		}
		
	}

}
