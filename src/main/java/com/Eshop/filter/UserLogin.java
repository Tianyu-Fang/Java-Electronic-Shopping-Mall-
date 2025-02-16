package com.Eshop.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserLogin
 */
@WebFilter("/*")
public class UserLogin implements Filter {

    /**
     * Default constructor. 
     */
    public UserLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		HttpSession session = req.getSession();
		
		String flag = (String)session.getAttribute("isLogin");
		
		String request_uri = req.getRequestURI();
		String ctxPath= req.getContextPath();
		String uri= request_uri.substring(ctxPath.length());
		
	//	System.out.println(request_uri+"##"+ctxPath+"##"+uri+"##"+flag);
		
		if(uri.contains("showcart")||uri.contains("mygxin") || uri.contains("cartadd")){
			if(flag !=null && flag.equals("1")) {
				chain.doFilter(req, resp);
			}else{
				PrintWriter out = resp.getWriter();
				out.write("<script>");
				out.write("alert('Please Login First');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
		}else{
			chain.doFilter(req, resp);	
		}
		
		return;
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
