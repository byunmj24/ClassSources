	package bbs.action;
	
	import java.awt.print.Printable;
	import java.io.File;
	
	import javax.servlet.ServletContext;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import com.oreilly.servlet.MultipartRequest;
	import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
	
	import mybatis.dao.BbsDAO;
	import mybatis.vo.BbsVO;
	
	public class EditAction implements Action {
	
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			//요청한 contentType을 얻어낸다.
			String c_type = request.getContentType();//get방식은 null, post방식은 application...., 
													//파일첨부시 multipart....로 저장된다.
			String viewPath = null;
			//POST방식으로 요청되었을 때와 multipart로 요청되었을 때를 구별하여 뷰페이지를 또는 작업을 다르게 해야한다.
			if(c_type.startsWith("application")) {
				//Post방식으로 요청된 경우
				String b_idx = request.getParameter("b_idx");
				BbsVO vo = BbsDAO.getBbs(b_idx);
				if(vo != null)
					request.setAttribute("vo", vo);//edit.jsp에서 표현하기 위해 저장!!!
				viewPath = "/bbs/edit.jsp";
			} else if(c_type.startsWith("multipart")) {
				//파일 첨부된 폼에서 요청시
				
				//첨부파일이 저장될 위치를 절대경로로 만들자!
				ServletContext application = request.getServletContext();
				
				try {
					String path = application.getRealPath("/bbs_upload");
					MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*5, "utf-8", 
										new DefaultFileRenamePolicy());//첨부파일이 있다면 이때 업로드가 된다.
					
					
					String b_idx = mr.getParameter("b_idx");//이거 없으면 수정하지 못한다.(기본키)
					String cPage = mr.getParameter("cPage");//Controller?type=view로 보낼 때 필요하다. 목록으로 돌아갈때 필요!
					String subject = mr.getParameter("subject");
					String content = mr.getParameter("content");
					String ip = request.getRemoteAddr();
					
					//첨부파일이 있었는지 확인
					File f = mr.getFile("file");
					String fname = null;
					if(f != null) {
						fname = f.getName();//동일한 파일명이 있었다면 파일명이 변경되었을 가능성이 있다.
					}
					
					BbsDAO.editBbs(b_idx, subject, content, fname, ip);
					
					viewPath = "Controller?type=view&cPage="+cPage+"&b_idx="+b_idx;
					//이렇게 보내도 볼 수 있다!! 바뀐 내용으로 보이게 될 것
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return viewPath;
		}
	
	}
