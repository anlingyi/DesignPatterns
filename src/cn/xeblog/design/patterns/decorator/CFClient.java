package cn.xeblog.design.patterns.decorator;

/**
 * cf客户端 <装饰模式>
 *
 * @author anlingyi
 */
public class CFClient {

    public static void main(String[] args) {
        CFGameService cf = new CFerServiceImpl();
        // 充钱充钱(修饰武器)
        cf = new ArmsDecorator(cf);
        // 再充(修饰效果)
        cf = new EffectDecorator(cf);
        cf.login("小毅", "123456");
        cf.fire();
        cf.grenade();
    }
}
