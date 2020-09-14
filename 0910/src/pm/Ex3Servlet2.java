package pm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex3Servlet2
 */
@WebServlet("/Ex3Servlet2")
public class Ex3Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//세션을 얻어낸다.
		HttpSession sess = request.getSession();
		
		//세션에 저장된 값들 얻기
		Object objName = sess.getAttribute("name");
		Object objAge = sess.getAttribute("age");
		
		if(objName != null && objAge != null) {
			//응답하기 위해 스트림 준비
			PrintWriter out = response.getWriter();
			
			out.println("당신의 이름은 : "+objName);
			out.println("<br/>당신의 나이는 : "+objAge);
			
			out.close();
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
