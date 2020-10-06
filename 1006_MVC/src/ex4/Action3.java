package ex4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action3 {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DataVO dvo1 = new DataVO();
		dvo1.setName("일지매");
		dvo1.setAge(31);
		
		DataVO dvo2 = new DataVO();
		dvo2.setName("이지매");
		dvo2.setAge(29);
		
		DataVO dvo3 = new DataVO();
		dvo3.setName("삼지매");
		dvo3.setAge(12);
		
		//위의 3개의 자원들을 하나로 묶어서 처리를 하자!
		DataVO[] ar = new DataVO[3];
		//위는 DataVO객체 3개를 저장할 수 있는 공간이 마련된 것이다.
		//이제 비어있는 공간에 채워야 한다.
		ar[0] = dvo1;
		ar[1] = dvo2;
		ar[2] = dvo3;
		//DataVO[] ar = {dvo1, dvo2, dvo3};
		
		request.setAttribute("ar", ar);
		
		return "/ex4/ar.jsp";
	}
}
