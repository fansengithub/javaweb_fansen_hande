package com.hand.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by fansen on 2017/8/15.
 */
public class ConnectionFactory {
    private  static  String driver;
    private  static  String dburl;
    private  static  String  user;
    private  static  String  password;

    private  static  final ConnectionFactory factory=new ConnectionFactory();

    private Connection conn;  //保存数据库连接
    ///定义一个默认的构造函数
    private  ConnectionFactory(){

    }

    ///静态代码块，从属性文件中读取相关的配置信息
    static{
        ///保存属性文件中的键值对
        Properties prop =new Properties();
        try {
            ///获取属性文件中内容,将其读入到输入流中
            InputStream in=ConnectionFactory.class.getClassLoader()
                    .getResourceAsStream("dbconfig.properties");

            prop.load(in);   ///从输入流中读取键值对列表
        }catch (Exception e){
            System.out.println("配置文件读取错误");
        }

        ///将读取的键值对，赋值给定义的变量
        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");

    }

    ///获取connectionfactory 实例
    public  static  ConnectionFactory getInstance(){
        return  factory;
    }

    ///获取数据连接的方法
    public    Connection makeConnection(){
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(dburl,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  conn;
    }
}
