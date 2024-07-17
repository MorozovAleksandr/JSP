<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: iamal
  Date: 16.07.2024
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>home</title>
</head>
<body>
    <jsp:include page="_bootstrap.jsp" />
    <jsp:include page="_header.jsp" />
    <div class="container text-center">
         <form method="post" action="/calc">
            <div class="row align-items-center justify-content-center">
                <div class="col-2">
                    <label for="num1">num1</label>
                    <input type="number" name="num1" id="num1" class="form-control" value="${operation.num1}" autocomplete="off">
                </div>
                <div class="col-2">
                    <label for="num2">num2</label>
                    <input type="number" name="num2" id="num2" class="form-control" value="${operation.num2}" autocomplete="off">
                </div>
            </div>
            <div class="row mt-2 align-items-center justify-content-center">
                <div class="col-4">
                    <select class="form-select" name="type" id="type">
                        <option value="sum" selected="selected">+</option>
                        <option value="sub">-</option>
                        <option value="mul">*</option>
                        <option value="div">/</option>
                    </select>
                </div>
            </div>
            <div class="row mt-2 align-items-center justify-content-center">
                <div class="col-4">
                    <button type="submit" class="btn btn-primary w-100">Calculate</button>
                </div>
            </div>
            <div class="row align-items-center justify-content-center mt-2">
                <div class="col-4">
                    <h1>Result: <span id="result">${operation.result}</span></h1>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
