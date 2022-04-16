package ch5.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");	//	获取书本的id
		Book book=(Book)Db.getAll().get(id);	//根据Id查找“数据库”对应的书，即本次购买的书
		HttpSession session=request.getSession();
		
		//从Session得到用户用于保存所有书的集合（购物车）
		List<Book> list=(List)session.getAttribute("listBook");	//首次购买这里没有数据
		//如果是首次购买
		if(list==null) {
			list=new ArrayList();	//新建一个List
			session.setAttribute("listBook", list);	//将购买的书本放入Session
		}
		list.add(book);	//每多买一本，就在List中多添加一本书
		//重定向可以避免刷新时重复购买的情况
		response.sendRedirect(request.getContextPath()+"/ListCarServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
