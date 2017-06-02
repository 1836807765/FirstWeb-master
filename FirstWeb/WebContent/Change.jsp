<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改界面</title>
</head>
<body>
	<form action="change" method="get">
		<center>
			<table>
				<tr>
					<td><input type="text" value="请输入新的密码" name="password1" /><a>${msg1}</a></td>
				</tr>
				<tr>
					<td><input type="text" value="请重新输入一次密码" name="password2" /><a>${msg2}</a></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" /></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>