package co.micol.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVO;

public class MemberInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원정보를 DB에 입력한다.
		MemberDao dao = new MemberDao();
		MemberVO vo = new MemberVO();

		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setEnterdate(Date.valueOf(request.getParameter("enterdate")));
		// String으로 바다오기 떄무넹 date valueof를 사용해서 바다오면 ㅗ디낟.
		// 단점.. 시분초 관리가 안된다, 편하긴 한데...

		int n = dao.insert(vo);
		String page;
		if(n != 0) {//0과 같지 않다는건 입력이 성공했다는것
			page = "jsp/member/insertSuccess.jsp";
		} else {
			page = "jsp/member/insertFail.jsp";
		}
		
		return page;
	}

}
