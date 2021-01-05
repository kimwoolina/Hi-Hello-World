package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/enroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 vo 객체에 기록 저장함
		Member member = new Member();
		member.setUserId(request.getParameter("userid"));
		
		//패스워드 추출함
		String password = request.getParameter("userpwd");
		//패스워드 암호화 처리함
		try { 
			//패스워드 암호화 처리를 위한 객체 생성 : 암호화 알고리즘 지정함
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			//암호화 처리를 위해 패스워드 문자열을 byte[]로 바꿈
			byte[] pwdValues = password.getBytes(Charset.forName("UTF-8"));
			//byte[]을 이용해 암호화 처리함
			md.update(pwdValues);
			//암호화된 byte[]을 다시 String으로 바꿈 //인코딩 처리
			String cryptoPwd = Base64.getEncoder().encodeToString(pwdValues);
			member.setUserPwd(cryptoPwd);
			System.out.println("암호화된 패스워드 : " + cryptoPwd +
					 ", 글자 길이 : " + cryptoPwd.length());
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		
		member.setUserName(request.getParameter("username"));
		member.setPhone(request.getParameter("phone"));
		member.setAddr(request.getParameter("addr"));
		member.setEmail(request.getParameter("email"));
		
		//3. 모델의 서비스 객체 생성하고, 메소드 실행해서 처리 결과받기
		int result = new MemberService().insertMember(member);
		
		//4. 받은 결과에 따라 성공/실패 페이지를 선택해서 내보냄
		if(result > 0) {
			response.sendRedirect("/nongbu/index.jsp");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "회원 가입 실패!");
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
