package webhard.dao;

import java.util.Hashtable;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import webhard.service.FactoryService;
import webhard.vo.WebhardVO;

public class WebhardDAO {
	
	//회원가입 기능
	public static boolean add(String id, String pw, String name, String addr, String phone, String email) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("m_id", id);
		map.put("m_pw", pw);
		map.put("m_name", name);
		map.put("m_addr", addr);
		map.put("m_phone", phone);
		map.put("m_email", email);
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.insert("webhard.add", map);
		boolean value = false;
		
		if(cnt > 0) {
			ss.commit();
			value = true;
		} else {
			ss.rollback();
		}
		ss.close();
		return value;
	}
	
	//로그인 기능 - login.jsp에서 호출
	public static WebhardVO login(String u_id, String u_pw) {
		//login이라는 mapper를 사용하기 위해서는 Map을 만들어서 그곳에
		//보내고자 하는 파라미터 값(u_id, u_pw)를 저장해야 한다.
		Map<String, String> m = new Hashtable<String, String>();
		m.put("u_id", u_id);
		m.put("u_pw", u_pw);
		
		SqlSession ss = FactoryService.getFactory().openSession();
		WebhardVO vo = ss.selectOne("webhard.login", m);//id와 pw가 정확할 때만 vo를 받는다.
		//잘못된 id나 pw를 입력하면 vo가 생성되지 않고 null이 반환된다.
		
		ss.close();
		return vo;
	}
}
