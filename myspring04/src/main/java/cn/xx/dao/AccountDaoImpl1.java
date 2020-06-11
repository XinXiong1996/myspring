package cn.xx.dao;


import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl1 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了账户11111");
    }
}
