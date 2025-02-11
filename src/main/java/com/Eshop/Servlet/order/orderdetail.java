package com.Eshop.Servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_address;
import com.Eshop.entity.esm_order;
import com.Eshop.entity.esm_orderitem;
import com.Eshop.entity.esm_product;
import com.Eshop.service.esm_addressDao;
import com.Eshop.service.esm_orderDao;
import com.Eshop.service.esm_orderitemDao;
import com.Eshop.service.esm_productDao;

/**
 * Servlet implementation class orderdetail
 */
@WebServlet("/orderdetail")
public class orderdetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		esm_order o = esm_orderDao.selectById(order_id);
		int total_price = o.getTOTAL_PRICE();
		//esm_address address = esm_addressDao
		ArrayList<esm_orderitem> items = esm_orderitemDao.selectByOrder(order_id);
		ArrayList<Integer> product_ids = new ArrayList<Integer>(items.size());
		for(int i=0; i<items.size(); i++)
		{
			product_ids.add(items.get(i).getPRODUCT_ID());
		}
		esm_address address = esm_addressDao.selectByAddressID(o.getADDRESS_ID());
		ArrayList<esm_product> products = esm_productDao.selectAllById(product_ids);
		request.setAttribute("products", products);
		request.setAttribute("address", address);
		request.setAttribute("order_items", items);
		request.setAttribute("total_price", total_price);
		request.setAttribute("order", o);
		request.getRequestDispatcher("orderdetail.jsp").forward(request, response);
	}

}
