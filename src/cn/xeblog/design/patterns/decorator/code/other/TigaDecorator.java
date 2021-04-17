package cn.xeblog.design.patterns.decorator.code.other;

/**
 * 迪迦装饰者
 *
 * @author anlingyi
 * @date 2021/4/17 10:46 下午
 */
public abstract class TigaDecorator implements TigaService {

    private TigaService tigaService;

    public TigaDecorator(TigaService tigaService) {
        this.tigaService = tigaService;
    }

    @Override
    public void fist() {
        this.tigaService.fist();
    }

    @Override
    public void leg() {
        this.tigaService.leg();
    }

    @Override
    public void fly() {
        this.tigaService.fly();
    }

}
