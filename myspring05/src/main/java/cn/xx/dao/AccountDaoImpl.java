package cn.xx.dao;

import cn.xx.bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return runner.query("select * from account where id= ?",new BeanHandler<Account>(Account.class),id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public int saveAccount(Account account) {
        try {
            return runner.update("insert into account(name,money) values (?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public int updateAccount(Account account) {
        try {
            return runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public int deleteAccount(Integer id) {
        try {
            return runner.update("delete from account where id=?",id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
