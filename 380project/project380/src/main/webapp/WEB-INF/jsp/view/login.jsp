<%-- 
    Document   : login
    Created on : Apr 21, 2022, 1:38:42 PM
    Author     : a1742
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Course Website</title>
    </head>
    <body>
        <h2>Online Course Website -- Login Page</h2>
        <form action="applogin" method="POST">
            <label for="username">Username:</label><br/>
            <input type="text" id="username" name="username" /><br/><br/>
            <label for="password">Password:</label><br/>
            <input type="password" id="password" name="password" /><br/><br/>
            <input type="checkbox" id="remember-me" name="remember-me" />
            <label for="remember-me">Remember me</label><br/><br/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Log In"/>
        </form>
    </body>
</html>
