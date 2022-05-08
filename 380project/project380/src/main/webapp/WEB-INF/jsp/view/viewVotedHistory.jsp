<%-- 
    Document   : viewVotedHistory
    Created on : 2022年5月7日, 上午11:04:51
    Author     : a1742
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Who has voted history page</title>
    </head>
    <body>
        <h1>View History</h1>
        <c:choose>
            <c:when test="${fn:length(votedDB) == 0}">
                <i>There are no record in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${questionDB}" var="q">

                    <p>Question : ${q.query}</p>
                    <table>
                        <tr>
                            <th>Answer</th>
                            <th>Voted</th>
                        </tr>
                        <c:forEach items="${answerDB}" var = "a">
                            <tr>
                                <c:if test="${a.questionID eq q.questionId}">
                                    <td>${a.content}</td>
                                    <c:forEach items="${votedDB}" var="v" varStatus="status">
                                        <c:if test="${v.answerID eq a.answerId}">
                                            <td>
                                                ${v.username} 
                                            </td>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </table>

                </c:forEach>
            </c:otherwise>
        </c:choose>
        <!--        <table>
                    <tr>
                        <th>Question<th>
                        <th>Answer<th>
                        <th>Voted<th>
                    </tr>
        
                </table>-->
    </body>
</html>
