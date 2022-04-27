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
                <dl>
                    <c:forEach items="${courseDB}" var="course">
                        <br/>
                        <dt>
                            Course Code ${course.code}:
                            <a href="<c:url value="/course/listLecture">
                                   <c:param name="courseID" value="${course.courseId}" />
                               </c:url>">${course.title}
                            </a>
                            <br />
                        </dt>
                        <dd>
                            <c:choose>
                                <c:when test="${fn:length(lectureDB) == 0}">
                                    <i>there are no lecture in ${course.title}
                                    </c:when>
                                    <c:otherwise>
                                        <br/>
                                        <c:forEach items="${lectureDB}" var = "lec">
                                            <c:choose>
                                            <c:when test="${lec.courseID eq course.courseId}">
                                                <dd>
                                                    <i>${lec.title}</i>
                                                </dd>
                                            </c:when>
                                            </c:choose>
                                        </c:forEach>
                                    </c:otherwise>
                                    </c:choose>
                        </dd>

                        <br/>
                    </c:forEach>
                </dl>
            </c:otherwise>
        </c:choose>
    </body>