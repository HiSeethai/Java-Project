package page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class store
 */
@WebServlet("/store")
public class store extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public store() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String dob = request.getParameter("date");
        String email = request.getParameter("mail");
        String password = request.getParameter("password");
        

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/page","root","root");

            // Insert Query
            String sql = "INSERT INTO person (Name, DOB,EmailId,Password) VALUES (?, ?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, dob);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                // Pass success message and redirect to JSP
                request.setAttribute("message", "User registered successfully!");
                request.setAttribute("name", name);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                // Pass error message and redirect to JSP
                request.setAttribute("message", "Failed to register user. Please try again.");
                request.getRequestDispatcher("Failed.jsp").forward(request, response);
            }
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                out.println("<h3>Error while closing resources: " + e.getMessage() + "</h3>");
            }
        }
	}
	}


