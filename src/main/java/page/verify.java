package page;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class verify
 */
@WebServlet("/verify")
public class verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("mail");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/page","root","root");

            // Insert Query
            String query = "SELECT * FROM person WHERE EmailId = ? AND Password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            	request.setAttribute("message", "User registered successfully!");
                request.setAttribute("email", email);
                request.getRequestDispatcher("front.jsp").forward(request, response);
            } else {
                // If details are incorrect
                out.println("<h3>Verification Failed! Please check your details.</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            


	}


