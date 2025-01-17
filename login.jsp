<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
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
            background-color: rgba(0, 0, 0, 0.8);
            padding: 20px 30px;
            border-radius: 15px;
            text-align: center;
            width: 350px; /* Reduced width for a compact form */
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.5); /* Shadow for better design */
        }
        .card h1 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #00c9ff;
        }
        input, button {
            margin: 10px 0;
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 8px; /* Curved corners for input fields and button */
        }
        input {
            background-color: rgba(255, 255, 255, 0.9);
            color: black;
        }
        button {
            background-color: #00c9ff;
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0077b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <h1>Register</h1>
            <form action="store" method="post">
                <input type="text" name="name" placeholder="Name" required>
                <input type="date" name="date" placeholder="Date of Birth" required>
                <input type="email" name="mail" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit">Register</button>
            </form>
        </div>
    </div>
</body>
</html>
