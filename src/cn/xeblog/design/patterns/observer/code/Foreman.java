package cn.xeblog.design.patterns.observer.code;

/**
 * 包工头
 *
 * @author anlingyi
 * @date 2021/4/10 11:37 上午
 */
public class Foreman extends Observable implements Observer {

    @Override
    public void update(Observable observable, String msg) {
        System.out.println("[包工头牌监控机]-" + observable.getName() + "：" + msg);
    }

    @Override
    public String getName() {
        return "包工头";
    }

    public void late() {
        notifyObservers("晚到一点点也无所谓啦！");
    }

    public void leaveEarly() {
        notifyObservers("溜了溜了～");
    }

    public void absenteeism() {
        notifyObservers("劳资今天不上班～");
    }

}
