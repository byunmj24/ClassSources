package am;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2ParamServlet
 */
@WebServlet("/Ex2ParamServlet")
public class Ex2ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		
		//파라미터 받기 - 전달해 오는 파라미터의 이름이 같은 값이 2개 이상이면
		//			  우리는 배열로 처리해야 한다.
		//String phone = request.getParameter("u_phone");
		String[] phone = request.getParameterValues("c_phone");
		String[] hobby = request.getParameterValues("hobby");//체크박스가 선택되지 않은 경우도 확인!!
		for(String n : phone)
			System.out.println(n);//서버의 콘솔창에 출력!(클라이언트가 아님)
		
		if(hobby != null) { //체크박스를 선택했을 때만 수행!!
			System.out.print("취미:");
			for(String n : hobby) { //NullPointerException은 null값을 사용할 때 나오는 예외!
				System.out.print(n);
				System.out.print(",");
			}
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
