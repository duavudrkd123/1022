package co.micol.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//회원 리스트 보기 구현
		MemberDao dao = new MemberDao();
		// MemberVO vo = new MemberVO();
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		list = dao.selectAll();
		request.setAttribute("members", list);
		
		
		return "jsp/member/memberList.jsp";
	}

}
