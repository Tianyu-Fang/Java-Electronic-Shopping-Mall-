package com.esm.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.esm.entity.esm_user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set characterset
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		//create user entity
		esm_user u=new esm_user(username,name,pwd,sex,year,null,email,mobile,address,0);
		
		//加入到数据库的用户表中
				System.out.print(u);
				
		//成功或失败重定向到哪里
		
				if(true) {
					
					response.sendRedirect("admin_user.jsp");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('用户添加失败')");
					out.write("location.href='manage/admin_useradd.jsp'");
					out.write("</script>");
					
				}
	}		
}
