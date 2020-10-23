package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;

public class LoginForm implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		return "jsp/main/loginForm.jsp";
	}

}
//단순하게 form만 호출 하면 되니까 return "jsp/main/loginForm.jsp; 해주면 된다