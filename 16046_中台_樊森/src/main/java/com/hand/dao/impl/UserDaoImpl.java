package com.hand.dao.impl;

import com.hand.dao.UserDao;
import com.hand.entity.Film;
import com.hand.entity.User;
import com.hand.jdbc.JDBCTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fansen on 2017/8/15.
 */
public class UserDaoImpl implements UserDao{
    public void save(Connection conn, User user) throws SQLException {
        PreparedStatement ps=conn.prepareCall("INSERT  INTO  customer(first_name) VALUES (?)");
        ///参数设置代码

        ps.setString(1,user.getFirst_name());
        ps.execute();
        ///保存到数据库表中
    }

    public ResultSet get(Connection conn, User user) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name = ?");
        ps.setString(1, user.getFirst_name());
        return ps.executeQuery();
    }

    public List<Film> findAll( ) throws SQLException {
        Connection connection=null;
        connection= JDBCTest.getConnection();
        List<Film> list=new ArrayList<Film>();
        PreparedStatement ps=connection.prepareStatement("SELECT f.film_id,f.title,f.description,l.`name` FROM film f,`language` l\n" +
                "WHERE f.language_id=l.language_id");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Film film1=new Film();

            film1.setFilmId(rs.getInt("film_id"));
            film1.setTitle(rs.getString("title"));
            film1.setDescrip(rs.getString("description"));
            film1.setLangug(rs.getString("name"));
            list.add(film1);
        }
        connection.close();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%5");
        return  list;

    }

    public void delete(Connection coon, int id) throws SQLException {
        PreparedStatement ps=coon.prepareStatement("DELETE * FROM film WHERE film_id=?");
        ps.setInt(1,id);
        ps.execute();
    }
}
