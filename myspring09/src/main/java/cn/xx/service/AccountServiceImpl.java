package cn.xx.service;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;

import java.util.List;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account source=accountDao.findAccountByName(sourceName);
        Account target=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
//        用于测试是否开启事务
        int num=1/0;
        accountDao.updateAccount(target);
    }
}
