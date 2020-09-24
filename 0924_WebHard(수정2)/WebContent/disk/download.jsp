<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //dir을 절대경로로 만들어서 file객체
    
    //요청시 한글처리
    request.setCharacterEncoding("utf-8");
	
	//전달되어 오는 파라미터들 받기(cPath, f_name)
	String cPath = request.getParameter("cPath");
	String fname = request.getParameter("f_name");
	
	//위의 값들을 연결하여 절대경로화 시킨다.
	String path = application.getRealPath("/members/"+cPath+"/"+fname);
	
	//위의 절대경로를 가지고 File객체를 생성한다.
	File f = new File(path);
	
	//실제 존재여부 확인
	if(f.exists()){
		//2Kb(2048)개를 저장할 수 있는 바구니를 만들자.
		byte[] buf = new byte[2048];
		int size = 0;//바구니에 담은 수를 기억하는 변수
		
		//다운로드에 필요한 스트림을 준비하자
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		
		//사용자 PC에 저장하기 위한 스트림
		BufferedOutputStream bos = null;
		ServletOutputStream sos = null;//다운로드를 한다는 것은 JSP입장에서는 응답을 하는 것이다.
		//접속자 PC로 다운로드를 시켜야하기 때문에 response를 통해 스트림을 생성해야 한다.
		//그것이 바로 ServletOutputStream이다.
		//그냥 응용프로그램이었으면 FileOutputStream을 만들면 된다.
		
		try{
			//접속자 화면에 다운로드 창을 보여준다.
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename="+
				new String(fname.getBytes(),"8859_1"));
			//인코딩....디코딩....ISO 8859_1....(?)
			//filename에 그냥 fname을 넣어도 되지만 데이터 유실을 방지(한글 깨지지않게 하기 위함)하기 위하여 형태를 갖춰 보내준다.
			
			//---------------------------------------------------------------------
			
			//다운로드 할 File과 연결되는 스트림 생성
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);//BufferedInputStream() : 괄호 안에 무조건 InputStream이 들어가야한다.
			
			//response를 통해 이미 out이라는 생성된 스트림이 존재하기 때문에 오류가 발생한다.
			//그것을 잠깐 지워줘야 한다. 충돌이 나서 오류는 나지만 다운로드가 되기는한다...(?)
			out.clear();
			out = pageContext.pushBody();//원래 출력하는 out을 잠시 치워준다.(?)
			
			sos = response.getOutputStream();
			bos = new BufferedOutputStream(sos);
			
			//buf에 실제 data들이 다 들어가있다.
			//byte기반의 Stream은 더이상 받아올 data가 없으면 현재까지 담은 size의 값을 갖고 반복문을 수행하고 
			//size에 내용도 없고, 더이상 받아올 data도 없으면 -1이 size에 대입되고 반복문을 빠져나온다.
			while((size = bis.read(buf)) != -1){
				bos.write(buf, 0, size);//InputStream으로부터 읽은 수만큼만 쓰기를 수행한다.
				bos.flush();//buffer의 내용 강제로 다 내보내!!
			}//반복문의 끝!
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				//Stream이 null이라는 건 만들어지지도, 사용되지도 않으므로 닫을필요가 없다. 닫으라고 하면 오류가 남! 
				if(fis != null) fis.close();
				if(bis != null) bis.close();
				if(sos != null) sos.close();
				if(bos != null) bos.close();
			}catch(Exception e){}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>