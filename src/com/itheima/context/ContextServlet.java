package com.itheima.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获得ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//获得初始化参数
		String driver = servletContext.getInitParameter("driver");
		System.out.println(driver);
		//2获得a b c d.txt的绝对路径
		//2.1获得a.txt
		String realPath_A = servletContext.getRealPath("/a.txt");
		System.out.println(realPath_A);
		//2.2获得b.txt
		String realPath_b = servletContext.getRealPath("WEB-INF/b.txt");
		System.out.println(realPath_b);
		//2.3获得c.txt
		String realPath_c = servletContext.getRealPath("WEB-INF/classes/c.txt");
		System.out.println(realPath_c);
		//2.3获得d.txt?获取不到
		
		//在读取src(classes)下的资源可以同类加载器----专门加载classes下的文件de
		//getResource()参数是一个相对地址  相对于classes
		String path=ContextServlet.class.getClassLoader().getResource("c.txt").getPath();		
		System.out.println(path);
		
		
		
		//3域对象--从servletContext中存数据
		servletContext.setAttribute("name", "zhangsansan");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
