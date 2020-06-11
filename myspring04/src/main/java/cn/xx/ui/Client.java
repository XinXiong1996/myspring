package cn.xx.ui;

import cn.xx.dao.AccountDao;
import cn.xx.service.AccountService;
import cn.xx.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {


    @SuppressWarnings("all")
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService)ac.getBean("accountService");
        AccountService as2 = (AccountService)ac.getBean("accountService");
//        AccountServiceImpl as=ac.getBean("accountService",AccountServiceImpl.class);
        as.saveAccount();
//        as.agePrint();
        System.out.println(as==as2);
    }

}
