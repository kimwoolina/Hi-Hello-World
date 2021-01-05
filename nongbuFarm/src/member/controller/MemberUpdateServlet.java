package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원 정보 수정 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("UTF-8"); //전송보낸 뷰페이지의 문자 set에 맞춰야함
		
		//2. 전송온 값 꺼내서 변수 또는 vo 객체에 기록 저장
		Member member = new Member(); // 값 전송 위한 객체 생성
		member.setUserId(request.getParameter("userid"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setPhone(request.getParameter("phone"));
		member.setAddr(request.getParameter("addr"));
		member.setEmail(request.getParameter("email"));
		
		System.out.println("member : " + member);
		
		//3. 모델 서비스 객체 생성하고, 메소드 실행시키고 결과 받기
		int result = new MemberService().updateMember(member);
		
		//4. 받은 결과에 따라 성공/실패 페이지를 선택해서 내보냄
		if(result > 0) { //수정 성공시 '내정보보기' 페이지를 내보냄 
			//수정항목 추출에서 제외된 전송값 추출해서 member에 기록 저장함
			member.setUserName(request.getParameter("username"));//출력을 위해 더 필요한 것 꺼냄
		
			//방법1. 세션에 다시 저장하는 방법 //방법2. select해온 정보로 내정보 보기를 처리하는 방법
			//세션 객체의 저장된 회원 정보를 수정된 새 정보로 바꿈(방법1) , 단 세션을 이용하는 방법은 로그인 말고는 왠만하면 쓰지 말기.
			HttpSession session = request.getSession(false);//세션 객체 생성 //false:새로 만들진 말고 기존의 것 찾아서 가져와라
			session.setAttribute("loginMember", member);//있는 이름에 또 저장하면 덮어쓰기가 됨
			
			response.sendRedirect("/nongbu/views/member/memberDetailView.jsp"); //상대경로 or 절대경로 아무거나 써도 됨
		}else {
			//수정 실패시 에러 페이지와 메세지를 내보냄
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", member.getUserId() + "회원의 정보 수정");
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
