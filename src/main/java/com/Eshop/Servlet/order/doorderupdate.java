package com.Eshop.Servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eshop.service.esm_orderDao;

/**
 * Servlet implementation class doorderupdate
 */
@WebServlet("/doorderupdate")
public class doorderupdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int order_id = Integer.parseInt(request.getParameter("id"));
		int count = esm_orderDao.updateStatus(order_id);

		if(count>0) {
			response.sendRedirect("doorderselect?cp="+request.getParameter("cpage"));
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('Confirm Failure')");
			out.write("location.href='doorderselect?cp="+request.getParameter("cpage"));
			out.write("</script>");
			
		}
	}

}
