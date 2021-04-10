package cn.xeblog.design.patterns.observer.code;

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
