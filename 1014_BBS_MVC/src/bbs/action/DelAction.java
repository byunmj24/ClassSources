package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;

public class DelAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//기본키를 받아서 삭제를 수행한다. --- 호출하는 곳은 view.jsp
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");
		BbsDAO.delBbs(b_idx);
		
		return "Controller?type=list&cPage"+cPage;
	}
}
