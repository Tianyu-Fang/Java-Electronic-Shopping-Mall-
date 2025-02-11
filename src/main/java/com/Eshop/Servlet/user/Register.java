package com.Eshop.Servlet.user;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	
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

				esm_user u = new esm_user(username, name, pwd, sex, year, null, email, mobile, address, 1);
				

				int count = esm_UserDao.insert(u);
				


				
				if(count >0 ) {
					
					response.sendRedirect("login.jsp");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('User Register Failed!')");
					out.write("location.href='reg.jsp'");
					out.write("</script>");
					
				}
	}

}
