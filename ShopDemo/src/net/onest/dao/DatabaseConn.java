package net.onest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConn {
	 //驱动字符串
	static String driverStr = "com.mysql.jdbc.Driver";
	//数据库连接字符串
	static String connUrl = "jdbc:mysql://127.0.0.1:3306/bookshop?useUnicode=true&characterEncoding=UTF-8";
	//数据库连接对象
	static Connection conn = null;
	
	//获取图书列表
	public static ResultSet getBooksList() {
		try {
			//1.加载数据库驱动
			Class.forName(driverStr);
			//2.获取数据库连接
			conn = DriverManager.getConnection(connUrl, "root", "");
			//3.创建Statement对象,并执行响应sql语句，获取图书列表
			Statement statement = conn.createStatement();
			String sqlStr = "select book_id,book_name,book_price from book";
			ResultSet booksListRS = statement.executeQuery(sqlStr);
			return booksListRS;
			//4.关闭数据库连接
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
