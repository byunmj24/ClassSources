package ex4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action2 {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//나머지 파라미터들(name, age) 받는다.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		if(name != null & age != null) {
			//받은 값들을 저장할 vo객체를 생성한다.
			DataVO dvo = new DataVO();
			dvo.setName(name);
			dvo.setAge(Integer.parseInt(age));
			
			//준비된 vo를 JSP에서 표현할 수 있도록 request에 저장한다.
			request.setAttribute("dvo", dvo);//여기서 정의한 "dvo"라는 이름은 JSP에서 표현할 변수다.
		}
		
		return "/ex4/data.jsp";
	}
}
