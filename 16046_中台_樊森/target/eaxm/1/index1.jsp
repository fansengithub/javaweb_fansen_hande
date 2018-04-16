<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<body>
<form >
<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
    <tr>
        <td bgcolor="green">
            <h2>功能选择页面</h2>
        </td>
    </tr>
    <tr>
        <td>
            <a href="<%=request.getContextPath() %>/checkAllServlet">显示film列表信息</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="<%=request.getContextPath() %>/checkAllServlet">新增film列表信息</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="<%=request.getContextPath() %>/1/login.jsp">删除film列表信息</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="<%=request.getContextPath() %>/1/login.jsp">编辑film列表信息</a>
        </td>
    </tr>

</table>
</form>

</body>
</html>
