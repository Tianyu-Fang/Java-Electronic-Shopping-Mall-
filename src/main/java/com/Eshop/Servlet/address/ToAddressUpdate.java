package com.Eshop.Servlet.address;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_address;
import com.Eshop.service.esm_addressDao;

/**
 * Servlet implementation class ToAdressUpdate
 */
@WebServlet("/ToAddressUpdate")
public class ToAddressUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int address_id = Integer.parseInt(request.getParameter("ADDRESS_ID"));
		esm_address addr = esm_addressDao.selectByAddressID(address_id);
		
		request.setAttribute("a", addr);
		request.setAttribute("updateStatus", "true");
		request.getRequestDispatcher("ToAddressAdd").forward(request, response);
	}

}
