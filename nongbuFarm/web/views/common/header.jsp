<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%                       //오브젝트를 멤버에 대입하므로 형변환 해야함 
	Member loginMember = (Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<header>
		<!--== 헤더 ==-->
		<div class="blank" style="background-color:#a4cd73; height:140px;"></div>
		
		<!--== 네비게이션 바 ==-->
		<div class="pricing-filter">
				<div class="pricing-filter-wrapper">
					<div class="container">
						<div class="row">
							<div class="col-md-10 col-md-offset-1">
								<div class="section-header">
									<ul id="filter-list" class="clearfix" align="middle">
										<li class="filter" data-filter="all">전체</li>
										<li class="filter" data-filter=".breakfast">야채/채소</li>
										<li class="filter" data-filter=".special">곡물</li>
										<li class="filter" data-filter=".desert"><a style="color:red;">할인상품</a></li>
										<li class="filter" data-filter=".dinner">나눔의 장</li>
									</ul>
									<!-- @end #filter-list -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		<nav id="template-navbar"
			class="navbar navbar-default custom-navbar-default navbar-fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#Food-fair-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <img id="logo"
						src="/nongbu/resources/images/Logo_main.png" class="logo img-responsive">
					</a>
				</div>
				
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="Food-fair-toggle">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#reserve">공지사항</a></li>
						<li><a href="#contact">고객센터</a></li>
						<%
							if (loginMember == null) { //로그인 안했을 때 보여질 내용
						%>
						<li><a href="/nongbu/views/member/loginPage.jsp">로그인/회원가입</a></li>
						<%
							} else { //로그인 했다면
						%>
						<li><a href="/nongbu/views/member/memberDetailView.jsp">마이페이지</a></li>
						<%
							}
						%>
						<li><a href="#featured-dish">장바구니</a></li>
						
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.row -->
		</nav>
	</header>
</body>
</html>





