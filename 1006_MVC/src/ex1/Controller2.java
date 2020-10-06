package ex1;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller2() {
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
			//현재 날짜 구하기
			Date now = new Date(System.currentTimeMillis());
			
			//now는 Date객체이며 현재 날짜를 기억하고 있다. 이것을 하나의 문자열로 받아낸다.
			String nowDate = now.toString();
			
			//현재 날짜를 문자열로 변환된 값을 request에 저장
			request.setAttribute("date", nowDate);
			
			viewPath = "/ex2/date.jsp";
		}else if(type != null && type.equals("greet")) {
			request.setAttribute("str", "Why라노? 머선12go?");
			
			viewPath = "/ex2/greet.jsp";
		}
		
		
		/* 내 code
		String type = request.getParameter("type");
		String viewPath = null;
		SimpleDateFormat frm = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		Calendar cal = Calendar.getInstance();
		String date = frm.format(cal.getTime());
		if(type == null || type.equals("date")) {
			viewPath = "/ex2/date.jsp";
			request.setAttribute("date", date);
		}
		*/
		
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
