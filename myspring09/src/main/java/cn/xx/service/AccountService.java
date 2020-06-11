package cn.xx.service;

import cn.xx.bean.Account;

import java.util.List;

public interface AccountService {
    Account findAccountById(Integer id);
    void transfer(String sourceName, String targetName, Float money);
}
