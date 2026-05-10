import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // Set content type
        response.setContentType("text/html");
        
        // Get parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Display output
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>User Details</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("</body></html>");
    }
}
