package cn.xx;

import cn.xx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPtest {
    /**
     * 基于xml配置开发
     */
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as=ac.getBean("accountService",AccountService.class);
        as.saveAccount();
//        as.updateAccount(1);
//        as.deleteAccount();
    }

    /**
     * 基于注解开发
     * spring在调用最终通知和后置通知的顺序上是确实有问题的，这需要谨慎使用
     * 因此，尽可能地使用环绕注解，可以避免该问题的产生
     */
    @Test
    public void test02(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean2.xml");
        AccountService as=ac.getBean("accountService",AccountService.class);
        as.saveAccount();
    }
}
