<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin bản nhân</title>
</head>
<body>
	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1>Thông tin bản thân</h1>

	<table>

		<tr>
			<td rowspan="4"><img src="<c:url value=''/>" height="200px"
				width="200px"></td>
			<td>Mã nhân viên: ${employee.id }</td>
		</tr>
		<tr>
			<td>Tên đăng nhập: ${employee.username }</td>
		</tr>
		<tr>
			<td>Số công việc hoàn thành</td>
		</tr>
		<tr>
			<td>Chức vụ: ${employee.jobTitle }</td>
		</tr>

		<tr>
			<td>Họ và tên</td>
			<td>${employee.fullName }</td>
		</tr>

		<tr>
			<td>Người quản lý</td>
			<td>${employee.reportName }</td>
		</tr>

		<tr>
			<td>Số điện thoại</td>
			<td>${employee.phone }</td>
		</tr>

		<tr>
			<td>Email</td>
			<td>${employee.email }</td>
		</tr>

		<tr>
			<td>Mức lương</td>
			<td>${employee.salary }</td>
		</tr>

		<tr>
			<td>Ngày sinh</td>
			<td>${employee.birthday }</td>
		</tr>
		<tr>
			<td>Giới tinh</td>
			<td>${employee.gioiTinh }</td>
		</tr>
		<tr>
			<td>Quốc tịch</td>
			<td>${employee.country }</td>
		</tr>
		<tr>
			<td>Tỉnh/Thành phố</td>
			<td>${employee.city }</td>
		</tr>
		<tr>
			<td>Quận/Huyện</td>
			<td>${employee.district }</td>
		</tr>
		<tr>
			<td>Xã/Phường</td>
			<td>${employee.village }</td>
		</tr>
		<tr>
			<td>Địa chỉ thêm</td>
			<td>${employee.addressExtra }</td>
		</tr>

	</table>

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>