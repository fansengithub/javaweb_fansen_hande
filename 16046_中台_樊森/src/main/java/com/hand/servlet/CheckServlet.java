package com.hand.servlet;

import com.hand.entity.User;
import com.hand.service.CheckUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CheckServlet extends HttpServlet {
    private CheckUserService cku = new CheckUserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得参数username的值,用户名和密码信息
        String uname = request.getParameter("uname");

        System.out.println("用户 first_name  ==》 " + uname);

        RequestDispatcher rd=null;
        String forward = null;
        if (uname == null ) {
            request.setAttribute("msg", "用户名为空");
            rd = request.getRequestDispatcher("/1/error.jsp");
            rd.forward(request, response);
        } else {
            ///如果登陆合法，进行登陆校验
            User user = new User();
            user.setFirst_name(uname);

            boolean bool = cku.check(user);

            if (bool) {
                forward = "/1/success.jsp";
            } else {
                request.setAttribute("msg","用户名错误，登陆失败");
                forward = "/1/error.jsp";
            }

            ///重定向
            rd = request.getRequestDispatcher(forward);
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
