package pm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex1SessionServlet
 */
@WebServlet("/Ex1SessionServlet")
public class Ex1SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession처리!
		
		//먼저 HttpSession객체를 요청객체로부터 얻어낸다.
		HttpSession session = request.getSession();
		
		//HttpSession톰켓이 관리하고 있다. 디폴트가 접속자가 생길때마다 하나씩 배당한다.
		//session에 값을 저장한다.
		session.setAttribute("m_type", 100);
		session.setAttribute("v1", "TEST");
		
		//session은 지역변수다. 언제 사라질까?
		//현재 메서드가 끝나면 session이라는 지역변수는 삭제된다.
		
		//이쯤에서 다른 서블릿으로 이동하자!(응답을 다른 곳으로 지정한다.)
		response.sendRedirect("Ex1SessionServlet2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
