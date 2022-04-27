<%-- 
    Document   : showLecWithCourseID
    Created on : Apr 25, 2022, 6:13:34 PM
    Author     : a1742
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${currentLec.title} Material and Comment </h1>
        
        
        
        
        
                <c:choose>
            <c:when test="${fn:length(cmtDB) == 0}">
                <i>There are no comment in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${cmtDB}" var="c">
                        <p>${c.toString()}</p>
                </c:forEach>
            </c:otherwise>
        </c:choose> 
    </body>
</html>
