package cn.xx.test;

import cn.xx.bean.Account;
import cn.xx.service.AccountService;
import cn.xx.service.AccountServiceImpl2;
import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 彻底摆脱bean.xml文件
 */
public class AccountServiceTest3 {
    @Test
    public void testFindAll(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as=ac.getBean("accountService2",AccountService.class);
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as=ac.getBean("accountService2",AccountService.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account=new Account();
        account.setId(4);
        account.setMoney(1200f);
        account.setName("test");
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as=ac.getBean("accountService2",AccountService.class);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as=ac.getBean("accountService2",AccountService.class);
        Account account = as.findAccountById(3);
        account.setName("tset02");
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as=ac.getBean("accountService2",AccountService.class);
        as.deleteAccount(3);
    }
}
