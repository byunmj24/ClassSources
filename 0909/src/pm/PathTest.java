package pm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathTest
 */
@WebServlet("/PathTest")
public class PathTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PathTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 프로젝트(Context)의 절대경로(RealPath)를 알아내자!
		
		String path = request.getServletContext().getRealPath("/");//현재 프로젝트의 루트의 경로를 알고자 한다.
		//String paht = request.getRealPath("/");
							//getRealPath("/") : deprecate 됨 - 이용은 가능하나 권장하지않음
		
		//응답객체에게 한글처리를 해야 모든 응답에서 한글이 깨지지 않는다.
		response.setContentType("text/html; charset=utf-8");
		
		//응답(response)을 하기 위해 스트림을 준비한다.
		PrintWriter out = response.getWriter();
		
		
		out.println("프로젝트 경로:"+path); //응답!!!(브라우저에서 확인이 됨)
		
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
