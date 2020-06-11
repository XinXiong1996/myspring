package cn.xx.dao;

import cn.xx.bean.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    int saveAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Integer id);
}
