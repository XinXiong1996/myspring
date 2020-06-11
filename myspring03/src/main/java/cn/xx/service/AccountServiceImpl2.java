package cn.xx.service;

import cn.xx.dao.AccountDao;
import cn.xx.dao.AccountDaoImpl;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {
    //如果是经常变化的数据，并不适合注入的方式
    private  String name;
    private Integer age;
    private Date birthday;
    private AccountDao accountDao;

    public void saveAccount() {
        System.out.println("service中的saveAccount执行了...."+name+","+age+","+birthday);
    }

    public void saveAccountDao(){
        accountDao.saveAccount();
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
