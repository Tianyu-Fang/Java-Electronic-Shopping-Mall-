package com.Eshop.Servlet.address;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Eshop.entity.esm_address;
import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_addressDao;

/**
 * Servlet implementation class ToAddressAdd
 */
@WebServlet("/ToAddressAdd")
public class ToAddressAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		esm_user user = (esm_user) session.getAttribute("name");
		String id = user.getUSER_ID();
		System.out.print(id);
		
		ArrayList<esm_address> a =  esm_addressDao.selectByID(id);
		String updateStatus = (String)request.getAttribute("updateStatus");
		System.out.println(updateStatus);
		request.setAttribute("id", id);
		request.setAttribute("addresslist", a);
		request.setAttribute("updateStatus", updateStatus);
		request.getRequestDispatcher("address.jsp").forward(request, response);
	}
	
}
