## 引言

"呼～噜～ 吱吱吱～"

窗外边的大树上的知了声勉勉强强的盖过了包先生的呼噜声，包先生被大自然的闹钟给吵醒。

睡了一大早的包先生，简简单单的收拾了一下自己。

550ml的保温杯早已被20度的白开水灌满。

"前方到达目的地附近～" 

包先生来到了工地，先是顺时针观望了一圈，后又逆时针的来了个"回首掏"。

虽只过了20分钟，包先生的脸上早已是大雨倾盆。

"哎哟喂，张三摸鱼又被抓了唉！"

"李四你小心点啊"

工友们敢怒不敢言。

包先生擦了擦汗，打开了随身携带的保温杯，微抿一口，似乎有些许烫嘴。

"唉，这日子，什么时候是个头啊！" 包先生唉声叹气，忧郁的眼神充满了渴望。

（本故事纯属瞎掰）

## 观察者模式

### 定义

定义对象间的一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。

### 通用类图

![观察者模式通用类图.png](https://oss.xeblog.cn/prod/9b2713a346524fe280df2f18df8a0c4d.png)

#### Subject 被观察者
定义被观察者必须实现的职责，能够动态的增加、删除观察者和通知观察者。

#### Observer 观察者
观察者在接收到通知后会执行update方法，对接收到的消息进行处理。
所以它只需要实现update方法里的处理逻辑就行。

#### ConcreteSubject 具体的被观察者
定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知。

#### ConcreteObserver 具体的观察者
实现自己的消息处理逻辑。

### 包工头的救赎

运用观察者模式，解放包工头。

**抽象出被观察者**

```java
/**
 * 被观察者
 *
 * @author anlingyi
 * @date 2021/4/10 11:23 上午
 */
public abstract class Observable {

    /**
     * 观察者列表
     */
    private Vector<Observer> obs = new Vector<>();

    /**
     * 添加观察者
     * @param observer
     */
    public void addObserver(Observer observer) {
        if (obs.contains(observer)) {
            return;
        }

        obs.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    public void removeObserver(Observer observer) {
        obs.remove(observer);
    }

    /**
     * 通知观察者
     * @param msg
     */
    public void notifyObservers(String msg) {
        for (Observer observer : obs) {
            observer.update(this, msg);
        }
    }

    /**
     * 被观察者的名字
     *
     * @return
     */
    public abstract String getName();

}
```

**定义被观察者对象**

搬砖工：张三

```java
/**
 * 被观察者：张三
 *
 * @author anlingyi
 * @date 2021/4/10 11:42 上午
 */
public class ZhangSan extends Observable {

    @Override
    public String getName() {
        return "张三";
    }

    public void moFish() {
        System.out.println("摸会鱼");
        notifyObservers("摸鱼中...[懂得都懂]");
    }

    public void movingBricks() {
        System.out.println("搬会砖");
        notifyObservers("搬砖中...[cv大法]");
    }

    public void chat() {
        System.out.println("聊会天");
        notifyObservers("闲聊中...[不可描述]");
    }

}
```

搬砖工：李四

```java
/**
 * 被观察者：李四
 *
 * @author anlingyi
 * @date 2021/4/10 11:42 上午
 */
public class LiSi extends Observable {

    @Override
    public String getName() {
        return "李四";
    }

    public void music() {
        System.out.println("听会歌");
        notifyObservers("听网抑云...[生而为人，我很抱歉]");
    }

    public void bilibili() {
        System.out.println("逛逛二次元");
        notifyObservers("逛B站...[发生肾么事了]");
    }

    public void movingBricks() {
        System.out.println("这道题我不会");
        notifyObservers("百度中...[java.lang.OutOfMemoryError: Java heap space]");
    }

}
```

**抽象出观察者**

```java
/**
 * 观察者
 *
 * @author anlingyi
 * @date 2021/4/10 11:20 上午
 */
public interface Observer {

    void update(Observable observable, String msg);

}
```

**定义观察者对象**

```java
/**
 * 包工头
 *
 * @author anlingyi
 * @date 2021/4/10 11:37 上午
 */
public class Foreman implements Observer {

    @Override
    public void update(Observable observable, String msg) {
        System.out.println("[包工头牌监控机]-" + observable.getName() + "：" + msg);
    }

}
```

**到达工地**

```java
    public static void main(String[] args) {
        // 搬砖工：张三
        ZhangSan zhangsan = new ZhangSan();
        // 搬砖工：李四
        LiSi lisi = new LiSi();
        // 包工头
        Foreman foreman = new Foreman();
        
        // 包工头开始监控张三、李四
        zhangsan.addObserver(foreman);
        lisi.addObserver(foreman);

        // 张三又在摸鱼
        zhangsan.moFish();
        // 张三又在瞎聊天
        zhangsan.chat();
        // 张三终于开始搬砖了
        zhangsan.movingBricks();

        // 李四就爱逛b站
        lisi.bilibili();
        // 李四开始听小曲
        lisi.music();
        // 李四终于开始搬砖了
        lisi.movingBricks();
    }
```

此时，包先生躺坐在房间里，吹着空调、吃着西瓜、逛着B站，时不时的瞟眼大屏幕：

```
摸会鱼
[包工头牌监控机]-张三：摸鱼中...[懂得都懂]
聊会天
[包工头牌监控机]-张三：闲聊中...[不可描述]
搬会砖
[包工头牌监控机]-张三：搬砖中...[cv大法]
逛逛二次元
[包工头牌监控机]-李四：逛B站...[发生肾么事了]
听会歌
[包工头牌监控机]-李四：听网抑云...[生而为人，我很抱歉]
这道题我不会
[包工头牌监控机]-李四：百度中...[java.lang.OutOfMemoryError: Java heap space]
```

包先生的梦想终于实现，他也从最开始的迟到，变成了现在的早退，甚至旷工。

而这一切的一切都被远在马尔代夫度假的大老板看在眼里。

```
[大老板牌监控机]-包工头：晚到一点点也无所谓啦！
[大老板牌监控机]-包工头：溜了溜了～
[大老板牌监控机]-包工头：劳资今天不上班～
```

最终，包先生得到了彻底的解放。

### 观察者模式的优缺点

#### 优点
* 观察者和被观察者之间是抽象耦合的，可以很方便的扩展观察者和被观察者。
* 对于注册过的观察者，被观察者可以对其进行消息传递。

#### 缺点
* 开发效率和运行效率可能并不高。
* 多个观察者与被观察者调试起来困难。
* 消息的通知默认是顺序执行的，一个观察者卡死，会影响整体的执行效率。