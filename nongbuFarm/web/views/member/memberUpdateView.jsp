<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member member = (Member) request.getAttribute("member");
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

	function validate() {
		//암호와 암호확인이 일치하지 않는지 확인하는 유효성 검사 코드
		var pwdValue = document.getElementById("userpwd1").value;
		var pwdValue2 = document.getElementById("userpwd2").value;
		if (pwdValue !== pwdValue2) {
			alert("암호와 암호확인이 일치하지 않습니다. 다시 입력해 주세요.");
			document.getElementById("userpwd1").select();
			return false; //전송 취소함
		} //if

		return true; //전송처리됨
	}
	
</script>


</head>
<body data-spy="scroll" data-target="#template-navbar">

	<!--== 헤더 ==-->
	<%@ include file="../common/header.jsp"%>

	<!--== 내용 ==-->
	<form action="/nongbu/mupdate" method="post">
		<table id="outer" align="center" width="500" cellspacing="5"
			cellpadding="0">
			<tr>
				<th width="120">이 름</th>
				<td><input type="text" name="username"
					value="<%=member.getUserName()%>" readonly></td>
			</tr>
			<!-- readonly : 서버로 전송은 가지만 수정은 못함 -->
			<tr>
				<th width="120">아이디</th>
				<td><input type="text" name="userid"
					value="<%=member.getUserId()%>" readonly></td>
			</tr>
			<tr>
				<th width="120">암 호</th>
				<td><input type="password" name="userpwd" id="userpwd1"
					value="<%=member.getUserPwd()%>"></td>
			</tr>
			<tr>
				<th width="120">암호확인</th>
				<td><input type="password" id="userpwd2"></td>
			</tr>
			<tr>
				<th width="120">전화번호</th>
				<td><input type="tel" name="phone"
					value="<%=member.getPhone()%>"></td>
			</tr>
			<tr>
				<th width="120">주 소</th>
				<td><input type="text" name="addr"
					value="<%=member.getAddr()%>"></td>
			</tr>
			<tr>
				<th width="120">이메일</th>
				<td><input type="email" name="email"
					value="<%=member.getEmail()%>"></td>
			</tr>
			<tr>
				<th width="120" colspan="2"><a
					href="javascript:history.go(-1);">이전 페이지로 이동</a> &nbsp; <input
					type="submit" value="수정하기"> &nbsp; <input type="reset"
					value="수정취소"></th>
			</tr>
		</table>
	</form>

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