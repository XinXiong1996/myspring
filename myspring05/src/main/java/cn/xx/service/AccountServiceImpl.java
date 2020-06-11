package cn.xx.service;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public int saveAccount(Account account) {
        return accountDao.saveAccount(account);
    }

    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    public int deleteAccount(Integer id) {
        return accountDao.deleteAccount(id);
    }
}
