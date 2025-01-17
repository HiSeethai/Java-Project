<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Status</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('https://img.freepik.com/free-photo/christmas-snowy-landscape_1048-3491.jpg?ga=GA1.1.1708520941.1728998731&semt=ais_hybrid') no-repeat center center fixed;
            background-size: cover;
            font-family: Arial, sans-serif;
            color: white;
        }
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 20px 40px;
            border-radius: 10px;
            text-align: center;
        }
        .nav {
            margin-top: 20px;
        }
        .nav a {
            color: #00c9ff;
            text-decoration: none;
            margin: 0 10px;
            font-weight: bold;
        }
        .nav a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <h2><%= request.getAttribute("message") %></h2>
            <% if (request.getAttribute("name") != null) { %>
                <p>Welcome, <%= request.getAttribute("name") %>!</p>
            <% } %>
            <div class="nav">
                <a href="register.jsp">Register Another User</a>
                <a href="signin.jsp">SignIn Page</a>
            </div>
        </div>
    </div>
</body>
</html>