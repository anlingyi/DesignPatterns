package cn.xeblog.design.patterns.singleton.code;

/**
 * 枚举类饿汉式（防止反序列化）
 *
 * @author anlingyi
 */
public enum SingletonSix {
    INSTANCE;

    public void say() {
        System.out.println("枚举类饿汉式（防止反序列化）：Hello World!");
    }
}
