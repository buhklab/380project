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
        <title>OCW</title>
    </head>
    <body>
        <h1>${currentLec.title} Material and Comment </h1>

        <a href="<c:url value="/course/create/comment/Lecture">
               <c:param name="courseID" value="${currentCourseID}" />
               <c:param name="lid" value="${currentLec.lectureID}" />
           </c:url>">${lec.title}
            Create Comment
        </a><br /><br />
        <c:choose>
            <c:when test="${fn:length(cmtDB) == 0}">
                <i>There are no comment in this Lecture.</i>
            </c:when>
            <c:otherwise>
                <b>Comment Wall</b>
                <c:forEach items="${cmtDB}" var="c">
                    <p>${c.username} : ${c.content}</p>
                    <security:authorize access="hasRole('ADMIN') or
                                        principal.username=='${c.username}'">
                        [<a href="<c:url value="/course/comment/edit" />">Edit</a>]
                    </security:authorize>
                    <security:authorize access="hasRole('ADMIN') or
                                        principal.username=='${c.username}'">        
                        [<a href="<c:url value="/course/comment/delete?courseID=${c.courseID}&lid=${c.lectureID}&commentID=${c.id}" />">Delete</a>]
                    </security:authorize>
                    <br /><br />
                </c:forEach>
            </c:otherwise>
        </c:choose> 
        <c:choose>
            <c:when test="${fn:length(noteDB) == 0}">
                <i>There are no Note in this Lecture</i>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach items="${noteDB}" var="n">
                        <!--                        add hyperlink here-->
                        <li>><i>Note : ${n.title}</i></li>
                        </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>
    </body>
</html>
