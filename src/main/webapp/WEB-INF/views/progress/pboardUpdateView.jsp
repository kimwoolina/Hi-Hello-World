<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
table.table2 {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	margin: 20px 10px;
}

table.table2 tr {
	width: 50px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

table.table2 td {
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}
</style>

</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp" />
	<section style="padding: 70px 0 60px 0;">

		<br> <br>
		<%--form에서 입력값들과 파일을 같이 전송하려면, 반드시 enctype="multipart/form-data"속성 추가해야 함 --%>
		<form action="pupdate.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="p_proid" value="${ pro_id }"> <input
				type="hidden" name="pid" value="${ pboard.pid }"> <input
				type="hidden" name="p_file_name" value="${ pboard.p_file_name }">
			<input type="hidden" name="p_rfile_name"
				value="${ pboard.p_rfile_name }"> <input type="hidden"
				name="page" value="${ currentPage }">
			<table style="padding-top: 50px" align=center width=700 border=0
				cellpadding=2>
				<%--request에 pboard값 담겨져 왔다. 그래서 그냥 ${ pboard.pid }라고 써도됨  --%>
				<tr>
					<td height=20 align=center bgcolor=#ccc><font color=white>
							${ requestScope.pboard.pid }번게시글 수정 페이지</font></td>
				</tr>
				<tr>
					<td bgcolor=white>
						<table class="table2">
							<tr>
								<td width="150px">제 목</td>
								<td width="550px"><input type="text" name="ptitle"
									value="${ pboard.ptitle }"></td>
							</tr>
							<tr>
								<td>작성자</td>
								<td><input type="text" name="pwriter" readonly
									value="${ pboard.pwriter }"></td>
							</tr>
							<tr>
								<td>첨부파일</td>
								<td>
									<!-- 첨부파일이 있는데 삭제하는 경우 --> <c:if
										test="${ !empty pboard.p_file_name }">
									${ pboard.p_file_name } &nbsp; &nbsp;
								<input type="checkbox" name="delFlag" value="yes">파일삭제 <br>
										<!-- 다른 파일로 변경하는 경우 -->
								바꿀 파일 선택 : <input type="file" name="upfile">
									</c:if> <c:if test="${ empty pboard.p_file_name }">
							(새로 첨부할 파일 선택 ) <input type="file" name="upfile">
									</c:if>
								</td>
							</tr>
							<tr>
								<td>내 용</td>
								<td><textarea name="pcontent" rows="15" cols="70">${ pboard.pcontent }</textarea></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<center>
				<input type="submit" value="수정하기"> &nbsp; <input
					type="reset" value="수정취소"> &nbsp;
				<c:url var="plist" value="/plist.do">
					<c:param name="pro_id" value="${ pro_id }" />
				</c:url>
				<button
					onclick="javascript:location.href='${ plist }'; return false;">목록</button>
				</th>
			</center>
		</form>

		<!-- 푸터 -->
	</section>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>