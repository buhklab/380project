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
        <p><a href="/project380/applogin?language=en_US">English</a>|<a href="/project380/applogin?language=zh_HK">Chinese</a></p>
        <c:if test="${param.error != null}">
            <p>Login failed.</p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p>You have logged out.</p>
        </c:if>
        <h1><spring:message code = "label.name" text = "Online Course Website -- Login Page"/></h1>
          
            <form action="applogin" method="POST">
                <label for="username"><spring:message code = "label.username" text = "Username:"/></label><br/>
                <input type="text" id="username" name="username" /><br/><br/>
                <label for="password"><spring:message code = "label.password" text = "Password:"/></label><br/>
                <input type="password" id="password" name="password" /><br/><br/>
                <input type="checkbox" id="remember-me" name="remember-me" />
                <label for="remember-me"><spring:message code = "label.rememberme" text = "Remeber me"/></label><br/><br/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value=<spring:message code = "label.login" text = "Login"/>>
            </form>
    </body>
</html>
