package cn.xx.service;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;

import java.util.List;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        List<Account> accounts = accountDao.findAllAccount();
        return accounts;
    }


    public Account findAccountById(Integer id) {
        Account account =accountDao.findAccountById(id);
        return account;
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void  deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account source=accountDao.findAccountByName(sourceName);
        Account target=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
//        int num=1/0;
        accountDao.updateAccount(target);
    }
}
