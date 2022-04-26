<%-- 
    Document   : listLecture
    Created on : 2022/4/20, 下午 11:48:25
    Author     : TCH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>380 project></title>
    </head>
    <body>
        <h1>Course Name:  ${currentCourse.title}</h1>
        <p>Lectures : </p>
        <c:choose>
            <c:when test="${fn:length(lecture) == 0}">
                <i>There are no lecture in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${lecture}" var="lec">
                    <p>
                        ${lec.title}, 
                        Note: 
                        <a href="<c:url value="/course/view/${lec.lectureID}" />">
                            <c:out value="${lec.title}" /></a>
                    </p>

                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
