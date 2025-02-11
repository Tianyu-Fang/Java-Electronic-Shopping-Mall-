package com.Eshop.Servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Eshop.entity.esm_address;
import com.Eshop.entity.esm_cart;
import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_addressDao;
import com.Eshop.service.esm_cartDao;

/**
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		esm_user user=(esm_user)session.getAttribute("name");
		
		String eids = null;
		eids = request.getParameter("eids");
		if(eids==null)
		{
			eids = (String)request.getAttribute("eids");
		}
		
		ArrayList<esm_address> address= esm_addressDao.selectByID(user.getUSER_ID());
		
		if(user!=null && isLogin.equals("1")) {
			int totalprice = 0;
			
			String ids[] = eids.split(",");
			
			ArrayList<esm_cart> list = new ArrayList<esm_cart>();
			
			for(int i=0; i<ids.length; i++) {
				esm_cart es = esm_cartDao.getCartShop(Integer.parseInt(ids[i]));
				
				int dprice = es.getCart_p_price() * es.getCart_quantity();
				
				totalprice += dprice;
				
				list.add(es);
			}
			
			request.setAttribute("shoplist", list);
			request.setAttribute("totalprice", totalprice);
			request.setAttribute("address", address);
			request.setAttribute("eids", eids);
			request.getRequestDispatcher("order.jsp").forward(request, response);
			
		}else{
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('buy after log in');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}

	

