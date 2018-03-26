package net.onest.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.onest.beans.Book;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ģ����빺�ﳵ
		//��ȡ�û��ύ�Ĳ���
		String bookId = request.getParameter("bookId");
		//��ȡsession����
		HttpSession session = request.getSession();
		//��ȡsession�д洢�Ĺ��ﳵ��Ϣ������bookList��
		ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("bookList");
		//�жϹ��ﳵ�Ƿ�Ϊ��
		if(null == list) {
			list = new ArrayList<>();
		}
		Book book = new Book();
		book.setBookId(Integer.parseInt(bookId.toString().trim()));
		list.add(book);
		//����session�еĹ��ﳵ����
		session.setAttribute("bookList", list);
		System.out.println("&&&&&&&&&��Ʒ�б�" + list + "&&&&&&&&&&&&&");
		//ҳ����ת����Ʒ�б����
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
