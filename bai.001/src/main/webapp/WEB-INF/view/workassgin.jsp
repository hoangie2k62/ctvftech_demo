<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="err.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách lịch phân công công việc</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách lịch phân công công việc</h1>

	<table>
		<tr>
			<th>stt</th>
			<th>Mã nhân viên</th>
			<th>Mã phòng ban</th>
			<th>Mã công việc</th>
			<th>Ngày bắt đầu</th>
			<th>Ngày kết thúc</th>
		</tr>

		<c:forEach items="${workassgins }" var="workassgin">
		<tr>
			<td></td>
			<td>${workassgin.employeeId }</td>
			<td>${workassgin.officeId }</td>
			<td>${workassgin.workId }</td>
			<td>${workassgin.beginedDate }</td>
			<td>${workassgin.endedDate }</td>
		</tr>
		</c:forEach>

	</table>

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>