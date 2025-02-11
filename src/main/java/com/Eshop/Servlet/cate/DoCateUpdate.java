package com.Eshop.Servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Eshop.entity.esm_category;
import com.Eshop.service.esm_categoryDao;

import javax.servlet.annotation.WebServlet;
@WebServlet("/manage/admin_docateupdate")


/**
 * Servlet implementation class DoCateUpdate
 */
public class DoCateUpdate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		
		esm_category cate= new esm_category(id, name, fid);
		esm_categoryDao.update(cate);
		
		response.sendRedirect("admin_cateselect");
	}


	

}
