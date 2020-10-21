package com.test.db;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.dao.MemDAO;
import mybatis.vo.MemVO;

@Controller
public class IndexController {
	
	@Autowired
	private MemDAO m_dao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/total", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> total(){
		Map<String, Object> map = new Hashtable<String, Object>();
		
		MemVO[] ar = m_dao.getAll();
		map.put("list", ar);
		
		return map;//여기 total은 index.jsp의 $.ajax 비동기식 통신으로 호출되어졌고,
					//반환을 JSON으로 해야 하지만 Map으로 하고 있다. 다시 말해서
					//Map을 JSON으로 변환해야 한다. 이것을 라이브러리가 하도록 한다.
	}
}
