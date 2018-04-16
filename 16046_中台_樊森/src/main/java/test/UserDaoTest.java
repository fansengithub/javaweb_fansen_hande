package test;

import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.entity.User;
import com.hand.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by fansen on 2017/8/15.
 */
public class UserDaoTest {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            UserDao userDao = new UserDaoImpl();

            ///save方法测试
            User tom = new User();
            tom.setFirst_name("wwwwwwwwww");
            userDao.save(conn, tom);
            System.out.println("=========保存完毕=========");

            conn.commit();
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
