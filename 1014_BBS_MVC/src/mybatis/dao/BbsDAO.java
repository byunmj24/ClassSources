package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.BbsVO;

public class BbsDAO {
	
	//페이징을 위한 목록 기능
	public static BbsVO[] getList(int begin, int end, String bname) {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("bname", bname);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		List<BbsVO> list = ss.selectList("bbs.list", map);
		//받은 list를 배열로 전환!
		BbsVO[] ar = null;
		if(list != null && list.size() > 0) {
			ar = new BbsVO[list.size()];
			
			//list에 있는 요소들을 ar에 복사해 넣는다.
			list.toArray(ar);
		}
		ss.close();
		
		return ar;
	}
	
	//전체 게시물의 수를 반환하는 기능
	public static int totalCount(String bname) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("bbs.totalCount", bname);
		ss.close();
		
		return cnt;
	}
	
	//원글 저장
	public static void add(String subject, String writer, String content,  String file_name, String ip, String bname) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("subject", subject);
		map.put("writer", writer);
		map.put("content", content);
		map.put("file_name", file_name);
		map.put("ip", ip);
		map.put("bname", bname);
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.insert("bbs.add", map);
		if(cnt >0)
			ss.commit();
		else
			ss.rollback();
		
		ss.close();
		return;
	}
	
	//보기 기능
	public static BbsVO getBbs(String b_idx) {
		SqlSession ss = FactoryService.getFactory().openSession();
		BbsVO vo = ss.selectOne("bbs.getBbs", b_idx);
		ss.close();
		
		return vo;
	}

	//수정 기능
	public static boolean editBbs(String b_idx, String subject, String content, String fname, String ip) {
		boolean value = false;
		
		Map<String, String> map = new Hashtable<String, String>();
		map.put("b_idx", b_idx);
		map.put("subject", subject);
		map.put("content", content);
		//파일첨부가 되었을 때만 파일명을 DB에 저장! 만약? 첨부된 파일이 없다면 기존 파일을 유지하자!
		if(fname != null && fname.trim().length() > 0) 
			map.put("fname", fname);
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.update("bbs.edit", map);
		if(cnt > 0) {
			ss.commit();
			value = true;
		}else {
			ss.rollback();
		}
		ss.close();
		
		return value;
	}
	
	//삭제 기능
	public static void delBbs(String b_idx) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.update("bbs.del", b_idx);
		if(cnt > 0) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
	}
}
