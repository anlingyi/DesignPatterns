package cn.xeblog.design.patterns.observer.code;

/**
 * 大老板
 *
 * @author anlingyi
 * @date 2021/4/10 12:06 下午
 */
public class Boss implements Observer {

    @Override
    public void update(Observable observable, String msg) {
        System.out.println("[大老板牌监控机]-" + observable.getName() + "：" + msg);
    }

}
