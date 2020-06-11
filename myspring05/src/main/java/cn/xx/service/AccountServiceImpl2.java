package cn.xx.service;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService{
    @Resource(name = "accountDao2")
    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public int saveAccount(Account account) {
        return accountDao.saveAccount(account);
    }

    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    public int deleteAccount(Integer id) {
        return accountDao.deleteAccount(id);
    }
}
