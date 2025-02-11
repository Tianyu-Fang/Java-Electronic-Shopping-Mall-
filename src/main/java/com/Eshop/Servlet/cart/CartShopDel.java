package com.Eshop.Servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.service.esm_cartDao;

/**
 * Servlet implementation class CartShopDel
 */
@WebServlet("/cartshopdel")
public class CartShopDel extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String esid = request.getParameter("esid");
		
		esm_cartDao.getDeleteDD(Integer.parseInt(esid));
	}
	

}