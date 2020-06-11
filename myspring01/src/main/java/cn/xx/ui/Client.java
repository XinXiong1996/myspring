package cn.xx.ui;

import cn.xx.dao.AccountDao;
import cn.xx.dao.AccountDaoImpl;
import cn.xx.service.AccountService;
import cn.xx.service.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    /**
     * 获取Spring的Ioc核心容器，并根据id获取对象
     * ApplicationContext的三个常用类
     * 1.ClassPathXmlApplicationContext:可以加载类路径下的配置文件，要求配置文件必须在类路径下（更常用）
     * 2.FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件，要求配置文件必须有访问权限
     * 3.AnnotationConfigApplicationContext：用于读取注解创建容器
     * 核心容器的两个接口引发出的问题
     * 1.ApplicationContext：   单例对象适合    通常采用此接口
     *      它在创建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取配置文件马上就创建配置文件中的配置对象
     * 2.BeanFactory：          多例对象适合
     *      它在创建核心容器时，创建对象采取的策略是采用延时加载的方式，也就是说，什么时候根据id获取对象了，什么时候才真正创建对象
     * @param args
     */

    @SuppressWarnings("all")
    public static void main(String[] args) {
        //1.获取Spring的Ioc核心容器,两种方法
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac =new FileSystemXmlApplicationContext("D:/ideaProjects/myspring/myspring01/src/main/resources/bean.xml");
        //2.根据id获取对象
        AccountService as = (AccountService)ac.getBean("accountService");//方法一
        AccountDao adao=ac.getBean("accountDao",AccountDao.class);//方法二
        System.out.println(as);
        System.out.println(adao);
        //还调用不了as.saveAccount()，因为在AccountServiceImpl中的AccountDaoImpl还为null,所以说只是削减耦合，不是消除耦合
//        as.saveAccount();


//        //BeanFacroty的使用
//        Resource resource=new ClassPathResource("bean.xml");
//        BeanFactory factory=new XmlBeanFactory(resource);
//        AccountService as=(AccountService)factory.getBean("accountService");
//        System.out.println(as);
    }

}
