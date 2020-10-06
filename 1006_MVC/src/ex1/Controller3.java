package ex1;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex3.DateAction;

/**
 * Servlet implementation class Controller3
 */
@WebServlet("/Controller3")
public class Controller3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//type이라는 파라미터를 받는다.
				//그 값이 "date"이면 "/ex2/date.jsp"로 forward한다. 이때 표현될 값은 현재 날짜이다.
				String type = request.getParameter("type");
				String viewPath = null;
				if(type != null && type.equals("date")) {
					DateAction action = new DateAction();
					viewPath = action.execute(request, response);
				}else if(type != null && type.equals("greet")) {
					request.setAttribute("str", "Why라노? 머선12go?");
					
					viewPath = "/ex2/greet.jsp";
				}
				
				RequestDispatcher disc = request.getRequestDispatcher(viewPath);
				
				//지정된 jsp로 forward한다.
				disc.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
