package com.Eshop.Servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import com.Eshop.entity.esm_user;
import com.Eshop.service.esm_UserDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")

public class DoUserSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage = 1; //current page
		int count = 2; //numbers of records each page
		
		//obtain the page user select
		String cp = request.getParameter("cp");
		
		//obtain the keyword user search
		String keyword = request.getParameter("keywords");
		
		if(cp!=null)
		{
			cpage = Integer.parseInt(cp);
		}
		
		int arr[] = esm_UserDao.totalPage(count, keyword);
		
		
		//obtain all user records
		ArrayList<esm_user>	list= esm_UserDao.selectAll(cpage, count, keyword);
	
		//put into request object domain
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
	
	}

	
}
