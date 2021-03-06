package cn.xx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> t1=new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先从ThreadLocal上获取
        Connection conn=t1.get();
        //2.判断当前线程上是否有连接
        try {
            if(conn==null){
                //3.从数据源上获取一个连接，并存入ThreadLocal中
                conn=dataSource.getConnection();
                t1.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 将连接和线程解绑
     */
    public void removeConnectioin(){
        t1.remove();
    }
}
