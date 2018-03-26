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
		// TODO 模拟加入购物车
		//获取用户提交的参数
		String bookId = request.getParameter("bookId");
		//获取session对象
		HttpSession session = request.getSession();
		//获取session中存储的购物车信息参数（bookList）
		ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("bookList");
		//判断购物车是否为空
		if(null == list) {
			list = new ArrayList<>();
		}
		Book book = new Book();
		book.setBookId(Integer.parseInt(bookId.toString().trim()));
		list.add(book);
		//更新session中的购物车参数
		session.setAttribute("bookList", list);
		System.out.println("&&&&&&&&&商品列表：" + list + "&&&&&&&&&&&&&");
		//页面跳转会商品列表界面
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
