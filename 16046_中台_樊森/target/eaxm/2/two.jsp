<%--
  Created by IntelliJ IDEA.
  User: fansen
  Date: 2017/10/27
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.hand.entity.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name","孤傲苍狼");
%>
使用EL表达式获取数据：${name}
<br>
<br>
<br>
<%
    Person p = new Person();
    p.setAge(12);
    request.setAttribute("person",p);
%>
使用el表达式可以获取bean的属性：${person.age}
<hr>
</body>
</html>
