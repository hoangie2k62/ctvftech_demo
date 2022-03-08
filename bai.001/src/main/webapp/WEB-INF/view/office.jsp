<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách phòng ban</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách phòng ban</h1>

	<table>
		<tr>
			<th>stt</th>
			<th>Mã phòng ban</th>
			<th>Tên phòng ban</th>
			<th>Thông tin phòng ban</th>
			<th>Mã người quản lý</th>
			<th>Tên người quản lý</th>
		</tr>

		<c:forEach items="${ofices }" var="office">
		<tr>
			<td></td>
			<td>${office.id }</td>
			<td>${office.officeName }</td>
			<td>${office.description }</td>
			<td>${office.createId }</td>
			<td>${office.createName }</td>
		</tr>
		</c:forEach>

	</table>

	<jsp:include page="../toolbar/_footer.jsp" />
	
</body>
</html>