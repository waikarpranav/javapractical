import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
            out.println("<h2>Welcome " + session.getAttribute("user") + "</h2>");
            out.println("<a href='profile'>Profile</a><br>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
