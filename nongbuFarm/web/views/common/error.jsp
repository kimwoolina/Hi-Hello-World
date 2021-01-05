<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%-- isEorrorPage attribute 값을 true 로 지정하면, 이 페이지는 에러 처리를 담당하는 페이지다. 라는 뜻이 됨 (기본은 false)
     jsp 파일에서 에러가 발생하면, 자동으로 이 페이지가 실행되도록 연결하면 됨  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<h1>오류 발생</h1>
<% if(exception != null){ //다른 jsp 파일에서 예외가 발생했다면  %>
<h3>jsp 페이지 오류 : <%= exception.getMessage() %>, <%= exception.getClass().getName() %></h3>
<% }else {%>
<h3>servlet 오류: <%= request.getAttribute("message") %></h3>
<% }  %>
<h3><a href="/first/index.jsp">홈으로</a></h3>
<h3><a href="/javascript:history.go(-1);">이전 페이지로 이동</a></h3>
</body>
</html>