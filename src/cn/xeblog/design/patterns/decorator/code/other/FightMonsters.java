package cn.xeblog.design.patterns.decorator.code.other;

/**
 * 奥特曼打怪兽
 *
 * @author anlingyi
 * @date 2021/4/17 11:08 下午
 */
public class FightMonsters {

    public static void main(String[] args) {
//        TigaService tigaService = new TigaServiceImpl();
//        System.out.println("复合型迪迦打怪兽：");
//        tigaService.fist();
//        tigaService.leg();
//        tigaService.fly();

//        TigaService tigaService = new RedTigaDecorator(new TigaServiceImpl());
//        System.out.println("力量型迪迦打怪兽：");
//        tigaService.fist();
//        tigaService.leg();
//        tigaService.fly();
//
        TigaService tigaService = new PurpleTigaDecorator(new TigaServiceImpl());
        System.out.println("敏捷型迪迦打怪兽：");
        tigaService.fist();
        tigaService.leg();
        tigaService.fly();
    }

}
