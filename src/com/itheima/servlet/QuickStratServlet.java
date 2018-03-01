package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStratServlet implements Servlet{
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//1获得servlet的name-- <servlet-name>abc</servlet-name>
		
		System.out.println("  init..."+arg0.getServletName());
		//2获得该servlet的初始化的参数
		System.out.println(arg0.getInitParameter("url"));
		//3获得servletContext对象
		System.out.println(arg0.getServletContext());
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("QuickStratServlet running....");
		arg1.getWriter().write("QuickStratServlet running....");
		
	}
	@Override
	public void destroy() {
		System.out.println("destroy......");
		
	}

	
	
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
