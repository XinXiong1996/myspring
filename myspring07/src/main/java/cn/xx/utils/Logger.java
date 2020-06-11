package cn.xx.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共代码
 */
public class Logger {
    /**
     * 前置通知，用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void beforeprintLog(){
        System.out.println("前置通知：Logger类中的printLog方法开始记录日志了 ....");
    }

    /**
     * 后置通知
     */
    public void afterReturnprintLog(){
        System.out.println("后置通知：Logger类中的fterReturnprintLog方法开始记录日志了 ....");
    }

    /**
     * 异常通知
     */
    public void afterThrowingprintLog(){
        System.out.println("异常通知：Logger类中的fterReturnprintLog方法开始记录日志了 ....");
    }

    /**
     * 最终通知
     */
    public void afterprintLog(){
        System.out.println("最终通知：Logger类中的afterprintLog方法开始记录日志了 ....");
    }

    /**
     * 环绕通知（整个的invoke方法在执行就是环绕通知）
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      Spring框架为我们提供了一个接口： ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数。在程序执行时，Spring框架会为我们提供该接口的实现类，供我们使用。
     * spring的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    public Object aroundprintLog(ProceedingJoinPoint pjp){
        Object result=null;
        try {
            Object[] args=pjp.getArgs();//得到方法执行所需的参数
            pjp.proceed(args);//明确调用切入点方法
            //根据写的位置，决定是什么通知，例如，现在就为后置通知
            System.out.println("环绕通知：Logger类中的aroundprintLog方法开始记录日志了 ....");
            return result;
        } catch (Throwable throwable) {//Exception拦不住，只能Throwable
            throw new RuntimeException();
        }finally {

        }
    }
}
