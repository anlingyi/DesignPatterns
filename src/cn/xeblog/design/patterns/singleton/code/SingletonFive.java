package cn.xeblog.design.patterns.singleton.code;

/**
 * 静态内部类懒汉式
 *
 * @author anlingyi
 */
public class SingletonFive {

    /**
     * 私有构造，防止外部new对象
     */
    private SingletonFive() {

    }

    /**
     * 通过静态方法获取对象实例
     *
     * @return
     */
    public static SingletonFive getInstance() {
        return Singleton.SINGLETON;
    }

    public void say() {
        System.out.println("静态内部类懒汉式：Hello World!");
    }

    /**
     * 静态内部类实例化对象
     */
    private static class Singleton {
        /**
         * 类加载时进行实例化对象
         */
        private static final SingletonFive SINGLETON = new SingletonFive();
    }
}
