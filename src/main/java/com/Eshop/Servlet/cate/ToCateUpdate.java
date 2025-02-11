package com.Eshop.Servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Eshop.entity.esm_category;
import com.Eshop.service.esm_categoryDao;

import javax.servlet.annotation.WebServlet;
@WebServlet("/manage/admin_tocateupdate")

/**
 * Servlet implementation class ToCateUpdate
 */
public class ToCateUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	
		
		esm_category cate =  esm_categoryDao.selectById(id);
		
		
		ArrayList<esm_category> catelist = esm_categoryDao.selectAll();
		
		request.setAttribute("catelist", catelist);
		request.setAttribute("cate1", cate);
		
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}



}
