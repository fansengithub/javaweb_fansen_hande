package com.hand.service;

import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.entity.User;
import com.hand.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fansen on 2017/8/15.
 */
public class CheckUserService {
    private UserDao userDao = new UserDaoImpl();

    ///执行，登陆校验的逻辑过程
    public boolean check(User user) {

        Connection conn = null;
        try {
            ///通过连接工厂类，获取数据库连接
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);  ///关闭自动提交

            //根据传入的参数，查询数据库中的信息
            ResultSet resultSet = userDao.get(conn, user);
            ///如果数据库中存在，该数据信息，则返回   true
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {  //异常处理代码块
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();   ///关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
