<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.njupt.service.MessageService" %>
<%@ page import="com.njupt.entity.Student" %>
<%@ page import="com.aliyuncs.exceptions.ClientException" %>
<%--
  Created by IntelliJ IDEA.
  User: 越
  Date: 2018/5/17
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理页面</title>
</head>
<body>
    <form style="float: left; width: 50%" action="<c:url value="/managerOp.html" />" method="post">
        <td>
            <input type="text" name="IdOrMacNum" value="请输入学号或刷卡进行查询"/>
            <input type="submit" value="确认">
        </td>
    </form>
    <form style="float: left; width: 50%" action="<c:url value="/queryAll.html" />" method="post">
        <td>
            <input type="submit" value="查询所有记录">
        </td>
    </form>

    <form  action="<c:url value="/addLostRecord.html" />" method="post">
        <td>
            <input type="text" name="macNum" value="添加丢失信息"/>
            <input type="submit" value="确认">
        </td>
    </form>

    <c:if test="${flag.equals('all')}">
        <c:forEach var="eachStudent" items="${students}">
            <form style="float: left;width: 50%">
                <td>${eachStudent.getName()}</td>
                <td>${eachStudent.getCollege()}</td>
                <td>${eachStudent.getUserId()}</td><br>
            </form>

                <form style="float: left;width:25%;" action="<c:url value="/sendMessage.html" />" method="post">
                    <input type="submit" value="发送短信">
                </form>
                <form style="float: left;width:25%;" action="<c:url value="/markToFind.html" />" method="post">
                    <input type="submit" value="标记已经找回">
                </form>

        </c:forEach>
    </c:if>

    <c:if test="${hasAdd.equals('Ok')}">
        <form style="float: left; width: 30%">Ok ${student.getUserId()} 已经被添加</form>
        <form style="float: left; width: 30%" >
            <input type="button" value="确定" onclick="set()">
            <script language="JavaScript" >
                function set() {
                    ${hasAdd = "No"};
                }
            </script>
        </form>
    </c:if>

    <c:if test="${single.equals('single')}">
        <form style="float: left; width: 20%" action="<c:url value="/sendMessage.html" />" method="post" >
            <td>${student.getName()}</td>
            <td>${student.getCollege()}</td>
            <td>${student.getMajor()}</td>
            <input type="submit" value="发送短信" >
        </form>
        <form style="float: left; width: 10%" action="<c:url value="/markToFind.html" />" method="post" >
            <input type="submit" value="标记已找回">
        </form>
    </c:if>

</body>
</html>
