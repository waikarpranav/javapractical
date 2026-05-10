<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple JSP Page</title>
</head>
<body>
    <h2>Experiment 9: Simple JSP Page</h2>
    <% 
        // Java code inside a scriptlet
        String message = "Hello! This is a simple message displayed using a JSP page.";
        out.println("<p><b>" + message + "</b></p>");
    %>
    
    <p>Current Server Time is: <%= new java.util.Date() %></p>
</body>
</html>
