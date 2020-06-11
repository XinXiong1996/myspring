package cn.xx.factory;

import cn.xx.service.AccountService;
import cn.xx.service.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
