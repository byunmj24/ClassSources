package pm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex1SessionServlet2
 */
@WebServlet("/Ex1SessionServlet2")
public class Ex1SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1SessionServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다시 HttpSession을 얻어내자!
		HttpSession session = request.getSession();//session이 새롭게 생성된 것이 아니라
													//톰캣환경의 서버에서 가져왔다.
		//저장한 값들을 빼낸다.
		Object obj = session.getAttribute("m_type");
		
		//"v1"이라는 키로 저장된 값이 우린 String이라는 것을 알고 있다고 가정한다면...
		String v1 = (String) session.getAttribute("v1");
		//v1이라는 이름으로 저장된 객체 값을 가져올 때는 Object로 가져온다. 그리고 바로 String으로 강제형변환(Casting)한다.
		
		System.out.println(obj);//100
		System.out.println(v1);
		//출력하는 것으로만 만족하지 않고 문자열의 1번지부터 2글자를 추출하고 싶다면....
		//substring(1,3)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
