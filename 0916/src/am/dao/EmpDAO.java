package am.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import am.factory.FactoryService;
import am.vo.EmpVO;
public class EmpDAO {
	//원하는 Mapper를 호출하여 각 메서드들을 정의
	//public static EmpVO searchNo(int no){ //int type으로 받는 경우
	//	String n = String.valueOf(no); //mapper의 parameterType과 맞춰야한다.
	public static EmpVO getSearchEmpno(String empno){
		SqlSession ss = FactoryService.getFactory().openSession();
		EmpVO vo = ss.selectOne("Emp.searchEmpno",empno);
		ss.close();
		return vo;
	}
	
	//동적쿼리를 활용하는 메서드
	public static List<EmpVO> search(String type, String value){
		//MyBatis환경으로 인자를 2개 이상을 보낼 때는 한번에 보내야 한다.
		//이때 보편적으로 많이 사용되는 것이 바로 Map구조다.
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", type);// "searchType" ----> "0/1/2"
		map.put("searchValue", value);// "searchValue" ----> "input입력값"
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List<EmpVO> list = ss.selectList("Emp.search", map);
		ss.close();
		return list;
	}
	
	//public static List<EmpVO> update(String )
}
