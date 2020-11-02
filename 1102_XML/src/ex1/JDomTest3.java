package ex1;

import java.io.IOException;
import java.time.format.FormatStyle;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest3 {
	public static void main(String[] args) throws IOException {
		//실제 존재하는 XML문서를 로드하는 것이 아니라
		//존재하지 않는 XML문서를 만들어서 그곳에 원하는 형태의
		//요소들을 추가하는 예제
		
		//먼저 XML문서를 의미하는 객체(Document)를 생성한다.
		Document doc = new Document();
		
		//요소들을 만드는 순서는 상관이 없다. 하지만 배치를 할 때에는 순서대로 잘 해주어야한다.
		//하위 요소들 생성
		/*
		 * <book>
		 *     <title>책이름</title>
		 *     <price>20000</price>
		 * </book>
		 * 
		 * */
		Element book = new Element("book");
		Element title = new Element("title");
		Element price = new Element("price");
		
		title.setText("자바 바이블");
		price.addContent("29000");//price.setText("29000"); 어느걸 써도 상관없다.
		
		//배치 단계
		book.addContent(title);
		book.addContent(price);
		
		//위의 book을 가지는 root요소를 만들자
		Element root = new Element("total");
		root.addContent(book);
		
		//현재 Document에 root 설정!!!
		doc.setRootElement(root);
		
		//출력할 준비, XMLOutpuuter를 만들자		
		XMLOutputter xo = new XMLOutputter();
		//그리고 Format을 얻어낸다.
		Format f = xo.getFormat();
		
		f.setEncoding("utf-8");
		f.setIndent("  ");
		f.setLineSeparator("\r\n");
		f.setTextMode(Format.TextMode.TRIM);
		
		xo.setFormat(f);
		
		xo.output(doc, System.out);
		
	}
}
