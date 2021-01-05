<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

</head>
<body data-spy="scroll" data-target="#template-navbar">

	<!--== 헤더 ==-->
	<%@ include file="../common/header.jsp"%>

	<!--== 내용 ==-->
	<section>
		<h2 align="center">내 정보 보기 페이지</h2>
		<br>
		<table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
			<tr>
				<th width="120">이 름</th>
				<td><%=loginMember.getUserName()%></td>
			</tr>
			<tr>
				<th width="120">아이디</th>
				<td><%=loginMember.getUserId()%></td>
			</tr>
			<tr>
				<th width="120">전화번호</th>
				<td><%=loginMember.getPhone()%></td>
			</tr>
			<tr>
				<th width="120">주 소</th>
				<td><%=loginMember.getAddr()%></td>
			</tr>
			<tr>
				<th width="120">이메일</th>
				<td><%=loginMember.getEmail()%></td>
			</tr>
			<tr>
				<th width="120">회원 가입 날짜</th>
				<td><%=loginMember.getStartDate()%></td>
			</tr>
			<tr>
				<th width="120">회원 정보 마지막 수정 날짜</th>
				<td><%=loginMember.getLastModified()%></td>
			</tr>
			<tr>
				<th width="120" colspan="2">
					<button onclick="moveUpdateView();">수정 페이지로 이동</button> &nbsp;
					<button onclick="sendDelete();">탈퇴하기</button>
				</th>
			</tr>
			<br>
			<table id="loginTbl" width="250" align="center">
			<tr style="text-align:center;">
				<th><%=loginMember.getUserName()%> 님</th>
				<td><a href="/nongbu/logout">로그아웃</a></td>
			</tr>
			</table>
	<script type="text/javascript">
	function moveUpdateView(){
		//요청한 회원의 정보를 조회해서 수정페이지를 내보내는 서블릿을 요청함
		//회원의 아이디를 전송함
		//html <a href="연결대상"> == javascript : location.href = "연결대상";
		//연결대상으로 값도 전송할 경우, 쿼리 스트링(Query String)을 이용함
		//쿼리스트링 : ?전솔이름=값&전송이름=값
		//전송값에 Expression Tag 사용할 수 있음
		location.href = "/nongbu/mupview?userid=<%=loginMember.getUserId()%>";
	}
	
	function sendDelete(){
		//탈퇴는 삭제처리함
		//요청한 회원의 아이디를 탈퇴 처리하는 서블릿으로 전송해서 회원 테이블에서 삭제 처리함
		location.href = "/nongbu/mdel?userid=<%=loginMember.getUserId()%>
				";
		}
	</script>
	</section>
	<!--== 푸터 ==-->
	<%@ include file="../common/footer.jsp"%>

	<script src="../../resources/js/bootstrap.min.js"></script>
	<script src="../../resources/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="../../resources/js/jquery.mixitup.min.js"></script>
	<script src="../../resources/js/wow.min.js"></script>
	<script src="../../resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="../../resources/js/jquery.hoverdir.js"></script>
	<script type="text/javascript" src="../../resources/js/jQuery.scrollSpeed.js"></script>
	<script src="../../resources/js/script.js"></script>

</body>
</html>