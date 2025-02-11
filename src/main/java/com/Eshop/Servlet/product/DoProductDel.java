package com.Eshop.Servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.service.esm_productDao;

/**
 * Servlet implementation class DoProductDel
 */
@WebServlet("/manage/admin_doproductdel")
public class DoProductDel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		esm_productDao.del(id);
		response.sendRedirect("admin_productselect");
	}

	
}
