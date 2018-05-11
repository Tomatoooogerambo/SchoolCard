<%@page  contentType="text/html; charset=GBK" language="java" %>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
   <a href="/verifyCard.html">点击此处查看你的卡被找到了吗</a><br>
   <a href="/managerLogin.html">点击此处进入管理员界面</a>
</body>
</html>

