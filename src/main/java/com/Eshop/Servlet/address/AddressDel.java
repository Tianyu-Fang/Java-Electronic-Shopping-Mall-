package com.Eshop.Servlet.address;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.service.esm_addressDao;

/**
 * Servlet implementation class AddressDel
 */
@WebServlet("/AddressDel")
public class AddressDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String eids = request.getParameter("eids");
		response.setContentType("text/html;charset=utf-8");
		
		int address_id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("eids", eids);
		esm_addressDao.del(address_id);
		if(eids!=null)
		{
			request.getRequestDispatcher("orderselect").forward(request, response);
		}
		else {
		request.getRequestDispatcher("ToAddressAdd").forward(request, response);
		}
		
		
	}

	
}
