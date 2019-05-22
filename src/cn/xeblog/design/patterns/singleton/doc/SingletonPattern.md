原文地址：[https://xeblog.cn/articles/16](https://xeblog.cn/articles/16)

## 单例模式的定义
> 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。

UML类图

![](https://oss.xeblog.cn/prod/e8909a73a422458083f3c8935f8e6963.png)

单例类的构造函数是 `private` 内部私有的，确保外部不能通过 `new` 的方式创建新对象，内部自行实例化，并对外提供一个访问该单一实例的静态的方法 `Instance()` 。

## 单例模式的实现

### 普通饿汉式

```Java
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
```

调用方式：
```Java
Singleton singleton = Singleton.getInstance();
singleton.say();
```

#### 优缺点
**优点：**类加载时就进行实例化，之后的操作效率会很高。    
**缺点：**由于类加载时就进行实例化，如果后续不对此类进行任何操作，就会导致内存的浪费。

### 线程不安全的懒汉式

```Java
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
        if(instance == null) {
            instance = new SingletonTwo();
        }

        return instance;
    }

    public void say() {
        System.out.println("懒汉式（线程不安全）：Hello World!");
    }
}
```

调用方式：
```Java
SingletonTwo singleton = SingletonTwo.getInstance();
singleton.say();
```

#### 优缺点
**优点：**在第一次调用的时候才进行实例化。    
**缺点：**当多个线程同时进入到 `if(instance == null) {...}` 时，会创建多个对象。

### 同步锁懒汉式

```Java
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
        if(instance == null) {
            instance = new SingletonThree();
        }

        return instance;
    }

    public void say() {
        System.out.println("同步锁懒汉式（线程安全，效率低）：Hello World!");
    }
}
```

调用方式：
```Java
SingletonThree singleton = SingletonThree.getInstance();
singleton.say();
```

#### 优缺点
**优点：**在第一次调用的时候才进行实例化，且线程安全。    
**缺点：**使用 `synchronized` 的方式对方法加锁，会影响效率。

### 双重校验锁懒汉式

```Java
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
        if(instance == null) {
            synchronized (SingletonFour.class) {
                if(instance == null) {
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
```

调用方式：
```Java
SingletonFour singleton = SingletonFour.getInstance();
singleton.say();
```

#### 优缺点
**优点：**在第一次调用的时候才进行实例化，且线程安全，效率较高。    
**缺点：**实现复杂，且 `volatile` 需要在JDK1.5之后的版本才能确保安全。

### 静态内部类懒汉式

```Java
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

```

调用方式：
```Java
SingletonFive singleton = SingletonFive.getInstance();
singleton.say();
```

#### 优缺点
**优点：**只有在调用 `getInstance()` 方法的时候，静态内部类才会被加载，从而对主类（我们需要的类）进行实例化，即线程安全，又效率高。    
**缺点：**多创建一个类。

### 枚举类饿汉式（防止反序列化）

```Java
/**
 * 枚举类饿汉式（防止反序列化）
 *
 * @author anlingyi
 */
public enum  SingletonSix {
    INSTANCE;

    public void say() {
        System.out.println("枚举类饿汉式（防止反序列化）：Hello World!");
    }
}
```

调用方式：
```Java
SingletonSix singleton = SingletonSix.INSTANCE;
singleton.say();
```

#### 优缺点
**优点：**实现简单，防止反序列化生成多个实例，且线程安全。    
**缺点：** `Enum` 需在JDK1.5之后版本使用。

##  单例模式的优缺点

### 优点
* 单例模式在内存中只有一个实例，减少了内存开支，尤其是频繁的创建和销毁实例。
* 由于只生成一个实例，所以减少了系统的性能开销。
* 避免对资源的多重占用，例如写文件操作。
* 单例模式可以在系统设置全局的访问点，优化和共享资源访问。

### 缺点
* 单例模式不易扩展，若要扩展，除了修改代码外别无他法。
* 单例模式对测试不利。
* 单例模式与单一职责原则有冲突，一个类应该只实现一个逻辑，而不用关心它是否是单例的。

## 资源
* [源码](https://github.com/anlingyi/DesignPatterns/tree/master/src/cn/xeblog/design/patterns/singleton)

## 参考
* 《设计模式之禅》