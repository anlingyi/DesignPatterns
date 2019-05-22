package cn.xeblog.design.patterns.singleton.code;

/**
 * 普通饿汉式
 *
 * @author anlingyi
 */
public class Singleton {

    /**
     * 类加载时进行实例化对象
     */
    private static final Singleton SINGLETON = new Singleton();

    /**
     * 私有构造，防止外部new对象
     */
    private Singleton() {

    }

    /**
     * 通过静态方法获取对象实例
     *
     * @return
     */
    public static Singleton getInstance() {
        return SINGLETON;
    }

    public void say() {
        System.out.println("普通饿汉式：Hello World!");
    }

}
