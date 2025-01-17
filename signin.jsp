<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="verify" method="post">
    <h2>Login</h2>
    <label for="mail">Email</label>
    <input type="email" id="mail" name="mail" required><br>
    <label for="password">Password</label>
    <input type="password" id="password" name="password" required><br>
    <input type="submit" value="Login">
    <a href="forgotpassword.jsp">Forgot Password?</a>
</form>
</body>
</html>
