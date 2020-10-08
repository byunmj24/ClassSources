package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.dao.MemoDAO;
import mybatis.vo.MemoVO;

public class NoticeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// index화면에서 공지사항 파트의 [더보기]를 클릭했을 때 오는 곳!
		List<MemoVO> list = MemoDAO.getList();
		
		//배열로 변환하기 위해 배열의 변수를 준비하자!
		MemoVO[] ar = null;
		//list가 비어있지 않을 때 배열을 list의 크기와 동일하게 하여 생성한다.
		if(list != null && list.size() > 0) {
			ar = new MemoVO[list.size()];
			//list에 저장된 요소들을 배열인 ar에 그대로 복사한다.
			list.toArray(ar);
		}
		//JSP에서 표현할 배열을 request에 "list"라는 이름으로 저장하자!
		request.setAttribute("list", ar);
		
		return "/jsp/notice.jsp";//jsp폴더에 있는 notice.jsp의 경로를 반환한다.
	}

}
