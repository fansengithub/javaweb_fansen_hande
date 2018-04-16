package com.hand.service;

import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by fansen on 2017/8/15.
 */
public class DeleteService {
    private UserDao userDao=new UserDaoImpl();

    //执行删除过程
    public  void  delete(int id){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            //
             userDao.delete(conn,id);

        } catch (SQLException e2) {  //异常处理代码块
            e2.printStackTrace();
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
    }
}
