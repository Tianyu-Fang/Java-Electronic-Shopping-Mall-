package com.Eshop.Servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Eshop.entity.esm_product;
import com.Eshop.service.esm_productDao;

/**
 * Servlet implementation class productsearch
 */
@WebServlet("/productsearch")
public class productsearch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keywords");
		System.out.println(keyword);
		String search = "done";
		ArrayList<esm_product> list = esm_productDao.selectAllByKeywords(keyword);
		request.setAttribute("number", list.size());
		request.setAttribute("search", search);
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
