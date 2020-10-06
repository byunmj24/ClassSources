package ex3;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateAction {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//현재 날짜 구하기
		Date now = new Date(System.currentTimeMillis());
		
		//request에 현재 날짜 저장
		request.setAttribute("now", now.toString());
		
		//표현할 JSP의 경로를 반환한다.
		return "/ex3/date.jsp";
	}
}
