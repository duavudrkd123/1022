package co.micol.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.command.LoginAction;
import co.micol.board.command.LoginForm;
import co.micol.board.command.LogoutAction;
import co.micol.board.command.MainAction;
import co.micol.board.command.MemberForm;
import co.micol.board.command.MemberInsertAction;
import co.micol.board.command.MemberListAction;
import co.micol.board.common.Action;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> map = new HashMap<String, Action>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
//요청들을 정의하고
		map.put("/main.do", new MainAction()); // 처음 들어오는 페이지 처리 index.jsp
		map.put("/login.do", new LoginAction()); // 로그인 member를 처리하는것
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼 호출
		map.put("/memberlist.do", new MemberListAction()); //회원 전체리스트 보기
		map.put("/memberForm.do", new MemberForm()); //회원 가입 화면 호출
		map.put("/memberInsert.do", new MemberInsertAction()); //회원 입력 화면 호출
		map.put("/logout.do", new LogoutAction()); //로그아웃 시켜줌
//		map.put("/loginForm.do", new LoginForm());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//수행할 명령을 정리 할것이다..
		request.setCharacterEncoding("utf-8"); // 한글 처리를 위해, 깨짐 방지를 위해...
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length()); // 실제 들어오는 페이지를 찾음 uri를 잘라줘,
		// 얼만큼 contextpath의 길이만큼 그렇게 자르면 path까지 구해진다.

		Action command = map.get(path);
		String viewPage = command.exec(request, response); // 실제로 명령어가 수행되는 부분. 수행되고 나서 보여줄 페이지를 선택한다
		// request dispatcher사용한다

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 그리고 forward를 시켜준다. 선택한 페이지로 가는 것
		dispatcher.forward(request, response);

		// 이렇게 하면 front controller는 다 만들어진다.
	}

}
//서블릿으로 만들어 주어야 된다.
//컨트롤러를 만들어 주겠습니다.

//클래스로 만들어도 되는데
//내가 다시 쳐줘아되서 기찮's'
//컨트롤러만들떄는 이닛이랑 서비스로 만들어준다.
//두겟을 쓰면 컨트롤러가 굉장히 기러지기 떄문에
//아이나잇(init)랑 서비스로 만들어 줄것ㅇ다.
