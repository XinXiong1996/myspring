package cn.xx.test;

import cn.xx.bean.Account;
import cn.xx.dao.AccountDao;
import cn.xx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class test {

    /**
     * 基于xml
     */
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as=ac.getBean("accountService",AccountService.class);
        as.transfer("aaa","bbb",100f);
    }

    /**
     * 基于注解
     */
    @Test
    public void test02(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean2.xml");
        AccountService as=ac.getBean("accountService",AccountService.class);
        as.transfer("aaa","bbb",100f);
    }
}
