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
	 * ��Modal���ȡ��Ʒ��Ϣ(ResultSet)��
	 * ת����ArrayList����
	 * @author lww
	 *
	 */
	public List<Book> getGoodsList(){
		ResultSet rs = DatabaseConn.getBooksList();
		list = new ArrayList<>();
		try {
			while(rs.next()) {
				//��ȡ��ǰ�м�¼����װ��һ��Book����
				int id = rs.getInt("book_id");
				String name = rs.getString("book_name");
				double price = rs.getDouble("book_price");
				//�û�ȡ�������ݴ���Book����
				Book book = new Book();
				book.setBookId(id);
				book.setBookName(name);
				book.setBookPrice(price);
				//��book������ӵ���Ʒ�б���
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
