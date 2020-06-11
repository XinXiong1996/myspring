package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类：它的作用和bean.xml是一样的
 * spring的新注解
 * Configuration：
 *           作用：指定当前类是一个配置类
 *           细节：当配置类作为AnnotationConfigApplicationContext对象创建的对象时，该注解可以不写
 *ComponentScan:
 *           作用：用于通过注解指定spring创建容器时要扫描的包
 *           属性：
 *               value(basePackages)：都是用于指定创建容器时要扫描的包
 *                                    我们使用此注解就等同于在xml配置文件中配置了：
 *                                    <context:component-scan base-package="cn.xx"/>
 *               @ComponentScan("cn.xx") = @ComponentScan(basePackages = "cn.xx") = @ComponentScan(basePackages = {"cn.xx"}) = @ComponentScan(value ="cn.xx" )
 * Bean：
 *    作用：用于把当前方法的返回值作用bean对象存入spring的ioc容器中
 *    属性：
 *       name：用于指定bean的id。当不写时，默认值是当前方法的名称
 *    细节：
 *       当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *       查找的方式和Autowired注解的作用是一样的
 * Import：
 *     作用：用于导入其他的配置类
 *     属性：
 *       value：用于指定其他配置类的字节码
 *                 当我们使用Import的注解之后，有Import注解的类就为父配置类，而导入的都是子配置类
 *PropertySource：
 *     作用：用于指定properties文件的位置
 *     属性：
 *        value：指定文件的名称和路径
 *                 关键字：classpath，表示类路径的位置
 */

//方法一：
//@Configuration
//@ComponentScan("cn.xx")
//public class SpringConfiguration {
//
//    /**
//     * 用于创建一个QueryRunner对象
//     * @param dataSource
//     * @return
//     */
//    @Bean(name = "runner")
//    @Scope("prototype")
//    public QueryRunner createQueryRunner(DataSource dataSource){
//        return new QueryRunner(dataSource);
//    }
//
//    /**
//     * 用于创建数据源对象
//     * @return
//     */
//    @Bean(name="dataSource")
//    public DataSource createDataSource(){
//        try {
//            ComboPooledDataSource ds=new ComboPooledDataSource();
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//            ds.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis");
//            ds.setUser("root");
//            ds.setPassword("root");
//            return ds;
//        } catch (Exception e) {
//           throw new RuntimeException();
//        }
//    }
//}


//方法二
@ComponentScan("cn.xx")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration{

}