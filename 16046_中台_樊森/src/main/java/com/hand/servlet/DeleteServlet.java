package com.hand.servlet;

import com.hand.service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fansen on 2017/8/15.
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private DeleteService ds=new DeleteService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        ds.delete(id);
        response.sendRedirect("checkAllServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
