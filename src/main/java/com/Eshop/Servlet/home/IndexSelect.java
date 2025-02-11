package com.Eshop.Servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import com.Eshop.entity.esm_category;
import com.Eshop.service.esm_categoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexSelect
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<esm_category> flist =  esm_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<esm_category> clist =  esm_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
