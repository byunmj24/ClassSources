package webhard.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import webhard.service.FactoryService;

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
}
