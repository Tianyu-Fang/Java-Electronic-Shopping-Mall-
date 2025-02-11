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
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userName");
		String email = request.getParameter("email");
		
		int count = esm_UserDao.selectByNE(id, email);
		
		if(count > 0) {
			
			
			
			String pwd = request.getParameter("passWord");
			
			int password = esm_UserDao.updatePassword(pwd, id);
			
			if(password > 0)
			{
				response.sendRedirect("index.jsp");
				request.setAttribute("cpage", request.getParameter("cpage"));
			}else{
				PrintWriter out = response.getWriter();
				
				out.write("<script>");
				out.write("alert('User password reset failed!');");
				out.write("location.href='forget.jsp'");
				out.write("</script>");
				out.close();
			}
			
			
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('User password reset failed!');");
			out.write("location.href='forget.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
