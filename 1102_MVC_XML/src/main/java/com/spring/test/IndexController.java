package com.spring.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.time.format.FormatStyle;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/form")
	public String form() {
		return "form";// views/form.jsp
	}
	
	@RequestMapping("/add")
	public ModelAndView add(String name, String b_day, String phone) throws Exception {
		//이미 존재하는 XML문서를 로드한다.
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build("classpath:data/members.xml");//경로 확인
		Element root = doc.getRootElement();
		//System.out.println(root.getName());
		
		/*<member>
		 *    <name>홍길동</name>
		 *    <b_day>2020-02-22</b_day>
		 *    <phone>010-1234-5678</phone>
		 */
		Element member = new Element("member");
		Element ename = new Element("name");
		Element eb_day = new Element("b_day");
		Element ephone = new Element("phone");
		
		//현재 메서드의 인자들을 name, b_day, phone의 문자열로 지정한다.
		ename.setText(name);
		eb_day.setText(b_day);
		ephone.setText(phone);
		
		//mamber안에 하위요소로 ename, eb_day, ephone을 지정한다.
		member.addContent(ename);
		member.addContent(eb_day);
		member.addContent(ephone);
		
		//root안에 member를 지정
		root.addContent(member);
		
		XMLOutputter out = new XMLOutputter();
		Format f = out.getFormat();
		
		f.setEncoding("utf-8");
		f.setIndent("    ");
		f.setLineSeparator("\r\n");
		f.setTextMode(Format.TextMode.TRIM);
		
		out.setFormat(f);
		
		out.output(doc, new FileWriter(new File("classpath:data/members.xml")));
		
		return null;
	}
}
