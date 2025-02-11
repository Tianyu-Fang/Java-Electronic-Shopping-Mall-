package com.Eshop.Servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_category;
import com.Eshop.entity.esm_product;
import com.Eshop.service.esm_categoryDao;
import com.Eshop.service.esm_productDao;

/**
 * Servlet implementation class ToProductUpdate
 */
@WebServlet("/manage/admin_toproductupdate")
public class ToProductUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		//search data by id
		esm_product product = esm_productDao.selectByID(id);
		
		request.setAttribute("product", product);
		
		
		request.setAttribute("cpage", request.getParameter("cpage"));
		
		ArrayList<esm_category> flist =  esm_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<esm_category> clist =  esm_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("admin_productmodify.jsp").forward(request, response);
		
	}



}
