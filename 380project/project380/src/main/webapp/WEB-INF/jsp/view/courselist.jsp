<!DOCTYPE html>
<html>
    <head>
        <title>Customer Support</title>
    </head>
    <body>
        <c:url var="logoutUrl" value="/applogout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Course List</h2>
        <security:authorize access="hasRole('Lecture')">    
            <a href="<c:url value="/student" />">Manage Material and Student</a><br /><br />
        </security:authorize>
        <a href="<c:url value="/material/create" />">Create a note</a><br /><br />
        <c:choose>
            <c:when test="${fn:length(courseDB) == 0}">
                <i>There are no course in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${courseDB}" var="course">
                    <p>
                        Course Code ${course.code}:
                        <a href="<c:url value="/course/listLecture">
                               <c:param name="courseID" value="${course.courseId}" />
                           </c:url>">${course.title}
                        </a>
                        <br />
                    </p>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>