package com.Eshop.Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import com.Eshop.service.esm_UserDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//set character set
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
				String id= request.getParameter("id");
			
				//add into user table in database
				int count = esm_UserDao.del(id);
				

				//successful or failed redirect
				
				if(count >0 ) {
					
					response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('User delete failed!')");
					out.write("location.href='manage/admin_douserselect?cp="+request.getParameter("cpage")+"'");
					out.write("</script>");
					
				}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set character set
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[]= request.getParameterValues("id[]");
	
		
		for(int i=0; i<ids.length; i++) {
			//add into user table in database
			esm_UserDao.del(ids[i]);
		
		}
		//successful or failed redirect
		
	
			
		response.sendRedirect("/E-shop/manage/admin_douserselect");
		
	}

}
