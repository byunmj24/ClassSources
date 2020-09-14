package pm.servlet;

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

@WebServlet("/SearchName")
public class SearchName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//하나만 생성하기 위해 멤버변수로 선언한다.
	SqlSessionFactory factory;
	
    public SearchName() {
    	//한번만 수행하여 factory를 얻는다.
    	try {
    		Reader r = Resources.getResourceAsReader("am/config/config.xml");
    		//SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    		//factory = builder.build(r);
    		//위 두 줄을 하나로 합침
    		factory = new SqlSessionFactoryBuilder().build(r);
    		r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//요청시 파라미터 받기(name)
		String name = request.getParameter("u_name").toUpperCase();
		
		//위에서 받은 인자(파라미터)를 MyBatis의 Mapper를 호출하면서 인자로 전달한다.
		//우선 mapper를 호출하기 위해 SqlSession이 필요하다.
		SqlSession ss = factory.openSession();
		
		List<EmpVO> list = ss.selectList("EmpMapper1.searchName", name);
		
		//응답 준비
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
