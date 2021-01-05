<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="shortcut icon" href="resources/images/star.png" type="favicon/ico" /> -->

<title>농부의 텃밭</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/owl.carousel.css">
<link rel="stylesheet" href="resources/css/owl.theme.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet" href="resources/css/flexslider.css">
<link rel="stylesheet" href="resources/css/pricing.css">
<link rel="stylesheet" href="resources/css/main.css">


<script src="resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.flexslider.min.js"></script>
<script type="text/javascript">
            $(window).load(function() {
                $('.flexslider').flexslider({
                 animation: "slide",
                 controlsContainer: ".flexslider-container"
                });
            });
        </script>



</head>
<body data-spy="scroll" data-target="#template-navbar">
 <%
	String clientId = "XysPfL42COWDFUaWGFO1";// 애플리케이션 클라이언트 아이디값";
	String clientSecret = "7oktQ3IVw7";// 애플리케이션 클라이언트 시크릿값";
	String code = request.getParameter("code");
	String state = request.getParameter("state");
	String redirectURI = URLEncoder.encode("http://localhost:8880/nongbu/", "UTF-8");
	String apiURL;
	apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	apiURL += "client_id=" + clientId;
	apiURL += "&client_secret=" + clientSecret;
	apiURL += "&redirect_uri=" + redirectURI;
	apiURL += "&code=" + code;
	apiURL += "&state=" + state;
	String access_token = "";
	String refresh_token = "";
	System.out.println("apiURL=" + apiURL);
	System.out.println("access_token" + access_token);
	try {
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		System.out.print("responseCode=" + responseCode);
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
		if (responseCode == 200) {
			System.out.println(res.toString());
		}
	} catch (Exception e) {
		System.out.println(e);
	}

 %>
 
	<!--== 헤더 ==-->
	<%@ include file="./views/common/header.jsp"%>

			<!--== 이벤트 ==-->
			<section id="header-slider" class="owl-carousel">
				<div class="item">
					<div class="container">
						<div class="header-content">
							<h1 class="header-title">BEST FOOD</h1>
							<p class="header-sub-title">create your own slogan</p>
						</div>
						<!-- /.event-content -->
					</div>
				</div>
				<div class="item">
					<div class="container">
						<div class="header-content">
							<h1 class="header-title">BEST SNACKS</h1>
							<p class="header-sub-title">create your own slogan</p>
						</div>
						<!-- /.event-content -->
					</div>
				</div>
				<div class="item">
					<div class="container">
						<div class="header-content text-right pull-right">
							<h1 class="header-title">BEST DRINKS</h1>
							<p class="header-sub-title">create your own slogan</p>
						</div>
						<!-- /.event-content -->
					</div>
				</div>
		</div>
	</section>

	<!--== 상품목록 ==-->
	<div id="w">
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<ul id="menu-pricing" class="menu-price">
						<li class="item dinner"><a href="#"> <img
								src="resources/images/food1.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc text-center">
									<span>
										<h3>Tomato Curry</h3> Natalie &amp; Justin Cleaning by Justin
										Younger
									</span>
								</div>
						</a>

							<h2 class="white">$20</h2></li>

						<li class="item breakfast"><a href="#"> <img
								src="resources/images/food2.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Prawn Dish</h3> Lorem ipsum dolor sit amet
									</span>
								</div>
						</a>

							<h2 class="white">$20</h2></li>
						<li class="item desert"><a href="#"> <img
								src="resources/images/food3.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Salad Dish</h3> Consectetur adipisicing elit, sed do
										eiusmod
									</span>
								</div>
						</a>

							<h2 class="white">$18</h2></li>
						<li class="item breakfast special"><a href="#"> <img
								src="resources/images/food4.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Prawn Dish</h3> Tempor incididunt ut labore et dolore
									</span>
								</div>
						</a>

							<h2 class="white">$15</h2></li>
						<li class="item breakfast"><a href="#"> <img
								src="resources/images/food5.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Vegetable Dish</h3> Magna aliqua. Ut enim ad minim veniam
									</span>
								</div>
						</a>

							<h2 class="white">$20</h2></li>
						<li class="item dinner special"><a href="#"> <img
								src="resources/images/food6.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Chicken Dish</h3> Quis nostrud exercitation ullamco
										laboris
									</span>
								</div>
						</a>

							<h2 class="white">$22</h2></li>
						<li class="item desert"><a href="#"> <img
								src="resources/images/food7.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Vegetable Noodles</h3> Nisi ut aliquip ex ea commodo
									</span>
								</div>
						</a>

							<h2 class="white">$32</h2></li>
						<li class="item dinner"><a href="#"> <img
								src="resources/images/food8.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Special Salad</h3> Duis aute irure dolor in reprehenderit
									</span>
								</div>
						</a>

							<h2 class="white">$38</h2></li>
						<li class="item desert special"><a href="#"> <img
								src="resources/images/food9.jpg" class="img-responsive"
								alt="Food">
								<div class="menu-desc">
									<span>
										<h3>Ice-cream</h3> Excepteur sint occaecat cupidatat non
									</span>
								</div>
						</a>

							<h2 class="white">$38</h2></li>
					</ul>

					<!-- <div class="text-center">
                                    <a id="loadPricingContent" class="btn btn-middle hidden-sm hidden-xs">Load More <span class="caret"></span></a>
                            </div> -->

				</div>
			</div>
		</div>

	</div>


	<!--== 푸터 ==-->
	<%@ include file="./views/common/footer.jsp"%>


	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.mixitup.min.js"></script>
	<script src="resources/js/wow.min.js"></script>
	<script src="resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="resources/js/jquery.hoverdir.js"></script>
	<script type="text/javascript" src="resources/js/jQuery.scrollSpeed.js"></script>
	<script src="resources/js/script.js"></script>


</body>
</html>