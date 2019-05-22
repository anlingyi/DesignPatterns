package cn.xeblog.design.patterns.singleton.code;

/**
 * 懒汉式（线程不安全）
 *
 * @author anlingyi
 */
public class SingletonTwo {

    private static SingletonTwo instance;

    /**
     * 私有构造，防止外部new对象
     */
    private SingletonTwo() {

    }

    /**
     * 通过静态方法获取对象实例
     *
     * @return
     */
    public static SingletonTwo getInstance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }

        return instance;
    }

    public void say() {
        System.out.println("懒汉式（线程不安全）：Hello World!");
    }
}
