package com.hand.service;

import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fansen on 2017/8/15.
 */
public class FindAllService {



    private UserDao userDao=new UserDaoImpl();
    List<Film> films=new ArrayList<Film>();

    public  List<Film> findAllFilms(){
        Connection connection = null;

        connection = ConnectionFactory.getInstance().makeConnection();
        try {
            films = userDao.findAll();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("事务回调");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return films;
    }
}
