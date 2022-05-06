<!DOCTYPE html>
<html>
    <head>
        <title>Customer Support</title>
    </head>
    <body>
        <h2>Create a Comment</h2>
        <form:form method="POST" enctype="multipart/form-data"
                   modelAttribute="ticketForm">
            <form:label path="subject">Write Comment</form:label><br />
            <form:textarea path="body" rows="5" cols="30" /><br /><br />
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html> 