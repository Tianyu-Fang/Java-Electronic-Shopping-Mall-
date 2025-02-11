package com.Eshop.Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.Eshop.service.esm_UserDao;


import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		
		int count = esm_UserDao.selectByName(name);
	
		
		PrintWriter out = response.getWriter();
		if(count >0 ){
			out.print("false");
		}else{
			out.print("true");
		}
		
	
		
		out.close();
	}
}
