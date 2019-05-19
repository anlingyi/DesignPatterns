package cn.xeblog.design.patterns.decorator.code;

/**
 * cf游戏者实现类
 *
 * @author anlingyi
 */
public class CFerServiceImpl implements CFGameService {

    @Override
    public void login(String username, String password) {
        System.out.println(username + ", 登入游戏成功！");
    }

    @Override
    public void fire() {
        System.out.println("开火。。。");
    }

    @Override
    public void grenade() {
        System.out.println("丢雷。。。");
    }
}
