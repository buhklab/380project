<!DOCTYPE html>
<html>
    <head><title>Customer Support User Management</title></head>
    <body>
        <br /><br />
        <a href="<c:url value="/course" />">Return to course list</a>
        <h2>Users</h2>

        <security:authorize access="hasRole('ADMIN') or hasRole('LECTURER')">        
            <a href="<c:url value="/create/user" />">Create a User</a><br /><br />
        </security:authorize>

        <c:choose>
            <c:when test="${fn:length(AllUsers) == 0}">
                <i>There are no users in the system.</i>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>Username</th><th>Password</th><th>Roles</th><th>Action</th>
                    </tr>
                    <c:forEach items="${AllUsers}" var="user">
                        <tr>
                            <td>${user.username}</td><td>${user.password}</td>
                            <td>
                                <c:forEach items="${user.roles}" var="role" varStatus="status">
                                    <c:if test="${!status.first}">, </c:if>
                                    ${role.role}
                                </c:forEach>
                            </td>
                            <td>
                                <security:authorize access="hasRole('ADMIN') or hasRole('LECTURER')">  
                                [<a href="<c:url value="/create/user/delete?username=${user.username}" />">Delete</a>]
                                [<a href="<c:url value="/create/user/edit/${user.username}" />">Edit</a>]                               
                                </security:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
