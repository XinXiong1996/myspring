package cn.xx.dao;


import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了账户22222");
    }
}
