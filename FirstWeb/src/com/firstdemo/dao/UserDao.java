package com.firstdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.firstdemo.entity.User;

public class UserDao {
	private static String driver = "com.mysql.jdbc.Driver";  
	private static String url = "jdbc:mysql://localhost:3306/firstweb?characterEncoding=utf8&useSSL=true";  
	private static String username = "root";  
	private static String password = "root";  
	private static Connection connection = null;  
	private static PreparedStatement ps = null;  

	public Connection getConnection() throws ClassNotFoundException, SQLException{  
		Class.forName(driver);  
		connection=DriverManager.getConnection(url, username, password);  
		return connection;  
	}  

	public void closeConnection() throws SQLException{  
		if(connection!=null)  
			connection.close();  
		if(ps!=null)  
			ps.close();  
	}  

	public void saveUser(User user) throws SQLException{  
		try {  
			connection=getConnection();  
			String sql="insert into user values(?,?)";  
			ps=connection.prepareStatement(sql);  
			ps.setString(1, user.getName());  
			ps.setString(2, user.getPassword());  
			ps.executeUpdate();  
		} catch (ClassNotFoundException e) {  
			e.printStackTrace();  
		} catch (SQLException e) {  
			e.printStackTrace();  
		}finally{     
			closeConnection();        
		}  
	}  

	public User findByName(String name) throws SQLException{  
		ResultSet rs = null;  
		User user=new User();  
		try {  
			connection=getConnection();  
			System.out.println("开始读取数据");  
			String sql="select * from user where name='"+name+"'";  
			ps=connection.prepareStatement(sql);  
			rs=ps.executeQuery(sql);  
			while(rs.next()) {  
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));  
				user.setName(rs.getString(1));  
				user.setPassword(rs.getString(2));  
				return user;  
			}  
		} catch (ClassNotFoundException e) {  
			e.printStackTrace();  
		} catch (SQLException e) {  
			e.printStackTrace();  
		}finally{  
			closeConnection();  
		}  
		return user;  
	}  

	public void deleteUser(String name) throws ClassNotFoundException, SQLException{  
		Connection connection=getConnection();  
		String sql="delete from user where name='"+name+"'";  
		ps=connection.prepareStatement(sql);  
		ps.execute(sql);  
		closeConnection();  
	}  

	public void changUser(User user) throws SQLException, ClassNotFoundException{  
		Connection connection=getConnection();  
		String sql="update user set password='"+user.getPassword()+"' where name='"+user.getName()+"' ";  
		ps=connection.prepareStatement(sql);  
		ps.execute(sql);  
		closeConnection();  
	} 

}
