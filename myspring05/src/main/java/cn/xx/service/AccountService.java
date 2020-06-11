package cn.xx.service;

import cn.xx.bean.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    int saveAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Integer id);

}
