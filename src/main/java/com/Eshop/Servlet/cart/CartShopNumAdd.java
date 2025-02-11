package com.Eshop.Servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.service.esm_cartDao;

/**
 * Servlet implementation class CartShopNumAdd
 */
@WebServlet("/cartshopnumadd")
public class CartShopNumAdd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String count = request.getParameter("count");
		String esid = request.getParameter("esid");
		
		esm_cartDao.updatenum(Integer.parseInt(esid), Integer.parseInt(count));
	}

}
