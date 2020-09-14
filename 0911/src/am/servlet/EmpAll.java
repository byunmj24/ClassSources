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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mybatis환경을 사용하기 위해 config.xml을 활용하여 factory생성
		try {
			//공장을 세우기 위한 자원들이 있는 config.xml과 연결된 통로를 만든다.
			//Reader : java.io패키지
			Reader r = Resources.getResourceAsReader("am/config/config.xml");
			
			//공장을 세우는 일꾼 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			//일꾼을 통해 공장 생성
			//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			SqlSessionFactory factory = builder.build(r);
			
			//이미 사용해서 공장을 만들었으니 통로(r)은 더이상 필요가 없다.
			r.close();
			
			//세워진 공장으로부터 우리가 진짜로 필요했던 SqlSession을 얻어낸다.
			SqlSession ss = factory.openSession();//SqlSession이 우리가 필요한 mapper(Sql문)들을 가지고 있다.
			
			//SQL문 사용
			//ss.selectOne() ---> 결과가 없거나 하나일 때
			//ss.selectList() ---> 결과가 없거나 두개 이상일 때
			List<EmpVO> list = ss.selectList("emp.all");
			
			//받은 결과(List)를 처리하기 전에 null값이 아닐 때만 수행!
			if(list != null && list.size() > 0) {
				//System.out.println(list.size());
				
				//요청한 곳으로 모든 사원들의 정보를 표(table)로 표현하려고 한다.
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				//응답 시작
				out.println("<table border='1'>");
					out.println("<tbody>");
						for(int i=0;i<list.size();i++) {
							//List에서 i번째 하나의 요소를 얻어낸다.
							EmpVO vo = list.get(i);
							out.println("<tr>");
								out.println("<td>"+vo.getEmpno()+"</td>");
								out.println("<td>"+vo.getEname()+"</td>");
								out.println("<td>"+vo.getSal()+"</td>");
								out.println("<td>"+vo.getDeptno()+"</td>");
							out.println("</tr>");
						}//for의 끝
					out.println("</tbody>");
				out.println("</table>");
				
				out.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
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
