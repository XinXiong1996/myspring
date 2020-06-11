package cn.xx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含了开启事务、提交事务、回滚事务、释放连接
 */
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    public void beginTransction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            //还回连接池
            connectionUtils.getThreadConnection().close();
            //解绑
            connectionUtils.removeConnectioin();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
