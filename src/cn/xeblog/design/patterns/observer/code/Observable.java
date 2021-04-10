package cn.xeblog.design.patterns.observer.code;

import java.util.Vector;

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
     *
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
     *
     * @param observer
     */
    public void removeObserver(Observer observer) {
        obs.remove(observer);
    }

    /**
     * 通知观察者
     *
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
