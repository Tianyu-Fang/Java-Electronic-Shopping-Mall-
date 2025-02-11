package com.Eshop.Servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.Eshop.entity.esm_cart;
import com.Eshop.entity.esm_product;
import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_cartDao;
import com.Eshop.service.esm_productDao;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		esm_product p = null;
		
		String pid = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		
		HttpSession session = request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		esm_user user = (esm_user)session.getAttribute("name");
		boolean maximum = false;
		if(user!=null && isLogin.equals("1")) {
			String uid = (String)user.getUSER_ID();

			esm_cart srcsp = esm_cartDao.getCartShop(uid, pid);
			
			if(srcsp != null) {
				int srccount = srcsp.getCart_quantity();
				
				int newcount = srccount + Integer.parseInt(count);
				
				if(newcount >=5) {
					newcount =5;
					maximum = true;
				}
				
				esm_cartDao.updatenum(srcsp.getCart_id(), newcount);
				
			}else {
			
			if(pid!=null) {
				p = esm_productDao.selectById(Integer.parseInt(pid));
			}
			esm_cart cart = new esm_cart(
					0,
					p.getPRODUCT_FILENAME(),
					p.getPRODUCT_NAME(),
					p.getPRODUCT_PRICE(),
					Integer.parseInt(count),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_ID(),
					uid,
					1);
			
			esm_cartDao.insert(cart);	
			}	
		}else {
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('Buy it after you log in')");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(url.equals("z")) {
			response.sendRedirect("showcart");
		}else{
			if(!maximum) {
			JOptionPane.showMessageDialog(null, "Add to cart successfully");
			}
			else {
				JOptionPane.showMessageDialog(null, "Maximum five");
			}
			response.sendRedirect("selectproductview?id="+pid);
			
		}
	}


}
