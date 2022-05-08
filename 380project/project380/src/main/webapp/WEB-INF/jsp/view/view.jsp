<!DOCTYPE html>
<html>
    <head>
        <title>Lecture Material</title>
    </head>
    <body>

        <h2>Lecture #${lecture.lectureID}: <c:out value="${lecture.title}" /></h2>
        <security:authorize access="hasRole('LECTURER')">
            [<a href="<c:url value="/course/view/edit/${lecture.lectureID}" />">Edit</a>]
        </security:authorize>
        <security:authorize access="hasRole('LECTURER')"> 
            [<a href="<c:url value="/course/view/delete/${lecture.lectureID}" />">Delete</a>]
        </security:authorize>
        <br /><br />
        <c:if test="${fn:length(lecture.material) > 0}">
            Materials:
            <c:forEach items="${lecture.material}" var="material" varStatus="status">
                <c:if test="${!status.first}">, </c:if>
                <a href="<c:url value="/course/view/${lecture.lectureID}/material/${material.name}" />">
                    <c:out value="${material.name}" /></a>
            </c:forEach><br /><br />
        </c:if>
        <a href="<c:url value="/course" />">Return to Course Page</a>
    </body>
</html>
