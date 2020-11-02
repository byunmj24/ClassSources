package ex1;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDOM1 {
	public static void main(String[] args) throws Exception {
		//프로그램 시작!
		//www.jdom.org의 JDOM 파서가 필요하다.
		
		//JDOM 또한 Document를 얻는 것이 가장 중요함!
		//XML문서를 인식하고 로드할 때 가장 빠른 방법
		SAXBuilder sb = new SAXBuilder();
		//java는 외부 파일을 가져올때 Stream을 사용한다. IOException 발생
		Document doc = sb.build("src/ex1/test1.xml");
		
		//실제 xml문서를 메모리 상에 올린 객체(Document)에서
		//루트엘리먼트를 구한다.
		Element root = doc.getRootElement();// root
		System.out.println("루트의 이름 : " + root.getName());
		
		//root의 내용 얻어내기
		List<Element> list = root.getChildren("book");
		for(Element e : list) {
			System.out.println(e.getName());// book
			//book의 자식들 중 이름이 title인 요소의 문자열을 가져온다.
			String title = e.getChildText("title");
			String price = e.getChildText("price");
			System.out.println(title + " : " + price);
		}
		System.out.println("----- 두번째 책만 접근 -----");
		Element e = list.get(1);
		System.out.println(e.getChildText("title"));// 두번째 책의 이름
		
	}
}
