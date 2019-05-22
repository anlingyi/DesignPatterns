package cn.xeblog.design.patterns.singleton.code;

/**
 * 测试单例模式
 *
 * @author anlingyi
 */
public class Client {

    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
        testFour();
        testFive();
        testSix();
    }

    /**
     * 普通饿汉式
     */
    private static void testOne() {
        Singleton singleton = Singleton.getInstance();
        singleton.say();
    }

    /**
     * 懒汉式（线程不安全）
     */
    private static void testTwo() {
        SingletonTwo singleton = SingletonTwo.getInstance();
        singleton.say();
    }

    /**
     * 同步锁懒汉式（线程安全，效率低）
     */
    private static void testThree() {
        SingletonThree singleton = SingletonThree.getInstance();
        singleton.say();
    }

    /**
     * 双重校验锁懒汉式（线程安全，且多线程环境下可以保持高性能）
     */
    private static void testFour() {
        SingletonFour singleton = SingletonFour.getInstance();
        singleton.say();
    }

    /**
     * 静态内部类懒汉式
     */
    private static void testFive() {
        SingletonFive singleton = SingletonFive.getInstance();
        singleton.say();
    }

    /**
     * 枚举类饿汉式
     */
    private static void testSix() {
        SingletonSix singleton = SingletonSix.INSTANCE;
        singleton.say();
    }

}
