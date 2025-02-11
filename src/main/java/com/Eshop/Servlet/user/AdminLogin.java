package com.Eshop.Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_UserDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		int count = esm_UserDao.selectByNM(userName, passWord);
		
		//System.out.println(userName + "##"+passWord);
		
		if(count > 0) {
			
			esm_user user = esm_UserDao.selectAdmin(userName, passWord);
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			if(user.getUSER_STATUS() == 2) {
				session.setAttribute("isAdminLogin", "1");
			//	System.out.println(userName + "##"+passWord);
				response.sendRedirect("/E-shop/manage/admin_index.jsp");
			}else{
				
				response.sendRedirect("/E-shop/index.jsp");
			}
	
		
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('Admin Login Failed!');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
