<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách công việc</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách công việc</h1>

	<table>
		<tr>
			<th>stt</th>
			<th>Mã công việc</th>
			<th>Trạng thái công việc</th>
			<th>Tiêu đề công việc</th>
			<th>Nội dung công việc</th>
			<th>Ngày được tạo</th>
			<th>Ngày bắt đầu</th>
			<th>Ngày kết thúc</th>
			<th>Deadline</th>
			<th>Mã người tạo</th>
			<th>Tên người tạo</th>
		</tr>

		<c:forEach items="${works }" var="work">
		<tr>
			<td></td>
			<td>${work.id }</td>
			<td>${work.status }</td>
			<td>${work.heading }</td>
			<td>${work.content }</td>
			<td>${work.createdDate }</td>
			<td>${work.beginedDate }</td>
			<td>${work.endedDate }</td>
			<td>${work.deadline }</td>
			<td>${work.createdId }</td>
			<td>${work.createName }</td>
		</tr>
		</c:forEach>

	</table>

	<jsp:include page="../toolbar/_footer.jsp" />
	
</body>
</html>