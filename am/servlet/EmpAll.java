package am.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.EmpVO;

/**
 * Servlet implementation class EmpAll
 */
@WebServlet("/EmpAll")
public class EmpAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SqlSessionFactory factory;//멤버변수 선언
	
    public EmpAll() {
    	//객체가 생성될 때 한번만 수행하는 생성자 영역!
    	try {
			Reader r = Resources.getResourceAsReader("am/config/config.xml");
			SqlSessionFactoryBuilder bulder = new SqlSessionFactoryBuilder();
			factory = bulder.build(r);
			r.close();
		} catch (Exception e) {
			e.printStackTrace();//혹시 오류가 발생하면 순차적으로 출력!
		}
    }
    	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청이 발생할 때마다 수행하는 곳!
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//Factory로부터 SqlSession얻기
		SqlSession ss = factory.openSession();
		
		//SqlSession을 통해 원하는 SQL문장을 호출한다.
		List<EmpVO> list = ss.selectList("EmpMapper1.total");//total이라는 SQL문은 "select * from emp"다.
															//여기서 발생하는 결과는 오로지 하나가 아니라 여러개의 행이 발생한다.
															//그래서 각 행마다 하나의 EmpVO가 생성되어 여러개의 EmpVO가
															//ArrayList에 담겨서 넘어온다.
		
		//응답을 위한 스트림 준비
		PrintWriter out = response.getWriter();
		
		//HTML로 응답하기
		out.println("<table border='1'>");
			out.println("<tbody>");
				for(int i=0;i<list.size();i++) {
					EmpVO vo = list.get(i);//사원정보 하나씩 얻어낸다.
					out.println("<tr>");
						out.println("<td>"+vo.getEmpno()+"</td>");
						out.println("<td>"+vo.getEname()+"</td>");
						out.println("<td>"+vo.getJob()+"</td>");
					out.println("</tr>");
				}
			out.println("</tbody>");
		out.println("</table>");
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
