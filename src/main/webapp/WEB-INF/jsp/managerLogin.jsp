<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Խ
  Date: 2018/5/11
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>����Ա����</title>
</head>
<body>
    <c:if test="${!empty wrongInfo}">
     <c:out value="${wrongInfo}"></c:out>
    </c:if>
    <div class="container">
        <form action="<c:url value="managerLogin.html"/>" method="post">
            ����Ա�˺�<input type="text" name="jobNumber"/><br>
            ����Ա����<input type="text" name="passWord"/><br>
            <input type="submit" value="�ύ"/>
            <input type="reset" value="����" />
        </form>
    </div>
</body>
</html>