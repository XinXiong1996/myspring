package cn.xx;

import cn.xx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as=ac.getBean("accountService",AccountService.class);
//        as.transfer("bbb","aaa",100f);
        System.out.println(as.findAllAccount());

    }
}
