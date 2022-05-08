<%-- 
    Document   : pol
    Created on : 2022年4月20日, 下午11:24:05
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
        <a href="<c:url value="/create/comment/pol">
               <c:param name="MC" value="${qID}" />
           </c:url>">
            Create Comment
        </a>
        <h1>Poll</h1>
        The Question is ${question.query}
        <br/>
        <c:choose>
            <c:when test="${fn:length(answerDB) == 0}">
                <i>There are no mc answer in the system.</i>
            </c:when>
            <c:otherwise>
                <%--><c:forEach items="${answerDB}" var = "data">--%>
                <c:forEach var="i" begin="0" end="${fn:length(answerDB)-1}">
                    ${answerDB[i].content},   ${total[i].noOfVoted} user voted this option
                    <br/>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${fn:length(cmts) == 0}">
                <i> No Comment here. </i>
            </c:when>
            <c:otherwise>
                <b>Comment Wall</b>
                <c:forEach items="${cmts}" var="c">
                    <p>${c.username} : ${c.content}</p>
                    <security:authorize access="hasRole('ADMIN') or hasRole('LECTURER')">
                        [<a href="<c:url value="/delete/comment/pol?MC=${c.questionID}&CommentID=${c.id}" />">Delete</a>]
                    </security:authorize>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <a href="<c:url value="/add/addvote">
               <c:param name="MC" value="${qID}" />
           </c:url>">
            <br/>
            Add / Edit Vote
        </a>
    </body>
</html>
