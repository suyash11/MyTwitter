<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>
</head>
<body>
<form name="registration" action="RegServlet" method="post">
<input type="hidden" name="pagename" value="register"/>
<table cellpadding="5" cellspacing="5">
<tr>
	<td>User Name</td>
	<td><input type="text" name="txtFName"/></td>
</tr>
<tr>
	<td>Email</td>
	<td><input type="text" name="txtEmail"></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="txtPassword"/></td>
</tr>
<tr>
	<td><button type="submit">Submit</button></td>
</tr>
</table>
</form>

</body>
</html>