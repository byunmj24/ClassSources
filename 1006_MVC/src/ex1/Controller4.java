package ex1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex4.Action1;
import ex4.Action2;
import ex4.Action3;

/**
 * Servlet implementation class Controller4
 */
@WebServlet("/Controller4")
public class Controller4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//type이 "t1"이면 Action1을 수행하고, "t2"면 Action2를 수행한다.
		//단순하게 JSP로 이동하도록 하자
		String type = request.getParameter("type");
		String viewPath = null;
		//그냥 해본 코드
		if(type != null) {
			switch(type) {
				case "t1" : viewPath = new Action1().execute(request, response);//res1.jsp
				case "t2" : viewPath = new Action2().execute(request, response);//data.jsp
				case "t3" : viewPath = new Action3().execute(request, response);//ar.jsp
			}
		}
		
		/*
		if(type != null && type.equals("t1")){
			Action1 action = new Action1();
			viewPath = action.execute(request, response);//res1.jsp
		}else if(type != null && type.equals("t2")) {
			Action2 action = new Action2();
			viewPath = action.execute(request, response);//data.jsp
		}else if(type != null && type.equals("t3")) {
			Action3 action = new Action3();
			viewPath = action.execute(request, response);//ar.jsp
		}
		*/
		
	
		//forward를 한다.
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
