package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/mdel")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 탈퇴(삭제) 처리용 컨트롤러
		//1.
		//2.
		String userId = request.getParameter("userid");
		
		//3.
		int result = new MemberService().deleteMember(userId);
		
		//4. 
		if(result > 0) {
			//회원정보 삭제 성공시 자동 로그아웃 처리됨 : 로그아웃 서블릿 실행함
			//서블릿에서 서블릿을 실행할 경우
			response.sendRedirect("/first/logout");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp"); 
			request.setAttribute("message", userId + "회원 탈퇴 실패!");
			view.forward(request, response);
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
