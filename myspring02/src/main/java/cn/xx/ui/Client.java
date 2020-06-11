package cn.xx.ui;

import cn.xx.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService)ac.getBean("accountService");
        as.saveAccount();

        //手动关闭容器（多态）
        if(ac instanceof ClassPathXmlApplicationContext){
            ClassPathXmlApplicationContext ac2=(ClassPathXmlApplicationContext)ac;
            ac2.close();
        }
    }

}
