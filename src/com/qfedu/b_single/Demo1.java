package com.qfedu.b_single;

/**
 * 要求当前SingleDog类在整个Java程序中，有且只有一个类对象
 *
 * 问题1:
 *     目前创建SingleDog对象的方式非常方便，直接使用new关键字+构造方法就可以获取到
 *     一个SingleDog类对象，没有任何约束力，任何人都可以创建SingleDog类对象。
 *
 * 解决:
 *     私有化构造方法，让调用构造方法的过程不在这么简单
 *
 * 问题2:
 *     私有化构造方法，可以解决创建对象没有任何约束的问题，但是你也没没对象了啊？
 *
 * 分析:
 *     希望SingleDog类外可以有获取对象的方式
 *     构造方法私有化，类外不能使用，但是类内可以使用。
 *     希望类内创建一个对象，如何通过一个方法返回给类外
 *     方法：
 *          public 类外需要使用
 *          类外没有对象，无法使用普通成员方法，这里需要通过类名来调用方法
 *          static 修饰方法，使用类名直接调用
 *          SingleDog 类对象作为返回值类型
 *          getInstance
 *          public static SingleDog getInstance()
 *
 * 问题3:
 *      这里创建的对象依然是不同的对象。
 *
 * 分析:
 *      创建对象的过程，过于简单，没有任何的约束和判断。
 *      如果可以保存创建对象的首地址，当前首地址为null，调用创建对象过程，保存地址
 *      如果首地址不是null，证明存在当前对象，直接返回对应的地址。
 *
 *      这里需要一个东西来保存SingleDog类对象的空间首地址。
 *      成员变量
 *          目前该变量的使用位置是getInstance方法内，但是getInstance方法是一个static
 *          修饰的静态成员方法。不能直接使用成员变量。pass
 *      局部变量
 *          pass
 *          不具有持久性
 *      静态成员变量
 *          好的
 *          1. 具有持久性，
 *          2. 可以直接用于static修饰的成员方法
 *      private static SingleDog sd = null;
 *
 * 问题4：
 *      如果是多线程情况下，一定要考虑加锁，容易出现多线程情况下相互强制资源的过程
 *
 * 解决:
 *      同步代码块
 *      需要选择一个和当前类有关，并且唯一的类对象，作为锁对象。
 *      SingleDog.class 类锁
 */
class SingleDog {

    private static SingleDog sd = null;

    private SingleDog() {}

    public static SingleDog getInstance() {
        synchronized (SingleDog.class) {
            if (null == sd) {
                sd = new SingleDog();
            }
        }
        return sd;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        SingleDog singleDog1 = SingleDog.getInstance();
        SingleDog singleDog2 = SingleDog.getInstance();
        SingleDog singleDog3 = SingleDog.getInstance();
        SingleDog singleDog4 = SingleDog.getInstance();
        SingleDog singleDog5 = SingleDog.getInstance();
        SingleDog singleDog6 = SingleDog.getInstance();
        SingleDog singleDog7 = SingleDog.getInstance();
        SingleDog singleDog8 = SingleDog.getInstance();
        SingleDog singleDog9 = SingleDog.getInstance();

        // SingleDog对象就一个，你们任何人都不能创建单身狗

        System.out.println(singleDog1);
        System.out.println(singleDog2);
        System.out.println(singleDog3);
        System.out.println(singleDog4);
        System.out.println(singleDog5);
        System.out.println(singleDog6);
        System.out.println(singleDog7);
        System.out.println(singleDog8);
        System.out.println(singleDog9);
    }
}
