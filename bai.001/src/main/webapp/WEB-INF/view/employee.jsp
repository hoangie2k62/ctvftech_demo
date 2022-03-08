<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhân viên</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách nhân viên</h1>

	<table>
		<tr>
			<th>stt</th>
			<th>Mã nhân viên</th>
			<th>Tên nhân viên</th>
			<th>Ngày sinh</th>
			<th>Giới tính</th>
			<th>Quốc tịch</th>
			<th>Tỉnh/Thành phố</th>
			<th>Quận/Huyện</th>
			<th>Xã/Phường</th>
			<th>Thông tin địa chỉ riêng</th>
			<th>Số điện thoạt</th>
			<th>Email</th>
			<th>Mã Người quản lý</th>
			<th>Tên người quản lý</th>
			<th>Chức vụ</th>
			<th>Mức lương</th>
			<td>Tên đăng nhập</td>
		</tr>

		<c:forEach items="${employees }" var="emp">
		<tr>
			<td></td>
			<td>${emp.id }</td>
			<td>${emp.fullName }</td>
			<td>${emp.birthday }</td>
			<td>${emp.gioiTinh }</td>
			<td>${emp.country }</td>
			<td>${emp.city }</td>
			<td>${emp.district }</td>
			<td>${emp.village }</td>
			<td>${emp.addressExtra }</td>
			<td>${emp.phone }</td>
			<td>${emp.email }</td>
			<td>${emp.reportTo }</td>
			<td>${emp.reportName }</td>
			<td>${emp.jobTitle }</td>
			<td>${emp.salary }</td>
			<td>${emp.username }</td>
		</tr>
		</c:forEach>

	</table>

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>