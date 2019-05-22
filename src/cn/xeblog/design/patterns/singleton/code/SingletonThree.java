package cn.xeblog.design.patterns.singleton.code;

/**
 * 同步锁懒汉式（线程安全，效率低）
 *
 * @author anlingyi
 */
public class SingletonThree {

    private static SingletonThree instance;

    /**
     * 私有构造，防止外部new对象
     */
    private SingletonThree() {

    }

    /**
     * 通过静态方法获取对象实例
     *
     * @return
     */
    public static synchronized SingletonThree getInstance() {
        if (instance == null) {
            instance = new SingletonThree();
        }

        return instance;
    }

    public void say() {
        System.out.println("同步锁懒汉式（线程安全，效率低）：Hello World!");
    }
}
