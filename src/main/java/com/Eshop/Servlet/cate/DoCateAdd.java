package com.Eshop.Servlet.cate;

import java.io.IOException;

import com.Eshop.entity.esm_category;
import com.Eshop.service.esm_categoryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/manage/admin_docateadd")
/**
 * Servlet implementation class DoCateAdd
 */
public class DoCateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		
		esm_category cate= new esm_category(0, name, fid);
		esm_categoryDao.insert(cate);
		
		response.sendRedirect("admin_cateselect");
		
	}


}
