<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 네이버 아이디로 로그인 -->
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<!-- 아이디저장 -->
<%
	//아이디저장 (점속할 때마다 쿠키파일이 있는지 검사)
	Cookie[] cookie = request.getCookies(); //쿠키 받아온다
	String autoId = "";
	if (cookie != null) { //만약 쿠키가 null이 아니라면
		for (int i = 0; i < cookie.length; i++) {
			if (cookie[i].getName().trim().equals("autoId")) {
				//System.out.println(cookie[i].getValue());
				autoId = cookie[i].getValue(); //autoId라는 이름의 키가 있을 경우 문자열에 그 쿠키의 값을 넣는다.
			}
		}
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="shortcut icon" href="resources/images/star.png" type="favicon/ico" /> -->

<title>농부의 텃밭</title>

<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/font-awesome.min.css">
<link rel="stylesheet" href="../../resources/css/owl.carousel.css">
<link rel="stylesheet" href="../../resources/css/owl.theme.css">
<link rel="stylesheet" href="../../resources/css/animate.css">
<link rel="stylesheet" href="../../resources/css/flexslider.css">
<link rel="stylesheet" href="../../resources/css/pricing.css">
<link rel="stylesheet" href="../../resources/css/main.css">


<script src="../../resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="../../resources/js/jquery.flexslider.min.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlsContainer : ".flexslider-container"
		});
	});
</script>

<style>
a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
}
</style>


</head>
<body data-spy="scroll" data-target="#template-navbar">

	<!--== 헤더 ==-->
	<%@ include file="../common/header.jsp"%>

	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<!-- 네이버로 로그인 -->
		<%
			String clientId = "XysPfL42COWDFUaWGFO1";//애플리케이션 클라이언트 아이디값";
			String redirectURI = URLEncoder.encode("http://localhost:8880/nongbu/", "UTF-8");
			SecureRandom random = new SecureRandom();
			String state = new BigInteger(130, random).toString();
			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			apiURL += "&client_id=" + clientId;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&state=" + state;
			session.setAttribute("state", state);
		%>

		<%
			if (loginMember == null) { //로그인 안했을 때 보여질 내용
		%>
		<form action="/nongbu/login" method="post">
			<!-- form action:가짜이름으로 맵핑.(이 이름 가진 서블릿 만들어진다.) 모든 서블릿들은 루트에서 부터 실행시킨다. -->
			<table id="loginTbl" width="250">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid" value="<%=autoId%>"></td>
				</tr>
				<tr>
					<th>암 호</th>
					<td><input type="password" name="userpwd"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;">아이디 저장 <input
						type="checkbox" name="id_rem" value="on"
						<%if (autoId.length() > 1)
					out.println("checked");%>></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="로그인">
						&nbsp; <a href="/nongbu/views/member/memberEnroll.jsp">회원가입</a></th>
				</tr>
				<tr>
					<td colspan="2"><a href="/nongbu/views/member/findId.jsp">아이디
							찾기</a> <a href="/nongbu/views/member/findPw.jsp">비밀번호 찾기</a></td>
				</tr>
				<!-- 컨트롤러로 전달 -->
			</table>
			<br>
			<a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
		</form>
		<%
			} else { //로그인 했다면
		%>
		<table id="loginTbl" width="250">
			<tr>
				<th><%=loginMember.getUserName()%> 님</th>
				<td><a href="/nongbu/logout">로그아웃</a></td>
			</tr>
			<tr>
				<th colspan="2"><a
					href="/nongbu/views/member/memberDetailView.jsp">내정보보기</a></th>
			</tr>
		</table>
		<%
			}
		%>
	</div>
	<br>
	<br>
	<br>
	<br>

	<!--== 푸터 ==-->
	<%@ include file="../common/footer.jsp"%>


	<script src="../../resources/js/bootstrap.min.js"></script>
	<script src="../../resources/js/owl.carousel.min.js"></script>
	<script type="text/javascript"
		src="../../resources/js/jquery.mixitup.min.js"></script>
	<script src="../../resources/js/wow.min.js"></script>
	<script src="../../resources/js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="../../resources/js/jquery.hoverdir.js"></script>
	<script type="text/javascript"
		src="../../resources/js/jQuery.scrollSpeed.js"></script>
	<script src="../../resources/js/script.js"></script>


</body>
</html>