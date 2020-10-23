package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.board.common.Action;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 인증과정을 처리한다.
		MemberDao dao = new MemberDao(); // db랑 연결하기 위해 필요함
		MemberVO vo = new MemberVO(); // 그냥 변수에다 전송해도 되는데 귀찮으니까 변수로 만들어 준다.
		
		// String msg;
		HttpSession session = request.getSession(false);
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		vo = dao.select(vo);
		// vo를 통해 입력된 id password값을 select함수로 보내면서 select 함수(클래스를) 실행시켜준다.
		// MEMBERDAO 를 실행시킨다

		// if(vo.getName() == null) {// 존재하지 않을때 메시지를 실어보냄
		// msg = "존재하지 않는 회원 입니다";
		// request.setAttribute("msg", msg);
		/*
		 * 위에 string msg를 안쓰고 하는법 if(vo.getName() == null) {// 존재하지 않을때 메시지를 실어보냄
		 * //request.setAttribute("변수명", "값"); request.setAttribute("msg",
		 * "존재하지 않는 회원입니다");
		 */
		// }
		session.setAttribute("id", vo.getId()); //이게 session에 아이디를 담는 것이다
		session.setAttribute("author", vo.getAuthor()); // session에 권한을 담는것이다.
		session.setAttribute("name", vo.getName());
		request.setAttribute("vo", vo); // 멤버를 실어 보냄
		return "jsp/main/loginResult.jsp";
	}

}
