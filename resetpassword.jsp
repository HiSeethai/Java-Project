<!-- resetPassword.jsp -->
<html>
<head>
    <title>Reset Password</title>
   
</head>
<body>
    <form action="ResetPassword" method="post">
        <h2>Reset Password</h2>
        <input type="hidden" name="token" value="${param.token}">
        <label for="newPassword">New Password</label>
        <input type="password" id="newPassword" name="newPassword" required><br>
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br>
        <input type="submit" value="Reset Password">
    </form>
</body>
</html>
