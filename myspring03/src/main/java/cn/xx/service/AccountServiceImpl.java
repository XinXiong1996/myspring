package cn.xx.service;

import cn.xx.dao.AccountDao;
import cn.xx.dao.AccountDaoImpl;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    //如果是经常变化的数据，并不适合注入的方式
    private  String name;
    private Integer age;
    private Date birthday;


    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount执行了...."+name+","+age+","+birthday);
    }


}
