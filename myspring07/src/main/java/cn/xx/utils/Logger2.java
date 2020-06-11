package cn.xx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@SuppressWarnings("all")
@Component("logger2")
@Aspect//表示当前类是一个切面类
public class Logger2 {
    @Pointcut("execution(* cn.xx.service.impl.*.*(..))")
    private void pt1(){
    }

    @Before("pt1()")
    public void beforeprintLog(){
        System.out.println("前置通知：Logger类中的printLog方法开始记录日志了 ....");
    }

    @AfterReturning("pt1()")
    public void afterReturnprintLog(){
        System.out.println("后置通知：Logger类中的fterReturnprintLog方法开始记录日志了 ....");
    }

    @AfterThrowing("pt1()")
    public void afterThrowingprintLog(){
        System.out.println("异常通知：Logger类中的fterReturnprintLog方法开始记录日志了 ....");
    }

    @After("pt1()")
    public void afterprintLog(){
        System.out.println("最终通知：Logger类中的afterprintLog方法开始记录日志了 ....");
    }

//    @Around("pt1()")
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
