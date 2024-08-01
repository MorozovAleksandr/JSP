<%--
  Created by IntelliJ IDEA.
  User: iamal
  Date: 19.07.2024
  Time: 02:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>history</title>
</head>
<body>
    <jsp:include page="_bootstrap.jsp" />
    <jsp:include page="_header.jsp" />
    <jstl:forEach items="${operations}" var="operation">
        ${operation.num1}-${operation.num2}-${operation.type}-${operation.result}<br>
    </jstl:forEach>

</body>
</html>
