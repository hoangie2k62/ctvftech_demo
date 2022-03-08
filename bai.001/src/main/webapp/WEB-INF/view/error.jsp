<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lỗi rồi :((</title>
</head>
<body>

	<h1>Rất xin lỗi, bạn vui lòng thử lại sau!!!</h1>
	
	<h3>Mã lỗi:</h3>
	<p>${exception.message }</p><br/>
	
	<b>Lỗi cụ thể như sau:</b>
	<pre>
		${out.println(exception.toString)}
	</pre>
	
</body>
</html>