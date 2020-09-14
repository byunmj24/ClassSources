package pm;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex3Servlet1
 */
@WebServlet("/Ex3Servlet1")
public class Ex3Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");//아스키코드 ---> 유니코드
		
		//요청한 곳으로부터 파라미터 받기(u_name, u_year)
		String u_name = request.getParameter("u_name");
		String u_year = request.getParameter("u_year");
		
		if(u_name != null && u_year != null) {
			//u_name이라는 파라미터를 받았을 때만 수행하는 곳!
			
			int b_year = Integer.parseInt(u_year);//정수화
			
			//현재 날짜에서 년도 얻어낸다.
			Calendar now = Calendar.getInstance();
			int yy = now.get(Calendar.YEAR);//현재년도
			
			int age = yy - b_year + 1;//나이 구한다.
			
			//세션에 저장하기 위해 세션정보를 서버로부터 얻어낸다.
			HttpSession session = request.getSession();
			
			session.setAttribute("name", u_name);
			session.setAttribute("age", age);
		}
		
		//이동!
		response.sendRedirect("Ex3Servlet2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
