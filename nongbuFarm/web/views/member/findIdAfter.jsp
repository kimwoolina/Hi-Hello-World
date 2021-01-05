<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = (String)request.getAttribute("id");
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



</head>
<body data-spy="scroll" data-target="#template-navbar">

	<!--== 헤더 ==-->
	<%@ include file="../common/header.jsp"%>

	<br>
	<br>
	<br>
	<br>  
	<div class="password_container">
		<form class="form-horizontal" role="form" method="POST">
			<div class="form">
				<div class="row">
					<div class="col-md-12 h2m">
						<h2>아이디 찾기</h2>
						<h6> 회원가입 시 사용한 아이디는 
						<strong><%= userId %></strong>입니다.
						</h6>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 inputbb">
					<a href="/nongbu/login">로그인 화면으로 돌아가기</a>
				</div>
			</div>
		</form>
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