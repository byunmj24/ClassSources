package am;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateServlet
 */
@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 날짜 구하기
		//1. Calendar 활용 - static으로 이루어져있다. 
		//pc에 저장된 달력을 얻어내어 사용 - 날짜 계산하기 편하다
		Calendar now = Calendar.getInstance();
		
		//Calendar는 년, 월, 일, 시, 분, 초, 세기
		int yy = now.get(Calendar.YEAR); //년도
		int mm = now.get(Calendar.MONTH)+1; //월은 1월이 0으로 나온다.
		int dd = now.get(Calendar.DAY_OF_MONTH); //일
		
		//하나의 문자열을 조합하기 위해 StringBuffer가 필요하다.
		//자바의 String은 불변적 특징으로 인해 절대 변할 수 없다.
		StringBuffer sb = new StringBuffer();
		//String year = String.valueOf(yy);
		//sb.append(year); //int를 String으로 변경한 후 sb에 추가한다.
		sb.append(String.valueOf(yy));
		sb.append("-"); // "2020-"
		sb.append(String.valueOf(mm));
		sb.append("-");
		sb.append(String.valueOf(dd));
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Calendar:" + sb.toString() + "</h1>");
		
		//2. Date 활용 - 현재 시스템이 기억하고 있는 현재 시간의 값(밀리세컨드)을 가져와서 날짜객체를 생성한다.
		Date date = new Date(System.currentTimeMillis()); //java.sql
		out.println("<h1>Date:" + date.toString() + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
