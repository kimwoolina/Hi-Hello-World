package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃 처리용 컨트롤러 : 로그인 성공시 만들어진 세션 객체를 없애는 목적
		//html a 태그로 전송온 경우는, 자동 get 방식임.
		HttpSession session = request.getSession(false); //갖고와라. 없으면 null갖고와라
		//sessionScope에서 request에 기록된 sessionID와 일치하는 세션 객체를 반환
		//false : 세션 객체가 없으면 null 리턴함
		if(session != null) { //session객체가 존재할 경우 (null이 아닐 경우)
			//세션 객체를 없앰 : invalidate() 사용함.
			session.invalidate();
			response.sendRedirect("/nongbu/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
