<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>登陆页面</title>

    <style type="text/css">
        body {
            color: orangered;
            font-size: 14px;
            margin: 20px auto;
        }
    </style>

</head>

<body>
<form action="<%= request.getContextPath() %>/checkServlet" method="post" name="LoginForm">

    <table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
        <tr>
            <td colspan="5" align="center" bgcolor="blue">用户登陆</td>
        </tr>
        <tr>
            <td>用户名(first_name)：</td>
            <td><input type="text" name="uname"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center" bgcolor="blue">
                <input type="submit" name="submit"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
