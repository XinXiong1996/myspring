package cn.xx.service;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;
import cn.xx.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 最终版：通过动态代理来实现
 */
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

//    @Autowired
//    private TransactionManager txManager;

    public List<Account> findAllAccount() {
//        try {
//            //1.开始事务
//            txManager.beginTransction();
//            //2.执行操作
//            List<Account> accounts = accountDao.findAllAccount();
//            //3.提交事务
//            txManager.commit();
//            //4.返回结果
//            return accounts;
//        }catch (Exception e){
//            //5.回滚操作
//            txManager.rollback();
//            throw new RuntimeException(e);
//        }finally {
//            //6.释放连接
//            txManager.release();
//        }
        List<Account> accounts = accountDao.findAllAccount();
        return accounts;
    }


    public Account findAccountById(Integer id) {
//        try {
//            //1.开始事务
//            txManager.beginTransction();
//            //2.执行操作
//            Account account =accountDao.findAccountById(id);
//            //3.提交事务
//            txManager.commit();
//            //4.返回结果
//            return account;
//        }catch (Exception e){
//            //5.回滚操作
//            txManager.rollback();
//            throw new RuntimeException(e);
//        }finally {
//            //6.释放连接
//            txManager.release();
//        }
        Account account =accountDao.findAccountById(id);
        return account;
    }

    public void saveAccount(Account account) {
//        try {
//            //1.开始事务
//            txManager.beginTransction();
//            //2.执行操作
//            accountDao.saveAccount(account);
//            //3.提交事务
//            txManager.commit();
//        }catch (Exception e){
//            //5.回滚操作
//            txManager.rollback();
//        }finally {
//            //6.释放连接
//            txManager.release();
//        }
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
//        try {
//            //1.开始事务
//            txManager.beginTransction();
//            //2.执行操作
//            accountDao.updateAccount(account);
//            //3.提交事务
//            txManager.commit();
//        }catch (Exception e){
//            //5.回滚操作
//            txManager.rollback();
//        }finally {
//            //6.释放连接
//            txManager.release();
//        }
        accountDao.updateAccount(account);
    }

    public void  deleteAccount(Integer id) {
//        try {
//            //1.开始事务
//            txManager.beginTransction();
//            //2.执行操作
//            accountDao.deleteAccount(id);
//            //3.提交事务
//        }catch (Exception e){
//            //5.回滚操作
//            txManager.rollback();
//        }finally {
//            //6.释放连接
//            txManager.release();
//        }
        accountDao.deleteAccount(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
//        try {
//            //1.开始事务
//            txManager.beginTransction();
//            //2.执行操作
//            Account source=accountDao.findAccountByName(sourceName);
//            Account target=accountDao.findAccountByName(targetName);
//            source.setMoney(source.getMoney()-money);
//            target.setMoney(target.getMoney()+money);
//            accountDao.updateAccount(source);
//            accountDao.updateAccount(target);
//            //3.提交事务
//            txManager.commit();
//        }catch (Exception e){
//            //5.回滚操作
//            txManager.rollback();
//            e.printStackTrace();
//        }finally {
//            //6.释放连接
//            txManager.release();
//        }
        Account source=accountDao.findAccountByName(sourceName);
        Account target=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
//        int num=1/0;
        accountDao.updateAccount(target);
    }
}
