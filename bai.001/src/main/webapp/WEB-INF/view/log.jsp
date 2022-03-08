<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thay đổi trong database</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách thay đổi trong database</h1>

	<table>
		<tr>
			<th>stt</th>
			<th>Bảng sửa đổi</th>
			<th>Id thực thể bị sửa đổi</th>
			<th>Loại</th>
			<th>Nội dung sửa đổi</th>
			<th>Mã người sửa đổi</th>
			<th>Tên người sửa đổi</th>
			<th>Ngày sửa đổi</th>
		</tr>

		<c:forEach items="${logs }" var="log">
			<tr>
				<td></td>
				<td>${log.tableName }</td>
				<td>${log.entityId }</td>
				<td>${log.type }</td>
				<td>${log.content }</td>
				<td>${log.editedId }</td>
				<td>${log.editedName }</td>
				<td>${log.editedDate }</td>
			</tr>
		</c:forEach>

	</table>

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>