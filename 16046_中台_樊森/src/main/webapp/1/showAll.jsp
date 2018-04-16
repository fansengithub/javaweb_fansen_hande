<%@ page import="com.hand.entity.Film" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>file列表展示页面</title>
    <script type="text/javascript" src="/js/jquery1.9.1.js"></script>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>
<form action="<%= request.getContextPath() %>/checkAllServlet" method="post" name="listForm">
    <% if (request.getAttribute("return_url") != null){%>
    <input type="hidden" name="return_url" value="<%= request.getAttribute("return_url")%>" />
    <%} %>
    <table align="center" width="650" border="1" height="180"
           bordercolor="white" bgcolor="" cellpadding="1" cellspacing="1">
        <tr bgcolor="white">
            <td align="center" colspan="9">
                <h2>film表单信息</h2>
                <a href="<%=request.getContextPath() %>/1/index1.jsp">功能选择页面</a>
            </td>
        </tr>
        <tr align="center" bgcolor="#e1ffc1">
            <td><b>film_id</b></td>
            <td><b>title</b></td>
            <td><b>description</b></td>
            <td><b>language</b></td>
            <td><b>delete_choice</b></td>
        </tr>

        <c:forEach items="${userList}" var="list">
            <tr>
                <td>${list.filmId}</td>
                <td>${list.title}</td>
                <td>${list.descrip}</td>
                <td>${list.langug}</td>
                <td  align="center" bgcolor="red">

                </td>
            </tr>

        </c:forEach>



    </table>
</form>

</body>
</html>
