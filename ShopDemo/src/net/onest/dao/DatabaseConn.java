package net.onest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConn {
	 //�����ַ���
	static String driverStr = "com.mysql.jdbc.Driver";
	//���ݿ������ַ���
	static String connUrl = "jdbc:mysql://127.0.0.1:3306/bookshop?useUnicode=true&characterEncoding=UTF-8";
	//���ݿ����Ӷ���
	static Connection conn = null;
	
	//��ȡͼ���б�
	public static ResultSet getBooksList() {
		try {
			//1.�������ݿ�����
			Class.forName(driverStr);
			//2.��ȡ���ݿ�����
			conn = DriverManager.getConnection(connUrl, "root", "");
			//3.����Statement����,��ִ����Ӧsql��䣬��ȡͼ���б�
			Statement statement = conn.createStatement();
			String sqlStr = "select book_id,book_name,book_price from book";
			ResultSet booksListRS = statement.executeQuery(sqlStr);
			return booksListRS;
			//4.�ر����ݿ�����
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
