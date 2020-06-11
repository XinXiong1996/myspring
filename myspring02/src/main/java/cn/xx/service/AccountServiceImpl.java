package cn.xx.service;

public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl(){
        System.out.println("成功创建AccountService对象");
    }

    public void saveAccount() {
        System.out.println("service中的saceAccount执行了");
    }

    public void init(){
        System.out.println("对象初始化");
    }

    public void destroy(){
        System.out.println("对象销毁");
    }
}
