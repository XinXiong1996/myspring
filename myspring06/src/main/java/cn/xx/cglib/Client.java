package cn.xx.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();
        /**
         * 动态代理：
         *     特点：字节码随用随创建，随用随加载
         *     作用：不修改源代码的基础上对方法增强（与装饰设计模式的区别）
         *     分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         * #####################################################
         * 基于子类的动态代理：
         *     涉及的类：Enhancer
         *     提供者：第三方cglib库
         *  如何创建代理对象：
         *     使用Enhancer类中的create方法
         *  创建代理对象的要求：
         *     被代理类不能是最终类
         * create方法的参数：
         *     Class：字节码
         *       它是用于指定被代理对象的字节码
         *     InvocationHandler：用于提供增强的代码
         *       它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         *       此接口的实现类都是谁用谁写。
         *       我们一般写的都是该接口的子接口实现类，MethodInterceptor
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o 代理对象的引用
             * @param method  当前的执行方法
             * @param objects  当前执行方法所需的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return  和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Double money = (Double) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(1000);
    }
}
