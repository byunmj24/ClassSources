package pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pm.service.FactoryService;
import pm.vo.EmpVO;

public class EmpDAO {
	
	//원하는 mapper를 호출하고 수행하는 메서드들을 정의한다.
	public static List<EmpVO> getTotal(){
		//우선 원하는 mapper를 호출하기 위해서 SqlSession을 factory로부터 얻어낸다.
		SqlSession ss = FactoryService.getFactory().openSession();
		//현재 메서드를 호출하는 곳으로 반환할 값 선언
		List<EmpVO> list = ss.selectList("EmpMapper.total");
		ss.close();
		return list;
	}
	
	public static List<EmpVO> getSearchName(String name){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<EmpVO> list = ss.selectList("EmpMapper.searchName", name);
		ss.close();
		return list;
	}
}
