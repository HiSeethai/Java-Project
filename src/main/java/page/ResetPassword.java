package page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String token = request.getParameter("token");
	        String newPassword = request.getParameter("newPassword");
	        String confirmPassword = request.getParameter("confirmPassword");

	        if (!newPassword.equals(confirmPassword)) {
	            response.getWriter().println("<h3>Passwords do not match!</h3>");
	            return;
	        }
	        
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            // Load JDBC Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish Connection
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/page","root","root");
	            
	            String query = "SELECT * FROM person WHERE reset_token = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, token);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                // Update the password and clear the reset token
	                String updateQuery = "UPDATE person SET Password = ?, reset_token = NULL WHERE reset_token = ?";
	                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	                updateStatement.setString(1, newPassword); // Hash password before storing
	                updateStatement.setString(2, token);
	                updateStatement.executeUpdate();

	                response.getWriter().println("Password has been reset successfully!");
	            } else {
	                response.getWriter().println("Invalid or expired token.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	}


