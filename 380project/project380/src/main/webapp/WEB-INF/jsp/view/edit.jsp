<!DOCTYPE html>
<html>
<head><title>Customer Support</title></head>
<body>
<h2>Create a User</h2>
      <form:form method="POST" enctype="multipart/form-data" modelAttribute="userForm">
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
                <form:checkbox path="roles" value="ROLE_LECTURER" />Lecturer

            <br /><br />
            <input type="submit" value="Edit User"/>
        </form:form>
</body>
</html>