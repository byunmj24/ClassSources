package mybatis.dao;

import java.util.Hashtable;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import mybatis.service.FactoryService;
import mybatis.vo.EditorVO;

public class EditorDAO {
	//추가
	/*
	public static boolean add(String title, String content) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("title", title);
		map.put("content", content);
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.insert("editor.add", map);
		boolean value = false;
		if(cnt > 0) {
			ss.commit();
			value = true;
		}else {
			ss.rollback();
		}
		ss.close();
		return value;
	}*/
	public static boolean add(EditorVO vo) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.insert("editor.add", vo);
		boolean value = false;
		if(cnt > 0) {
			value = true;
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return value;
	}
}
