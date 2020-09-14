package pm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("/TestServlet3")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청한 곳으로부터 인자(u_name, u_phone)들을 받는다. (한글은 깨진다.)
		//인자(parameter)는 무조건 String으로 받는다.
		//요청받는 내용 한글처리
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("u_name");//***************
		String phone = request.getParameter("u_phone");//***************
		String locate = request.getParameter("u_locate");//***************
		
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//받은 값을 가공하여 다시 요청한 곳으로 응답한다.
		PrintWriter out = response.getWriter();
		
		//응답 시작
		out.println(name + "(" + phone + ")님 환영합니다.</br>");
		out.println("사는 곳은 " + locate + "이시군요!");
		out.close();
	}

}
