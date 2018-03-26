package net.onest.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.onest.beans.Book;
import net.onest.dao.DatabaseConn;

public class GoodControl {
	private List<Book> list = null;

	/**
	 * 从Modal层获取商品信息(ResultSet)，
	 * 转换成ArrayList集合
	 * @author lww
	 *
	 */
	public List<Book> getGoodsList(){
		ResultSet rs = DatabaseConn.getBooksList();
		list = new ArrayList<>();
		try {
			while(rs.next()) {
				//获取当前行记录并包装成一个Book对象
				int id = rs.getInt("book_id");
				String name = rs.getString("book_name");
				double price = rs.getDouble("book_price");
				//用获取到的数据创建Book对象
				Book book = new Book();
				book.setBookId(id);
				book.setBookName(name);
				book.setBookPrice(price);
				//把book对象添加到商品列表中
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
