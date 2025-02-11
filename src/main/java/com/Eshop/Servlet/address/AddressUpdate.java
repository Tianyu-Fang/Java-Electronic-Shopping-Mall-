package com.Eshop.Servlet.address;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_address;
import com.Eshop.service.esm_addressDao;

/**
 * Servlet implementation class AddressUpdate
 */
@WebServlet("/AddressUpdate")
public class AddressUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set character set
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int address_id = Integer.parseInt(request.getParameter("ADDRESS_ID"));
		String user_id = request.getParameter("USER_ID");
		String name = request.getParameter("NAME");
		String phone = request.getParameter("PHONE");
		String state = request.getParameter("STATE");
		String county = request.getParameter("COUNTY");
		String code = request.getParameter("CODE");
		String comment = request.getParameter("COMMENT");
		
		//create user entity
				esm_address address = new esm_address(address_id, user_id, name, phone, state, county, code, comment);
				
				//insert to table in the database
				int count = esm_addressDao.update(address);
				
				//success or fail
				
				if(count >0 ) {
					request.setAttribute("updateStatus", "false");
					request.getRequestDispatcher("ToAddressAdd").forward(request, response);
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('Fail to add delivery address')");
					out.write("location.href='ToAddressAdd'");
					out.write("</script>");
					
				}
				
	}

}
