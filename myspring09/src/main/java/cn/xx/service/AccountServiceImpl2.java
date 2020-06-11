package cn.xx.service;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型事务
public class AccountServiceImpl2 implements AccountService{
    @Autowired
    private AccountDao accountDao;

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = false)//需要的是读写型事务
    public void transfer(String sourceName, String targetName, Float money) {
        Account source=accountDao.findAccountByName(sourceName);
        Account target=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
//        用于测试是否开启事务
//        int num=1/0;
        accountDao.updateAccount(target);
    }
}
