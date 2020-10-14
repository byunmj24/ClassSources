package mybatis.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	
	private static SqlSessionFactory factory;
	
	static{
		try {
			Reader r=Resources.getResourceAsReader("mybatis/config/config.xml");
			factory=new SqlSessionFactoryBuilder().build(r);
			r.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static SqlSessionFactory getFactory() {
		//객체 생성 없이 빠르게 사용하기 위해 static메서드로 선언한다.
		//싱글톤
		return factory;
	}
}