<%--
  Created by IntelliJ IDEA.
  User: iamal
  Date: 16.07.2024
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <jsp:include page="_bootstrap.jsp" />
    <jsp:include page="_header.jsp" />
    <div class="container text-center">
        <form action="/login" method="post">
            <div class="row align-items-center justify-content-center">
                <div class="col-2">
                    <label for="username">username</label>
                    <input type="text" class="form-control" id="username" value="${username}" autocomplete="off" name="username">
                </div>
                <div class="col-2">
                    <label for="password">password</label>
                    <input type="password" class="form-control" id="password" placeholder="password" autocomplete="off" name="password">
                </div>
            </div>
            <div class="row mt-2 align-items-center justify-content-center">
                <div class="col-4">
                    <button type="submit" class="btn btn-primary w-100">login</button>
                </div>
            </div>
        </form>
        <div class="row align-items-center justify-content-center">
            <div class="col">
                <h1>${message}</h1>
            </div>
        </div>
    </div>
</body>
</html>
