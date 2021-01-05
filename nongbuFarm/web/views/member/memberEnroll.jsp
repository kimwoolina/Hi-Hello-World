<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		//유효성 검사 코드 작성함
		//서버 컨트롤러로 전송할 값들이 요구한 조건을 모두 만족하였는지 검사하는 것

		//암호와 암호확인이 일치하지 않는지 확인함
		var pwdValue = document.getElementById("userpwd1").value;
		var pwdValue2 = document.getElementById("userpwd2").value;
		if (pwdValue !== pwdValue2) {
			alert("암호와 암호확인이 일치하지 않습니다. 다시 입력해 주세요.");
			document.getElementById("userpwd1").select();
			return false; //전송 취소함
		} //if

		return true; //전송처리됨
	} //validate()

	//아이디 중복 체크 확인을 위한 ajax 실행 처리용 함수
	function dupIdCheck() {
		$.ajax({
			url : "/nongbu/idchk",
			type : "post",
			data : {
				userid : $("#userid").val()
			},
			success : function(data) {
				//처리결과를 문자열로 받음
				console.log("success : " + data);
				if (data == "ok") {
					alert("사용 가능한 아이디입니다.");
					$("#userpwd").focus();
				} else {
					alert("이미 사용중인 아이디입니다.\n 다시 입력하세요.");
					$("#userid").select();
				}
			},
			error : function(jqXHR, textstatus, errorthrown) {
				//에러 발생시 구동되는 콜백함수임
				console.log("error : " + jqXHR + ", " + textstatus + ", "
						+ errorthrown);
			}
		});
	}
</script>


</head>
<body data-spy="scroll" data-target="#template-navbar">

	<!--== 헤더 ==-->
	<%@ include file="../common/header.jsp"%>

	<!--== 내용 ==-->
	<br>
	<br>
	<br>
	<h2 align="center">
		<b>회원가입</b>
	</h2>
	<form action="/nongbu/enroll" method="post"
		onsubmit="return validate();">
		<table id="outer" align="center" width="500" cellspacing="5"
			cellpadding="0">
			<tr>
				<th colspan="2">회원 정보를 입력해 주세요. (* 표시는 필수입력 항목입니다.)</th>
			</tr>
			<tr>
				<th width="120">*이 름</th>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<th width="120">*아이디</th>
				<td><input type="text" name="userid" id="userid" required>
					&nbsp; <input type="button" value="중복체크" onclick="dupIdCheck();"></td>
			</tr>
			<tr>
				<th width="120">*암 호</th>
				<td><input type="password" name="userpwd" id="userpwd1"
					required></td>
			</tr>
			<tr>
				<th width="120">암호확인</th>
				<td><input type="password" id="userpwd2"></td>
			</tr>
			<tr>
				<th width="120">*전화번호</th>
				<td><input type="tel" name="phone" required></td>
			</tr>
			<tr>
				<th width="120">*주 소</th>
				<td><input type="text" name="addr" required></td>
			</tr>
			<tr>
				<th width="120">*이메일</th>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<th width="120" colspan="2"><a
					href="javascript:history.go(-1);">이전 페이지로 이동</a> &nbsp; <input
					type="submit" value="가입하기"> &nbsp; <input type="reset"
					value="작성취소"></th>
			</tr>
		</table>
	</form>
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