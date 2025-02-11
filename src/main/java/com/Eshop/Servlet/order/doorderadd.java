package com.Eshop.Servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.Eshop.entity.esm_cart;
import com.Eshop.service.esm_cartDao;
import com.Eshop.entity.esm_order;
import com.Eshop.service.esm_orderDao;
import com.Eshop.entity.esm_orderitem;
import com.Eshop.service.esm_orderitemDao;

/**
 * Servlet implementation class doorderadd
 */
@WebServlet("/doorderadd")
public class doorderadd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session =  request.getSession();
		String user_id = request.getParameter("user_id");
		int total_price = Integer.parseInt(request.getParameter("total_price"));
		String eids = null;
		eids = request.getParameter("eids");
		if(eids==null)
		{
			eids = (String)request.getAttribute("eids");
		}
		int address_id = -1;
		String a_id = request.getParameter("address_id");
		if(a_id!="") {
			address_id = Integer.parseInt(a_id);
		}
		ArrayList<esm_cart> shoplist = (ArrayList<esm_cart>)session.getAttribute("shoplist");
		Date sysdate = new Date();
		//update the order table
		String order_time = String.format("%tF %tT", sysdate, sysdate);
		int order_id = get9UUID();
		int updated_cart = 0;
		if(address_id!=-1) {
		esm_order o = new esm_order (order_id, user_id, "payed", order_time, total_price, address_id, "");
		

		int count = esm_orderDao.insert(o);
		//update the orderitem table (how many products bought in 1 order) 
		int item_count = 0;
		if(count > 0)
		{
			
			for(int i=0; i<shoplist.size(); i++)
			{
				esm_orderitem item= new esm_orderitem(0, o.getORDER_ID(), shoplist.get(i).getCart_p_id(), shoplist.get(i).getCart_quantity());
				esm_orderitemDao.insert(item);
				item_count ++;
			}
		}
		
		//update the cart table (delete the products bought from the cart)
		updated_cart = 0;
		if(item_count==shoplist.size())
		{
			for(int i=0; i<shoplist.size();i++)
			{
				esm_cartDao.getDeleteDD(shoplist.get(i).getCart_id());
				updated_cart++;
			}
			
		}
		//store the order info to the session
		ArrayList<esm_order> user_order = esm_orderDao.selectByUser(user_id);
		session.setAttribute("user_order", user_order);
		}
		//success or fail
		if(updated_cart==shoplist.size()) {
			response.sendRedirect("ok.jsp");
		} else {
			JOptionPane.showMessageDialog(null, "Please Select Address!");
			response.sendRedirect("orderselect?eids="+eids);
		}
		
	}
	//generate unique order id
	public static int get9UUID(){
      
        int hashCode = UUID.randomUUID().toString().hashCode();
  
        if(hashCode < 0){
            hashCode = -hashCode;
        }
     
        String value = String.format("%05d", hashCode);
        return Integer.parseInt(value);
    }

}
