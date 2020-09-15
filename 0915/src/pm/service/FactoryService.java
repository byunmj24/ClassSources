package pm.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	
	//현재 객체가 아무리 많이 만들어져도 factory는 오로지 하나만 생성되어야 한다.
	private static SqlSessionFactory factory;
	static {//static 블럭 초기화 영역(static으로 선언된 멤버변수들에 대한 초기화 작업) - 생성자보다 더 빠르게 실행
		try {
			Reader r = Resources.getResourceAsReader("pm/config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}//factory 완성
}
