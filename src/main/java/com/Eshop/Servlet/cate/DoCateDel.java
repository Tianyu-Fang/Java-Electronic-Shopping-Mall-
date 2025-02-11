package com.Eshop.Servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Eshop.service.esm_categoryDao;

import javax.servlet.annotation.WebServlet;
@WebServlet("/manage/admin_docatedel")

/**
 * Servlet implementation class DoCateDel
 */
public class DoCateDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		esm_categoryDao.del(id);
		response.sendRedirect("admin_cateselect");
	}


}
