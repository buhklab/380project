<%-- 
    Document   : index
    Created on : 2022/4/20, 下午 09:56:20
    Author     : TCH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
 <body>
        <h1>This is course:S380F</h1>
        Hi User!
        <table>
            <tr><th>Lecture</th><th>MC</th></tr>
            <tr><td>        <a href="<c:url value="/tickets">
            <c:param name="Lecture" value="1" />
        </c:url>">Lecture1(Introduction)</a><br /><br /></td><td>        <a href="<c:url value="/tickets">
            <c:param name="MC" value="1" />
        </c:url>">Q1</a><br /><br /></td></tr>
            <tr><td>        <a href="<c:url value="/tickets">
            <c:param name="Lecture" value="2" />
        </c:url>">Lecture2(Servlet)</a><br /><br /></td><td>        <a href="<c:url value="/tickets">
            <c:param name="MC" value="2" />
        </c:url>">Q2</a><br /><br /></td></tr>
            <tr><td>        <a href="<c:url value="/tickets">
            <c:param name="Lecture" value="3" />
        </c:url>">Lecture3(JSP)</a><br /><br /></td><td>        <a href="<c:url value="/tickets">
            <c:param name="MC" value="3" />
        </c:url>">Q3</a><br /><br /></td></tr>
        </table>
    </body>
</html>
