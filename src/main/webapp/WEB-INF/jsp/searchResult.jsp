<%@ page import="com.njupt.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 越
  Date: 2018/5/4
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <c:if test="${flag.equals('all')}">
        <c:forEach var="eachStudent" items="${students}">
            <tr>
                <td>${eachStudent.getName()}</td>
                <td>${eachStudent.getCollege()}</td>
                <td>${eachStudent.getUserId()}</td><br>
            </tr>
        </c:forEach>
    </c:if>

    <c:if test="${flag.equals('single')}">
        <c:if test="${student.isLost() == false}">
            <td>对不起，暂未有卡号${student.getUserId()} 的相关信息</td>
        </c:if>

        <c:if test="${student.isLost() == true}">
            <td>${student.getName()}</td>
            <td>${student.getCollege()}</td>
            <td>${student.getUserId()}</td>目前已经被找到，请尽快领回
        </c:if>
    </c:if>


</head>
<body>

</body>
</html>
