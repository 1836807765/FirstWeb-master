package com.firstdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstdemo.dao.UserDao;
import com.firstdemo.entity.User;

public class Change extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{  
		HttpSession hs=req.getSession();  
		String name=(String) hs.getAttribute("1");  
		System.out.println("当前登陆用户名"+name);  
		String password=(String) hs.getAttribute("2");  
		String password1=req.getParameter("password1");//������  
		String password2=req.getParameter("password2");//��������һ������  
		if(password.equals(password1)){  
			String msg1="新输入的密码与旧密码一样，请重新输入";  
			req.setAttribute("msg1", msg1);  
			req.getRequestDispatcher("Change.jsp").forward(req,resp);  
		}else if(!password2.equals(password1)){  
			String msg2="密码不一致！请重新输入";  
			req.setAttribute("msg2", msg2);  
			req.getRequestDispatcher("Change.jsp").forward(req,resp);  
		}else  if(password2.equals(password1)){  
			System.out.println(",,,,,,,,,,,,,,,,,,,");  
			UserDao userDao=new UserDao();  
			User user=new User();  
			user.setName(name);  
			user.setPassword(password1);  
			try {  
				userDao.changUser(user);  
			} catch (ClassNotFoundException | SQLException e) {  
				e.printStackTrace();  
			}  
			String msg="密码修改成功，请重新登陆！";  
			req.setAttribute("msg", msg);  
			req.getRequestDispatcher("Login.jsp").forward(req,resp);  
		}  


	}  
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{  
		doGet(req, resp);  

	}  


}
