package cn.xeblog.design.patterns.decorator.code.other;

/**
 * 复合型迪迦
 *
 * @author anlingyi
 * @date 2021/4/17 10:54 下午
 */
public class TigaServiceImpl implements TigaService {

    @Override
    public void fist() {
        System.out.println("迪迦使出奥特之拳，对怪兽造成1点伤害！");
    }

    @Override
    public void leg() {
        System.out.println("迪迦使出奥特之腿，对怪兽造成1点伤害！");
    }

    @Override
    public void fly() {
        System.out.println("迪迦使出奥特飞起，飞行速度1km/h！");
    }

}
