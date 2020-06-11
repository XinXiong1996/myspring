package cn.xx.test;

import cn.xx.bean.Account;
import cn.xx.service.AccountService;
import cn.xx.service.AccountServiceImpl2;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 解决重复代码的问题
 * 使用junit单元测试，测试我们的配置
 * Spring整合junit的配置
 *       1.导入spring整合junit的jar（坐标）
 *       2.使用junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *          @RunWith
 *       3.告知spring的运行器，spring的ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                classes：指定注解类所在的位置
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 *   spring的版本一般需要和spring-test的版本相对应
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:bean2.xml")
public class AccountServiceTest4 {
    @Autowired
//    @Resource(name = "accountService2")
    private AccountServiceImpl2 as;

//    private ApplicationContext ac;
//    private AccountService as;
//
//    @Before
//    public void init(){
//        ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        as=ac.getBean("accountService2",AccountService.class);
//    }

    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account=new Account();
        account.setId(4);
        account.setMoney(1200f);
        account.setName("test");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        Account account = as.findAccountById(3);
        account.setName("tset02");
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(3);
    }
}
