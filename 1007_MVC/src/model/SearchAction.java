package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemoDAO;
import mybatis.vo.MemoVO;

public class SearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 나머지 파라미터(searchType, searchValue)를 받는다.
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		
		List<MemoVO> list =	MemoDAO.search(searchType, searchValue);
		
		//list를 받았다면 배열로 변환하자.
		MemoVO[] ar = null;
		if(list != null && list.size() > 0) {
			ar = new MemoVO[list.size()];
			
			//list에 있는 모든 요소들을 ar에 복사해 넣는다.
			list.toArray(ar);
		}
		
		request.setAttribute("list", ar);
		
		return "/jsp/notice.jsp";
	}

}
