<!DOCTYPE html>
<html>
    <head>
        <script>
            function show() {
                var name = document.getElementById('fileInput');
                console.log(name.files.item(0).name);
                document.getElementById("label").innerHTML = name.files.item(0).name + " has uploaded";
            }
            ;
            //            $(".fileInput").on("change", function (e) {
            //                document.getElementById("label").innerHTML = e.target.files[0].name + " has uploaded";
            //            })

        </script>
        <style>
            .file-area {
                width: 100%;
                position: relative;
                font-size: 18px;
            }
            .file-area input[type=file] {
                position: absolute;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                opacity: 0;
                cursor: pointer;
            }
            .file-area .file-dummy {
                width: 100%;
                padding: 50px 30px;
                border: 2px dashed #ccc;
                background-color: #fff;
                text-align: center;
                transition: background 0.3s ease-in-out;
            }
            .file-area .file-dummy .success {
                display: none;
            }
            .file-area:hover .file-dummy {
                border: 2px dashed #1abc9c;
            }
            .file-area input[type=file]:valid + .file-dummy {
                border-color: #1abc9c;
            }
            .file-area input[type=file]:valid + .file-dummy .success {
                display: inline-block;
            }
            .file-area input[type=file]:valid + .file-dummy .default {
                display: none;
            }
        </style>
        <title>Customer Support</title>
    </head>
    <body>
        <h2>Lecture #${lecture.lectureID}</h2>
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="lectureForm"> 
            <form:label path="title">Title</form:label><br/>
            <form:input type="text" path="title" disable = "true" /><br/><br/>
            <form:label path="courseId">Course ID</form:label><br/>
            <form:input type = "text" path="courseId" disable = "true"/><br/><br/>
            <c:if test="${fn:length(lecture.material) > 0}">
                <b>Materials:</b><br/>
                <ul>
                    <c:forEach items="${lecture.material}" var="material">
                        <li>
                            <c:out value="${material.name}" />
                            [<a href="<c:url
                                    value="/course/view/${lecture.lectureID}/delete/${material.name}"
                                    />">Delete</a>]
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
            <b>Add Material</b><br />
<!--            <input type="file" name="materials" multiple="multiple"/><br/><br/>
            <input type="submit" value="Save"/><br/><br/>-->
            <div class="file-area" >
                <input type="file" name="materials" multiple="multiple" id = "fileInput" onchange="show()"/><br /><br />
                <div class="file-dummy">
                    <span >Click to select a file, or drag it here</span>
                </div>
                <label id="label">  </label><br/>
            </div>
        <input type="submit" value="Submit"/>

        </form:form>
        <a href="<c:url value="/course" />">Return to Course Page</a>
    </body>
</html> 