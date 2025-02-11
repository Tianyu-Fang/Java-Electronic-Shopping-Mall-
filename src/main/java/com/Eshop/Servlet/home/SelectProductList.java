package com.Eshop.Servlet.home;


import java.io.IOException;
import java.util.ArrayList;

import com.Eshop.entity.esm_category;
import com.Eshop.service.esm_categoryDao;
import com.Eshop.entity.esm_product;
import com.Eshop.service.esm_productDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<esm_category> flist =  esm_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<esm_category> clist =  esm_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		int id=0;
		ArrayList<esm_product> list = null;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list = esm_productDao.selectAllByFid(id);
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list = esm_productDao.selectAllByCid(id);
		}
		
		request.setAttribute("title", esm_categoryDao.selectById(id).getCATE_NAME());
		//father of the selected category
		int f = esm_categoryDao.selectById(id).getCATE_PARENT_ID();
		if(f!=0)
		{		
			request.setAttribute("parent", esm_categoryDao.selectById(f));
		}

		request.setAttribute("list", list);
		
		request.setAttribute("fid", fid);
		request.setAttribute("cid", cid);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}



}