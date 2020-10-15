package bbs.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mybatis.dao.BbsDAO;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String viewPath = "/bbs/write.jsp";
		
		//현재 영역은 get방식으로 요청되었을 때는 write.jsp로 페이지 이동!
		//그게 아니라 post방식이면서 파일첨부가 되어 온다면 파라미터들을 받아서 DB에 저장!
		
		//String method = request.getMethod();
		//if(!method.equalsIgnoreCase("GET")) {
		String c_type = request.getContentType();//encType이 들어온다.
		//System.out.println(c_type);
		if(c_type != null && c_type.startsWith("multipart")) {
			//파라미터 받아서 DB에 저장!!!
			try {
				//첨부파일을 저장할 폴더를 절대경로화 시킨다.
				//ServletContex를 사용하여 application을 얻는다!
				ServletContext application = request.getServletContext();
				
				String path = application.getRealPath("/bbs_upload");
				
				MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*5, "utf-8", 
															new DefaultFileRenamePolicy());
				//첨부된 파일이 bbs_upload라는 폴더로 업로르 된다.
				
				//bbs테이블에 저장할 업로드된 파일명을 얻어야한다.
				File f = mr.getFile("file");
				String fname = null;
				if(f != null) {
					//파일이 첨부된 경우
					fname = f.getName();
				}
				
				//나머지 파라미터 값들 받기
				String subject = mr.getParameter("title");
				String writer = mr.getParameter("writer");
				String content = mr.getParameter("content");
				String ip = request.getRemoteAddr();
				String bname = mr.getParameter("bname");
				
				BbsDAO.add(subject, writer, content, fname, ip, bname);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			viewPath = null;
		}

		
		
		return viewPath;
	}

}
