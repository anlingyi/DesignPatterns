package cn.xeblog.design.patterns.singleton.code;

/**
 * 双重校验锁懒汉式（线程安全，且多线程环境下可以保持高性能）
 *
 * @author anlingyi
 */
public class SingletonFour {

    /**
     * volatile是为了防止指令重排序
     */
    private static volatile SingletonFour instance;

    /**
     * 私有构造，防止外部new对象
     */
    private SingletonFour() {

    }

    /**
     * 通过静态方法获取对象实例
     *
     * @return
     */
    public static SingletonFour getInstance() {
        if (instance == null) {
            synchronized (SingletonFour.class) {
                if (instance == null) {
                    instance = new SingletonFour();
                }
            }
        }

        return instance;
    }

    public void say() {
        System.out.println("双重校验锁懒汉式（线程安全，且多线程环境下可以保持高性能）：Hello World!");
    }
}
