package com.hand.dao;

import com.hand.entity.Film;
import com.hand.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fansen on 2017/8/15.
 */
public interface UserDao {
    ///测试，向数据库中保存数据
    public  void  save(Connection conn, User user)throws SQLException;
    ///从数据库中获取customer名称
    public ResultSet get(Connection conn, User user)throws SQLException;
    //从数据库中读取，file表中的内容
    public List<Film> findAll()throws SQLException;
    ///从数据库中删除选中的记录
    public  void delete(Connection coon, int id)throws SQLException;
}
