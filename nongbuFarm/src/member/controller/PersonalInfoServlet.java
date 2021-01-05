package member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class PersonalInfoServlet
 */
@WebServlet("/persnolInfo")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonalInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String token = "AAAAPMJNnoFyueK7pWf6xhjMQeSSS3SPszGDg79XfY5ZRawuQGnm27N7bDL_1prhQsxpdIqDpKT4U1aYLT0YhxWcXwQ";// 네이버
		String header = "Bearer " + token; // Bearer 다음에 공백 추가
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			System.out.println(res.toString());

			JSONParser parsing = new JSONParser();
			Object obj = parsing.parse(res.toString());
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject resObj = (JSONObject) jsonObj.get("response");

			// 왼쪽 변수 이름은 원하는 대로 정하면 된다.
			// 단, 우측의 get()안에 들어가는 값은 와인색 상자 안의 값을 그대로 적어주어야 한다.
			String naverCode = (String) resObj.get("id");
			String email = (String) resObj.get("email");
			String name = (String) resObj.get("name");

			// 테스트출력
			String data = resObj.toString();
			System.out.println(data);

			Member loginMember = new Member();
			loginMember.setUserId(naverCode);
			loginMember.setUserName(name);
			loginMember.setEmail(email);

			System.out.println("loginMember : " + loginMember);

			// 네이버 아이디로 임시 로그인
			HttpSession session = request.getSession(); // getsession() 괄호빈칸이면 있으면 가져오고 없으면 새로 만들라는 뜻
			System.out.println("session ID : " + session.getId());
			// 필요한 경우 세션 객체에 객체정보를 저장할 수도 있음. Map 방식임
			// 세션레퍼런스.setAttribute("이름", 객체); 여러번쓸수 있는 메소드.
			session.setAttribute("loginMember", loginMember);
			// 뷰페이지를 선택해서 내보냄
			response.sendRedirect("/nongbu/index.jsp");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
