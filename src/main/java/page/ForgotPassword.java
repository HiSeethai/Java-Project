package page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        out.println("Received email: " + email + "<br>");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/page", "root", "root");
            out.println("Database connection established.<br>");

            // Check if email exists in the database
            String query = "SELECT * FROM person WHERE EmailId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                out.println("Email found in the database: " + email + "<br>");

                // Generate a unique token for resetting the password
                String token = UUID.randomUUID().toString();
                out.println("Generated token: " + token + "<br>");

                // Update the token in the database
                String updateQuery = "UPDATE person SET reset_token = ? WHERE EmailId = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, token);
                updateStatement.setString(2, email);

                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    out.println("Token updated in the database.<br>");
                    String resetLink = "http://localhost:8080/JSP%20pro2/resetpassword.jsp?token=" + token;


                    response.getWriter().println("<h3>Password reset link sent:</h3>");
                    response.getWriter().println("<a href='" + resetLink + "'>Reset Password</a>");
                } else {
                    out.println("Failed to update token in the database.<br>");
                    response.getWriter().println("<h3>Failed to update token. Please try again later.</h3>");
                }

                updateStatement.close(); // Close the update statement
            } else {
                out.println("Email not found in the database.<br>");
                response.getWriter().println("<h3>Email not found in our records.</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred: " + e.getMessage() + "<br>");
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Failed to close database resources.<br>");
            }
        }
    }
}
