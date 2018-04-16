package com.hand.servlet;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.hand.entity.Film;
import com.hand.service.FindAllService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FindAllServlet extends HttpServlet {

    Log log= LogFactory.getLog(getClass());
//            log.info("findallservlet:  start!");


    private FindAllService fas = new FindAllService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("findallservlet:  start!");

        List<Film> list=new ArrayList<Film>();
        list = fas.findAllFilms();
        System.out.println("开始------------");
        request.setAttribute("userList", list);
        request.getRequestDispatcher("/1/showAll.jsp").forward(request, response);
        System.out.println("-----结束");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
