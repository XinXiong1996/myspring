package cn.xx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含了开启事务、提交事务、回滚事务、释放连接
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

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

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    public Object aroundtxmanager(ProceedingJoinPoint pjp){
        Object result=null;
        try {
            this.beginTransction();
            Object[] args=pjp.getArgs();//得到方法执行所需的参数
            result=pjp.proceed(args);//明确调用切入点方法
            //根据写的位置，决定是什么通知，例如，现在就为后置通知
            this.commit();
            return result;
        } catch (Throwable throwable) {
            this.rollback();
            throw new RuntimeException();
        }finally {
            this.release();
        }
    }
}
