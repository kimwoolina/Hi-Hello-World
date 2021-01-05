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
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPw")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비밀번호 찾기용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수에 기록 저장함
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		
		//3. 모델의 서비스 객체 생성하고, 메소드 실행해서 처리 결과받기
		String pw = new MemberService().findPw(id,phone);
		request.setAttribute("pw", pw);

		//4. 받은 결과에 따라 성공/실패 페이지를 선택해서 내보냄
		if(pw != null) {
			RequestDispatcher view = request.getRequestDispatcher("views/member/findPwAfter.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "비밀번호 찾기 실패!");
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
