package com.Eshop.Servlet.home;


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
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<esm_category> flist =  esm_categoryDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<esm_category> clist =  esm_categoryDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String id = request.getParameter("id");

		esm_product p = null;
		esm_category parent = null;
		esm_category child = null;
		if(id !=null) {
			p = esm_productDao.selectById(Integer.parseInt(id));
			String p_name = p.getPRODUCT_NAME();
			parent = esm_categoryDao.selectById(p.getPRODUCT_FID());
			child = esm_categoryDao.selectById(p.getPRODUCT_CID());
			request.setAttribute("p", p);
			request.setAttribute("p_name", p_name);
			request.setAttribute("parent", parent);
			request.setAttribute("child", child);
		}
		
		if(p != null)
		{
			int cid = p.getPRODUCT_CID();
			ArrayList<esm_product> classlist = esm_productDao.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
			
			esm_category cate = esm_categoryDao.selectById(cid);
			request.setAttribute("cate", cate);
			
		}
		
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}

	
}
