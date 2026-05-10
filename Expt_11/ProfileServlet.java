import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
            out.println("<h2>User Profile</h2>");
            out.println("<p>Username: " + session.getAttribute("user") + "</p>");
            out.println("<a href='home'>Home</a><br>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
