package am;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1LoginServlet
 */
@WebServlet("/Ex1LoginServlet")
public class Ex1LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글처리 - 전달되어 넘어오는 파라미터 값들이 한글이 없다면 안해도 된다.
		//하지만 우린 처음하는 것이므로 연습차원에서 설정하자!
		request.setCharacterEncoding("utf-8");
		
		//응답시 한글처리 
		response.setContentType("text/html; charset=utf-8");
		
		//요청한 곳으로부터 파라미터 값(u_id, u_pw) 받기
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		
		//아이디와 비밀번호를 인자로 보내어 DB로부터 인증절차를 받아낸다.
		
		//로그인 처리를 한다. ----- HttpSession처리
		PrintWriter out = response.getWriter();
		out.println(u_id+"님 환영합니다.");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
