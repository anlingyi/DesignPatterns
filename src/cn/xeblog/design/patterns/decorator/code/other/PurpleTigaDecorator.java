package cn.xeblog.design.patterns.decorator.code.other;

/**
 * 敏捷型迪迦
 *
 * @author anlingyi
 * @date 2021/4/17 10:51 下午
 */
public class PurpleTigaDecorator extends TigaDecorator {

    public PurpleTigaDecorator(TigaService tigaService) {
        super(tigaService);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("紫buff加成，速度提升至300km/h！");
    }

}
