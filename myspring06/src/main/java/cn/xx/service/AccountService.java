package cn.xx.service;

import cn.xx.bean.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);
    void transfer(String sourceName,String targetName,Float money);
}
