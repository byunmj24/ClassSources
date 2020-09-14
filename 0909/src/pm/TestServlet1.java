package pm;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/ex1")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()");
		
		//우리가 재정의하기 전에는 요청한 곳으로부터
		//무슨 요청방식으로 호출되었는지를 자동으로 파악해서 doGet 또는 doPost가 호출되었다.
		//하지만 우리가 재정의 함으로써
		//직접 요청방식을 알아내어 doGet 또는 doPost를 호출해야 한다.
		
		//요청(Request)한 곳으로부터 전송방식을 알아낸다.
		//현재 메서드를 호출하는 곳이 바로 클라이언트다. /ex1라고 요청하면 현재 서블릿을
		//톰캣이 찾아내어 service메서드를 호출하도록 되어있다.
		if(req.getMethod().equalsIgnoreCase("POST"))
							   //IgnoreCase - 대소문사 구분 없이 비교
			doPost(req,resp);
		else
			doGet(req,resp);
	}



	@Override
	public void destroy() {
		System.out.println("destroy()");
	}



	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	}

}
