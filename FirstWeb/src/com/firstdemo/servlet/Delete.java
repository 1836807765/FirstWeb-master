package com.firstdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstdemo.dao.UserDao;

public class Delete extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{  
		//resp.setContentType("text/html;charset=uft-8");  
		HttpSession hs=req.getSession();  
		String name=(String) hs.getAttribute("1");  
		UserDao userDao=new UserDao();  
		try {  
			userDao.deleteUser(name);  
		} catch (ClassNotFoundException | SQLException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
		String msg="用户删除成功";  
		req.setAttribute("msg", msg);  
		req.getRequestDispatcher("Login.jsp").forward(req, resp);  
	}  
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{  
		doGet(req, resp);  

	}  


}
