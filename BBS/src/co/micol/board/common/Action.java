package co.micol.board.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
public String exec(HttpServletRequest request, HttpServletResponse response);
}
//컨트롤러를 만들어 줄거에여ㅛ.
//new class를 만들어주는데