<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 越
  Date: 2018/5/11
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
    <c:if test="${!empty wrongInfo}">
     <c:out value="${wrongInfo}"></c:out>
    </c:if>
    <div class="container">
        <form action="<c:url value="managerLogin.html"/>" method="post">
            管理员账号<input type="text" name="jobNumber"/><br>
            管理员密码<input type="text" name="passWord"/><br>
            <input type="submit" value="提交"/>
            <input type="reset" value="重置" />
        </form>
    </div>
</body>
</html>