package com.qfedu.a_thread;


/**
 * 商品类
 */
class Goods {
    private String name;
    private double price;
    private boolean shouldProduct;

    public Goods() {
    }

    public Goods(String name, double price, boolean shouldProduct) {
        this.name = name;
        this.price = price;
        this.shouldProduct = shouldProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isShouldProduct() {
        return shouldProduct;
    }

    public void setShouldProduct(boolean shouldProduct) {
        this.shouldProduct = shouldProduct;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", shouldProduct=" + shouldProduct +
                '}';
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Goods goods;

    public Producer() {
    }

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (goods) {
                // 商品生产标记为true，表示这里需要生产过程
                if (goods.isShouldProduct()) {
                    // 生产过程完成
                    if (Math.random() > 0.5) {
                        goods.setName("煎饼果子");
                        goods.setPrice(3.2);
                    } else {
                        goods.setName("胡辣汤");
                        goods.setPrice(10);
                    }
                    System.out.println("生产者生产 : " + goods.getName()
                            + ":" + goods.getPrice());
                    goods.setShouldProduct(false);

                    // 唤醒消费者
                    goods.notify();

                } else {
                    // 进入阻塞状态
                    System.out.println("生产者嘚瑟中~~~");
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void test() {
        System.out.println(goods.hashCode());
    }
}

/**
 * 消费者
 */
class Customer implements Runnable {
    private Goods goods;

    public Customer() {
    }

    public Customer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (goods) {
                if (!goods.isShouldProduct()) {
                    // 购买过程完毕
                    System.out.println("消费者购买 : " + goods.getName()
                            + ":" + goods.getPrice());
                    goods.setShouldProduct(true);

                    // 唤醒生产者
                    goods.notify();
                } else {
                    // 消费者休眠
                    System.out.println("消费者嘚瑟中~~~");
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void test() {
        System.out.println(goods.hashCode());
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Goods goods = new Goods("小牛N1S", 7699, true);

        Producer producer = new Producer(goods);
        Customer customer = new Customer(goods);

        producer.test();
        customer.test();

        new Thread(producer).start();
        new Thread(customer).start();
    }
}
