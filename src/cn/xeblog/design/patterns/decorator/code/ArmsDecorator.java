package cn.xeblog.design.patterns.decorator.code;

/**
 * 武器装饰类
 *
 * @author anlingyi
 */
public class ArmsDecorator extends CFGameDecorator {

    public ArmsDecorator(CFGameService cfGameService) {
        super(cfGameService);
    }

    @Override
    public void fire() {
        // 增强武器
        this.useFirearms();
        super.fire();
    }

    @Override
    public void grenade() {
        // 增强手雷
        this.useGrenade();
        super.grenade();
    }

    /**
     * 增强武器的方法
     */
    private void useFirearms() {
        System.out.println("装备：AK-47-火麒麟");
    }

    /**
     * 增强手雷的方法
     */
    private void useGrenade() {
        System.out.println("装备：高爆手雷");
    }
}
