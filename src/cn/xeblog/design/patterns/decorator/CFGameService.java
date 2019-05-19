package cn.xeblog.design.patterns.decorator;

/**
 * cf游戏服务接口
 *
 * @author anlingyi
 */
public interface CFGameService {

    /**
     * 登入
     * @param username
     * @param password
     */
    void login(String username, String password);

    /**
     *  开枪射击
     */
    void fire();

    /**
     * 丢手雷
     */
    void grenade();
}
