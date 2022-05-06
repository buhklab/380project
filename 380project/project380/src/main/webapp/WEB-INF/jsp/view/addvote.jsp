<%-- 
    Document   : addVote
    Created on : 2022年5月6日, 下午10:29:16
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" enctype="multipart/form-data"
                   modelAttribute="ticketForm">
            <form:label path="subject">Write Comment</form:label><br />
            <form:textarea path="body" rows="5" cols="30" /><br /><br />
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
