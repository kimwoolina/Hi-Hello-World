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
</script>



</head>
<body data-spy="scroll" data-target="#template-navbar">

	<!--== 헤더 ==-->
	<%@ include file="../common/header.jsp"%>

	<br><br><br><br> 
	<div align="center">
	<h3>비밀번호 찾기</h3>
	<!--<h5>비밀번호는 가입시 입력하신 아이디와 휴대폰 번호를 통해 찾을 수 있습니다.</h5>-->
		<form class="form-horizontal" role="form" method="POST" action="/nongbu/findPw">
			<div class="input-group mb-2 mr-sm-2 mb-sm-0">
				               <input type="text" name="id" class="form-control"
					id="id" placeholder="아이디" required autofocus>          
			</div>
			<div class="input-group mb-2 mr-sm-2 mb-sm-0">
				             <input type="tel" name="phone" class="form-control"
					id="phone" placeholder="휴대폰번호" required>            
			</div>
			<br>
			<button type="submit" class="btn btn-outline-secondary findbtn">찾기</button>
		</form>
	</div>
	<br><br><br><br>


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