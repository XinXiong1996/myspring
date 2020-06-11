package cn.xx.service;

import cn.xx.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
    private AccountDaoImpl accountDaoImpl;

    public AccountServiceImpl(){
        System.out.println("成功创建AccountService对象");
    }

    public void saveAccount() {
        accountDaoImpl.saveAccount();
    }
}
