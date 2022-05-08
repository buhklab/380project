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
        <title>Add Vote</title>
    </head>
    <body>
        <form:form method="POST" enctype="multipart/form-data"
                   modelAttribute="addVoteForm">
            <form:label path="subject">Add answer</form:label><br />
            <c:forEach var="i" begin="0" end="${fn:length(answerDB)-1}">
                <form:radiobutton value="${i+1}" path="body"/>${answerDB[i].content}
                    <br/>
                </c:forEach>
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
