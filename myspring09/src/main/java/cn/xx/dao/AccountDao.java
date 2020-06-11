package cn.xx.dao;

import cn.xx.bean.Account;

import java.util.List;

public interface AccountDao {
    Account findAccountById(Integer id);
    Account findAccountByName(String name);
    void updateAccount(Account account);
}
