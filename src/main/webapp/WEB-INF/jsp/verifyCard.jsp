<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 越
  Date: 2018/5/3
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校园卡丢失查询页面</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="#a52a2a"><c:out value="${error}" /></font>
</c:if>
<form style="float: left; width: 40%" action="<c:url value="verifyCard.html" />" method="post">
    <input type="text" name="macNumber" />
    <input type="submit" value="查询" />
    <input type="reset" value="重置" />
</form>

<form style="float: left; width: 20%" action="<c:url value="requestForAll.html" />" method="post">
    <input type="submit" value="查看目前所有已丢失的校园卡记录" />
</form>

</body>
</html>
