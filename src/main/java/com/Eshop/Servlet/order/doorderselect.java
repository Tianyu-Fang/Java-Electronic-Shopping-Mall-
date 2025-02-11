package com.Eshop.Servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Eshop.entity.esm_order;
import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_orderDao;


/**
 * Servlet implementation class doorderselect
 */
@WebServlet("/doorderselect")
public class doorderselect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int cpage = 1; //current page
		int count = 4; //numbers of records each page
		
		//obtain the page user select
		String cp = request.getParameter("cp");
		String status = request.getParameter("status");
		HttpSession session = request.getSession();
		//obtain the keyword user search
		String keyword = request.getParameter("keywords");
		esm_user u= (esm_user) session.getAttribute("name");
		if(cp!=null)
		{
			cpage = Integer.parseInt(cp);
		}

		ArrayList<esm_order> list = new ArrayList<esm_order>();
		//obtain all user records
		if(status!=null)
		{
			if(status.equals("received"))
			{ 
			
			int arr[] = esm_orderDao.totalPageReceived(count, keyword, u.getUSER_ID());
			list= esm_orderDao.selectAllByUserReceived(cpage, count, keyword, u.getUSER_ID());
			
			request.setAttribute("tsum", arr[0]);
			request.setAttribute("tpage", arr[1]);
			}
			else if(status.equals("payed"))
			{
			 int arr[] = esm_orderDao.totalPagePayed(count, keyword, u.getUSER_ID());
			 list= esm_orderDao.selectAllByUserPayed(cpage, count, keyword, u.getUSER_ID());
			 
			 request.setAttribute("tsum", arr[0]);
			 request.setAttribute("tpage", arr[1]);
			}
			else
			{
			 int arr[] = esm_orderDao.totalPage(count, keyword, u.getUSER_ID());
			 list= esm_orderDao.selectAllByUser(cpage, count, keyword, u.getUSER_ID());
			 
			 request.setAttribute("tsum", arr[0]);
			 request.setAttribute("tpage", arr[1]);
			}
		}
		else
		{
			 int arr[] = esm_orderDao.totalPage(count, keyword, u.getUSER_ID());
			 list= esm_orderDao.selectAllByUser(cpage, count, keyword, u.getUSER_ID());
			 
			 request.setAttribute("tsum", arr[0]);
			 request.setAttribute("tpage", arr[1]);

		}
	
		//put into request object domain
		request.setAttribute("orderlist", list);
		request.setAttribute("cpage", cpage);
		request.setAttribute("status", status);
		
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("myorderq.jsp").forward(request, response);
		
	
	}

}
