package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 처리용 컨트롤러
		// 클라이언트로부터 로그인 요청을 받아서, 전송온 아이디와 암호를 추출함

		// 1. 전송온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("utf-8");		
		
		// 2. 전송온 값 꺼내서 변수 또는 vo 객체에 기록 저장함
		// 전송온 값들은 모두 request에 기록되어 전송옴
		String userId = request.getParameter("userid"); // html태그에서 name값 적어줘야함 //getParameter>String반환함.
		String userPwd = request.getParameter("userpwd");
		System.out.println("확인 : " + userId + ", " + userPwd);
		
		
		/* 자동로그인 */
		Cookie cookie = null;
		String id_rem = request.getParameter("id_rem"); // 체크 되어있으면 on 안되어있으면 null이 넘어옴
		
		if(id_rem != null && id_rem.trim().equals("on")) { //체크가 되어있으면
 			cookie = new Cookie("autoId", java.net.URLEncoder.encode(userId)); //("키",값)
 			//cookie.setDomain("localhost");
 			cookie.setMaxAge(60*60*24*365); //유호시간을 세팅 1년
 			response.addCookie(cookie); //쿠키값을 클라이언트에 저장
		}else { //체크가 안된 상태에서 로그인이 들어왔을 때
			cookie = new Cookie("autoId", null);
			cookie.setMaxAge(0); //유효시간을 0으로
			response.addCookie(cookie); //쿠키값을 클라이언트에 저장
		}
		/* 자동로그인 */

		/*
		 // 패스워드 암호화 처리함
	      try {
	         // 패스워드 암호화 처리를 위한 객체 생성 : 암호화 알고리즘 지정
	         MessageDigest md = MessageDigest.getInstance("SHA-512");
	         // 암호화 처리를 위해 패스워드 문자열을 byte[] 로 바꿈
	         byte[] pwdValuse = userPwd.getBytes(Charset.forName("UTF-8"));
	         // byte[]을 이용해 암호화 처리함
	         md.update(pwdValuse);
	         // 암호화된 byte[]을 다시 String 으로 바꿈
	         userPwd = Base64.getEncoder().encodeToString(pwdValuse);
	         System.out.println("암호화된 패스워드" + userPwd + ", 글자길이 : " + userPwd.length());
	      } catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	      }
	     */
		
		// 3. Model의 service 클래스 객체 생성하고, 로그인 메소드 실행하고 결과받음
		/*
		 * MemberService mservice = new MemberService(); Member loginMember =
		 * mservice.selectLogin(userId, userPwd)
		 */
		// 서비스의 selectLogin으로 전달 > 서비스에서 dao로 다시 보냄 > member객체에 담은뒤 서비스로 다시 리턴 > 서비스에서
		// 컨트롤러로 다시 리턴
		Member loginMember = new MemberService().selectLogin(userId, userPwd);
		System.out.println("loginMember : " + loginMember);

		// 4.리턴된 결과를 가지고 성공/실패에 대한 뷰페이지를 선택해서 응답함(response)
		if (loginMember != null) {
			// 로그인 성공 시, 해당 클라이언트의 세션 객체를 생성함
			// WAS(톰켓)가 관리하는 sessionScope 영역에 로그인 요청한 사용자의
			// 세션 객체가 만들어지도록 함
			HttpSession session = request.getSession(); // getsession() 괄호빈칸이면 있으면 가져오고 없으면 새로 만들라는 뜻
			System.out.println("session ID : " + session.getId());
			// 필요한 경우 세션 객체에 객체정보를 저장할 수도 있음. Map 방식임
			// 세션레퍼런스.setAttribute("이름", 객체); 여러번쓸수 있는 메소드.
			session.setAttribute("loginMember", loginMember);
			// 뷰페이지를 선택해서 내보냄
			response.sendRedirect("/nongbu/index.jsp");
		} else {
			// 로그인 실패 시 에러페이지를 내보내도록 함
			//방법 1. 뷰페이지만 선택해서 내보냄, 페이지에 출력할 값을 함께 보낼 수 없음
			//response.sendRedirect("/first/views/common/error.jsp");
			
			//방법 2. 내보낼 뷰페이지를 지정하고, 뷰페이지에 출력할 값도 함께 보내려면
			//getRequestDispatcher("상대경로로 내보낼 뷰파일 지정")
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			
			if(loginMember == null) {
				request.setAttribute("message", "로그인 실패!"); //String(로그인실패)도 객체로 취급한다. 클래스이므로 
			}
			view.forward(request, response); //forward : 지정한 뷰로 내보내라, 전송해라.
		} 

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// //context root 알아내는 코드 .
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// post로 전송 올경우 doPost가 받게 되어있음. //request 객체, response 객체 가 브라우저에서 서버로 전달옴. 인풋에
	// 연결된 값은 request안에 담겨져서 온다. 누가 이 서비스를 요청했는지 사용자 정보는 response에 담겨져서 온다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("LoginServlet 클래스의 doPost() 메소드가 연결 실행됨");
		doGet(request, response); // post가 받아서 doGet으로 넘김. (결국 doget에서 코드 작성)
	}

}
