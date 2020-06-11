package cn.xx.proxy;

public class Producer implements IProducer {

    public void saleProduct(double money) {
        System.out.println("销售成功一台电脑，售价为："+money);
    }
}
