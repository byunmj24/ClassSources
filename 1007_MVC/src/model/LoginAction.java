package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//아무것도 할 게 없지만 굳이 뭔가 하고싶다면....
		String path = "/jsp/login.jsp";
		
		//사용자의 요청방법에 따라 구분하자! post방식일 때를 알아내 보자!
		if(request.getMethod().equalsIgnoreCase("post")) {
			//id와 pw를 받아서 MyBatis환경을 이용하여 인증을 확인한다.
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			//정확한 정보일 때(vo가 null이 아닐 때)만 HttpSession에 vo객체를 "vo"라는 이름으로 저장한다.
			MemberVO mvo = MemberDAO.login(id,pw);
			if(mvo != null) {
				HttpSession session = request.getSession();
				session.setAttribute("vo", mvo);
				
				//request에 "login_chk"라는 이름으로 true를 저장한다.
				request.setAttribute("login_chk", true);
			}
			
			path = "/jsp/index.jsp";
		}
		
		return path;
	}

}
