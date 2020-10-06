package ex4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action1 {
	
	private int value = 10;
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//인자로 넘어온 request와 response는 컨트롤러가 가지고 있는 request, response와 같은 것이다.
		//그러므로 또다른 파라미터가 있다면 여기서 받을 수 있다.
		String value = request.getParameter("value");
		if(value != null) {
			int v = Integer.parseInt(value);
			request.setAttribute("res", this.value*v);
		}
		
		return "/ex4/res1.jsp";
	}
}
