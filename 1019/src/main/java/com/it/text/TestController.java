package com.it.text;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	private String msg;
	
	@RequestMapping("/t1")
	public String ex(HttpServletRequest request) {
		
		Date now = new Date(System.currentTimeMillis());
		String now_date = now.toString();
		msg = now_date;
		request.setAttribute("now", now_date);
		
		return "test";//views라는 폴더
		//String 반환형은 보통 경로만 반환할 때 쓴다.
	}
	
	@RequestMapping("/t2")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		
		//ModelAndView에 값을 저장!
		mv.addObject("value", "안녕하세요");
		mv.addObject("msg", msg);
		
		//보여질 JSP의 경로를 지정한다.
		mv.setViewName("test2");//views라는 폴더에 있는 test2.jsp
		
		return mv;
		//ModelAndView를 쓰는 경우는 어떤 값들을 담아서 뿌려야하는 경우에 주로 사용
	}
}
