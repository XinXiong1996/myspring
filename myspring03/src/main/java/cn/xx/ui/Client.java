package cn.xx.ui;

import cn.xx.dao.AccountDao;
import cn.xx.dao.AccountDaoImpl;
import cn.xx.service.AccountService;
import cn.xx.service.AccountServiceImpl;
import cn.xx.service.AccountServiceImpl2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Date;

public class Client {


    @SuppressWarnings("all")
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService)ac.getBean("accountService");
        AccountService as2=(AccountService)ac.getBean("accountService2");
//        AccountServiceImpl2 as2=(AccountServiceImpl2) ac.getBean("accountService2");//完成myspring01未能调用的as.saveAccount()方法
        AccountService as3=(AccountService)ac.getBean("accountService3");
        as.saveAccount();
        as2.saveAccount();
//        as2.saveAccountDao();
        as3.saveAccount();
    }

}
