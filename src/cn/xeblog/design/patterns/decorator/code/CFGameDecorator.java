package cn.xeblog.design.patterns.decorator.code;

/**
 * cf游戏装饰类
 *
 * @author anlingyi
 */
public abstract class CFGameDecorator implements CFGameService {

    /**
     * 被装饰的对象
     */
    private CFGameService cfGameService;

    /**
     * 通过构造函数传递被修饰对象
     * @param cfGameService
     */
    public CFGameDecorator(CFGameService cfGameService) {
        this.cfGameService = cfGameService;
    }

    @Override
    public void login(String username, String password) {
        this.cfGameService.login(username, password);
    }

    @Override
    public void fire() {
        this.cfGameService.fire();
    }

    @Override
    public void grenade() {
        this.cfGameService.grenade();
    }
}
