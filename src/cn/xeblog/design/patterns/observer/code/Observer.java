package cn.xeblog.design.patterns.observer.code;

/**
 * 观察者
 *
 * @author anlingyi
 * @date 2021/4/10 11:20 上午
 */
public interface Observer {

    void update(Observable observable, String msg);

}
