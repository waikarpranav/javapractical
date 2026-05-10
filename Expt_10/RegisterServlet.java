import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // 1. Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        
        try {
            // 2. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 3. Establish Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userdb", "root", "root");
                
            // 4. Prepare SQL Query
            String query = "INSERT INTO users(username, password, email, country) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, country);
            
            // 5. Execute Query
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h3>Registration Successful!</h3>");
            } else {
                out.println("<h3>Registration Failed!</h3>");
            }
            
            // 6. Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
