import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Simple validation (can be replaced with DB check)
        if (username.equals("admin") && password.equals("1234")) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("home");
        } else {
            out.println("<h3>Invalid Username or Password</h3>");
        }
    }
}
