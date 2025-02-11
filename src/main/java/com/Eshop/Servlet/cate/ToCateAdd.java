package com.Eshop.Servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_category;
import com.Eshop.service.esm_categoryDao;

@WebServlet("/manage/admin_tocateadd")
/**
 * Servlet implementation class ToCateAdd
 */
public class ToCateAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<esm_category> catelist = esm_categoryDao.selectAll();
		
		request.setAttribute("catelist", catelist);
		
		request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);
	}



}
