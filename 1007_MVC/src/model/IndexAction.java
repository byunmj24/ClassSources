package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import mybatis.dao.MemoDAO;
import mybatis.vo.MemoVO;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//로그인을 했는지? 안했는지? 알아보자!
		//로그인을 했다면 session에 "vo"라는 이름으로 저장이 되어있다.
		
		HttpSession session = request.getSession();//먼저 HttpSession을 얻어낸다.
		Object obj = session.getAttribute("vo");//"vo"라는 이름으로 저장된 객체를 얻어낸다.
		
		boolean chk = false;
		if(obj != null) {//로그인 되면
			chk = true;
			request.setAttribute("login_chk", chk);
		}
		
		/* 위아래 둘 다 사용가능! 퍼포먼스적 차이가 전혀 없다.
		if(obj == null) {//로그인 안됨
			request.setAttribute("login_chk", false);
		}else {//로그인 됨
			request.setAttribute("login_chk", true);
		}
		*/
		
		//공지사항 3개 가져오기
		String begin ="1";
		String end ="3";
		//begin, end 변수만 바꿔주면 보여주는 list를 바꿀 수 있다.
		List<MemoVO> list = MemoDAO.list(begin, end);
		
		//위에서 받은 List를 가지고 배열화 시킨다.
		MemoVO[] ar = null;
		if(list != null && list.size() > 0) {
			ar = new MemoVO[list.size()];
			list.toArray(ar);
		}
		
		//JSP에서 표현하기 위해 request에 "ar"이라는 이름으로 저장한다.
		request.setAttribute("ar", ar);
		
		
		return "/jsp/index.jsp";//호출하는 곳(Controller)으로 반환!
	}

}
