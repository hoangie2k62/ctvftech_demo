<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>

	<h1 align="center">chào mừng đến trang chủ của CTV</h1>

	<div>
		<a href="${pageContext.request.contextPath}/user/login/">Đăng nhập</a><br/>
		<a href="${pageContext.request.contextPath}/work/workassgin/">Bảng phân công công việc</a><br/>
		<a href="${pageContext.request.contextPath}/work/">Danh sách công việc</a><br/>
		<a href="${pageContext.request.contextPath}/employee/userInfo">Thông tin nhân viên</a><br/>
		<a href="${pageContext.request.contextPath}/employee/">Danh sách nhân viên </a><br/>
		<a href="${pageContext.request.contextPath}/office">Danh sách phòng ban</a><br/>
	</div>
	
	<jsp:include page="../toolbar/_footer.jsp" />
	
</body>
</html>