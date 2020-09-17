package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.MemoVO;

public class MemoDAO {
	public static List<MemoVO> getList(){
		SqlSession ss = FactoryService.getFactory().openSession();
		
		List<MemoVO> list = ss.selectList("memo.total");
		ss.close();
		
		return list;
	}
	
	public static void add(MemoVO vo) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.insert("memo.add", vo);
		if(cnt>0) {
			ss.commit();
		}else{
			ss.rollback();
		}
		ss.close();
		return;
	}
}
