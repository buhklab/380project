<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registry</title>
    </head>
    <h1>Sign up</h1><body>
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="user">
            <form:label path="username">Username</form:label><br/>
            <form:input type="text" path="username" /><br/><br/>
            <form:label path="password">Password</form:label><br/>
            <form:input type="text" path="password" /><br/><br/>
            <form:label path="fullname">Fullname</form:label><br/>
            <form:input type="text" path="fullname" /><br/><br/>
            <form:label path="phonenbr">Phone</form:label><br/>
            <form:input type="text" path="phonenbr" /><br/><br/>
            <form:label path="address">Address</form:label><br/>
            <form:input type="text" path="address" /><br/><br/>
            <form:label path="roles">Roles</form:label><br/>
            <form:checkbox path="roles" value="ROLE_STUDENT" checked = "true" />Student
            <security:authorize access="hasRole('ADMIN')">    
                <form:checkbox path="roles" value="ROLE_ADMIN" />Lecturer
            </security:authorize>
            <br /><br />
            <input type="submit" value="Create User"/>
        </form:form>

    </body>
</html>