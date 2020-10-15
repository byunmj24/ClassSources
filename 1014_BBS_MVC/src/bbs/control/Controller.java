package bbs.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.action.Action;
import bbs.action.ListAction;
import bbs.action.ViewAction;
import bbs.action.WriteAction;


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
		
		Action action = null;
		if(type == null || type.equals("list"))
			action = new ListAction();
		else if(type.equals("write"))
			action = new WriteAction();
		else if(type.equals("view"))
			action = new ViewAction();
		
		String viewPath = action.execute(request, response);
		if(viewPath != null) {
		RequestDispatcher disp = request.getRequestDispatcher(viewPath);
		
		disp.forward(request, response);
		} else {
			//viewPath가 null을 가졌다면 목록창으로 이동한다.
			//때에 따라서 sendRedirect가 필요하다면 이렇게도 쓸 수 있다.
			response.sendRedirect("Controller");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
