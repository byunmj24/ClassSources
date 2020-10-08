package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.IndexAction;
import model.LoginAction;
import model.LogoutAction;
import model.NoticeAction;
import model.SearchAction;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		String viewPath = null;
		Action action = null;
		if(type == null || type.equals("main") || type.equalsIgnoreCase("index")) 
			action = new IndexAction();
		else if(type.equals("login")) 
			//viewPath = "/jsp/login.jsp"; 
			//연산과정이 필요없기 때문에 바로 path를 주어도 무방하다. 하지만 아래쪽에 viewPath 작업이 한번 더 있으므로 지금은 사용할 수 없다.
			action = new LoginAction();
		else if(type.equals("logout")) 
			action = new LogoutAction();
		else if(type.equalsIgnoreCase("notice"))
			action = new NoticeAction();
		else if(type.equalsIgnoreCase("search"))
			action = new SearchAction();
		
		
		viewPath = action.execute(request, response);//indexAction이 수행되었다면 "/jsp/index.jsp"
		
		RequestDispatcher disp = request.getRequestDispatcher(viewPath);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
