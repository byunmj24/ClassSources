package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
}
