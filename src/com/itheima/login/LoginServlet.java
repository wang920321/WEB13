package com.itheima.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		//在ServletContext域中存一个数据count
		int count=0;
		this.getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1获得用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2从数据库验证该用户名密码是否正确
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username=? and password=? ";
		User user=null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3根据返回的结果给用户不同的显示信息
		if(user!=null){
			//从servletContext域中取出count进行++运算
			ServletContext servletContext = this.getServletContext();
			Integer count=(Integer) servletContext.getAttribute("count");
			count++;
			//用户登录成功
			res.getWriter().write(user.toString()+"you are success login person :" +count);
			servletContext.setAttribute("count", count);
		}else{
			//用户登录失败
			res.getWriter().write("sorry your username or password is wrong");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
