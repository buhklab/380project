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
           <security:authorize access="hasRole('LECTURER')">
                                    [<a href="<c:url value="/course/view/edit/${currentLec.lectureID}" />">Edit this lecture</a>]
                                </security:authorize>
                                <security:authorize access="hasRole('LECTURER')"> 
                                    [<a href="<c:url value="/course/view/delete/${currentLec.lectureID}" />">Delete this lecture</a>]
                                </security:authorize>
                                    <br/>
                                    <br/>
        <a href="<c:url value="/course/create/comment/Lecture">
               <c:param name="courseID" value="${currentCourseID}" />
               <c:param name="lid" value="${currentLec.lectureID}" />
           </c:url>">${lec.title}
            Create Comment
        </a><br /><br />
        <security:authorize access="hasRole('LECTURER')">
            <a href="<c:url value="/course/view/edit/${currentLec.lectureID}" />">Add Material</a>
        </security:authorize><br><br>
        <c:choose>
            <c:when test="${fn:length(cmtDB) == 0}">
                <i>There are no comment in this Lecture.</i>
            </c:when>
            <c:otherwise>
                <b>Comment Wall</b>
                <c:forEach items="${cmtDB}" var="c">
                    <p>${c.username} : ${c.content}</p>
                    <security:authorize access="hasRole('ADMIN') or
                                        hasRole('LECTURER')">        
                        [<a href="<c:url value="/course/comment/delete?courseID=${c.courseID}&lid=${c.lectureID}&commentID=${c.id}" />">Delete</a>]
                    </security:authorize>
                    <br /><br />
                </c:forEach>
            </c:otherwise>
        </c:choose> 
                    <p><b>Material :</b></p>
        <c:choose>
            <c:when test="${fn:length(materialDB) == 0}">
                <i>There are no Note in this Lecture</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${materialDB}" var="m">
                    <c:choose>
                            <c:when test="${m.lectureId eq currentLec.lectureID}">
                                <p>
                        <a href="<c:url value="/course/view/info/${currentLec.lectureID}" />">
                            <c:out value="${m.name}" /></a></p>
                               <%--     <security:authorize access="hasRole('LECTURER')">
                                    [<a href="<c:url value="/course/view/edit/${currentLec.lectureID}" />">Edit</a>]
                                </security:authorize>
                                <security:authorize access="hasRole('LECTURER')"> 
                                    [<a href="<c:url value="/course/view/delete/${currentLec.lectureID}" />">Delete</a>]
                                </security:authorize> --%>
                            </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
