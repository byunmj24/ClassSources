package ex1;

import java.io.FileWriter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest2 {
	public static void main(String[] args) throws Exception {
		//실제 존재하는 XML문서를 로드한다.
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build("src/ex1/test1.xml");
		
		//얻어진 doc에 추가할 요소를 생성한다.
		/*
		 * <book>
		 *     <title>자바바이블</title>
		 *     <price>29000</price>
		 * </book>
		 * 
		 * */
		Element book = new Element("book");//book Element 하나 생성
		Element title = new Element("title");
		Element price = new Element("price");
		title.setText("자바바이블");//<title>자바바이블</title>
		price.setText("29000");//<price>29000</price>
		//dtd에서 PCDATA에 들어간 것은 문자열이라고 보면 된다.
		
		//book안에 title과 price를 순차적으로 넣어주어야한다.
		//각 Element에 배치를 시킨다.
		book.addContent(title);//book안에 title을 추가한다.
		book.addContent(price);//book안에 price를 추가한다.
		
		//root 요소에 생성한 book을 추가해야 한다.
		Element root = doc.getRootElement();//root 요소를 doc로부터 얻어낸다.
		root.addContent(book);//root안에 book을 추가한다.
		
		//doc는 XML파일을 쓸 수 있게 메모리에 올려둔 것!! 그렇기때문에
		//이렇게 root에 추가해도 메모리 상에만 추가된 것이지 실제 XML문서(test1.xml)는 변화가 없다.
		
		//얻어진 Document객체는 메모리 상에 존재하는 것이며,
		//실제 물리적으로 존재하는 파일의 내용과는 다를 수 있다.
		//XML문서 형식으로 출력해보자!
		XMLOutputter xo = new XMLOutputter();
		Format f = xo.getFormat();//위에서 생성된 XMLOutputter에 있는 
								//기본 출력형식(Format)을 우선 가지고 온다.
		
		f.setEncoding("utf-8");
		f.setIndent("  ");//들여쓰기
		f.setLineSeparator("\r\n");//줄바꿈
		f.setTextMode(Format.TextMode.TRIM);//엔터로 인하여 자동 줄바꿈 기능을 해제!!
		
		//이렇게 생성된 Format을 XMLOutputter에게 출력 형식으로 설정한다.
		xo.setFormat(f);
		
		//xo.output(doc, System.out);//콘솔에 출력
		//파일로 만들고싶다면 System.out 자리에 FileWriter 혹은 FileOutputStream을 넣어주면 된다.
		//xo.output(doc, new FileWriter("src/books.xml"));
		xo.output(doc, new FileWriter("src/ex1/test1.xml"));
		
	}
}
