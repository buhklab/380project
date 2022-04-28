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
        <security:authorize access="hasRole('Lecturer')">    
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
                            <a href="<c:url value="/course/view/listLecture">
                                   <c:param name="courseID" value="${course.courseId}" />
                               </c:url>">${course.title}
                            </a>
                            <br />
                        </dt>

                        <c:choose>
                            <c:when test="${fn:length(lectureDB) == 0}">
                                <dd>there are no lecture in ${course.title}</dd>
                            </c:when>
                            <c:otherwise>
                                <br/>
                                <c:forEach items="${lectureDB}" var = "lec">
                                    <c:choose>
                                        <c:when test="${lec.courseID eq course.courseId}">
                                            <dd>
                                                ${lec.title}
                                            </dd>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </dl>
            </c:otherwise>
        </c:choose>
        <p>MC poll</p>
        <br/>
        <c:choose>
            <c:when test="${fn:length(questionDB) == 0}">
                <i>There are no MC in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${questionDB}" var = "data">
                    <a href="<c:url value="/view/McPoll">
                                   <c:param name="MC" value="${data.questionId}" />
                               </c:url>">${data.query}
                            </a>
                            <br/>
                </c:forEach>
            </c:otherwise>
        </c:choose>



    </body>