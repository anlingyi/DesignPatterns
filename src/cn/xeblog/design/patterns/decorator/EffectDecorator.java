package cn.xeblog.design.patterns.decorator;

/**
 * 效果装饰类
 *
 * @author anlingyi
 */
public class EffectDecorator extends CFGameDecorator {

    public EffectDecorator(CFGameService cfGameService) {
        super(cfGameService);
    }

    @Override
    public void login(String username, String password) {
        // vip会员
        System.out.println("尊贵的vvvvvip会员");
        super.login(username, password);
    }

    @Override
    public void fire() {
        super.fire();
        // 增加击杀音效
        this.killSound();
    }

    @Override
    public void grenade() {
        super.grenade();
        // 增加丢手雷音效
        this.grenadeSound();
    }

    /**
     * 增加击杀音效
     */
    private void killSound() {
        System.out.println("嘿帅！");
    }

    /**
     * 增加丢手雷的音效
     */
    private void grenadeSound() {
        System.out.println("发呀的轰！");
    }
}
