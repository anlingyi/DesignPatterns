package cn.xeblog.design.patterns.decorator.code.other;

/**
 * 力量型迪迦
 *
 * @author anlingyi
 * @date 2021/4/17 10:51 下午
 */
public class RedTigaDecorator extends TigaDecorator {

    public RedTigaDecorator(TigaService tigaService) {
        super(tigaService);
    }

    @Override
    public void fist() {
        super.fist();
        System.out.println("红buff加成，再次对怪兽造成100点伤害！");
    }

}
