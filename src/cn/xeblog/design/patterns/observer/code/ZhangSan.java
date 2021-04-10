package cn.xeblog.design.patterns.observer.code;

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
