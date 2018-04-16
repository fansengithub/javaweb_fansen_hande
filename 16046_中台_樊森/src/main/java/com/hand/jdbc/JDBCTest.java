package com.hand.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by fansen on 2017/8/15.
 */
public class JDBCTest {
    ///获取数据库连接子方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            ///注册mysql驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            ///获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
