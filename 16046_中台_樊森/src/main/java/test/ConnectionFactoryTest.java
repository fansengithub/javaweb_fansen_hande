package test;

import com.hand.util.ConnectionFactory;

import java.sql.Connection;

/**
 * Created by fansen on 2017/8/15.
 */
public class ConnectionFactoryTest {
    public static void main(String[] args)  throws  Exception{
        ///获取实例
        ConnectionFactory cf= ConnectionFactory.getInstance() ;
        ///获取数据库连接
        Connection conn=cf.makeConnection();
        ///打印一个connection对象的属性
        System.out.println(conn.getAutoCommit());
    }
}
