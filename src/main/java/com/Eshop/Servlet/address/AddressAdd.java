package com.Eshop.Servlet.address;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.entity.esm_address;
import com.Eshop.service.esm_addressDao;


/**
 * Servlet implementation class AddressAdd
 */
@WebServlet("/AddressAdd")

public class AddressAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String user_id = request.getParameter("USER_ID");
		String name = request.getParameter("NAME");
		String phone = request.getParameter("PHONE");
		String state = request.getParameter("STATE");
		String county = request.getParameter("COUNTY");
		String code = request.getParameter("CODE");
		String comment = request.getParameter("COMMENT");
		//create user entity
		esm_address address = new esm_address(0, user_id, name, phone, state, county, code, comment);
		
		//insert to table in the database
		int count = esm_addressDao.insert(address);
		

		//success or fail
		
		if(count >0 ) {
						ArrayList<esm_address> a =  esm_addressDao.selectByID(user_id);
			
			
			request.setAttribute("id", user_id);
			request.setAttribute("addresslist", a);

			request.getRequestDispatcher("address.jsp").forward(request, response);
			
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('Fail to add delivery address')");
			out.write("location.href='address.jsp'");
			out.write("</script>");
			
		}
		
	}

}
