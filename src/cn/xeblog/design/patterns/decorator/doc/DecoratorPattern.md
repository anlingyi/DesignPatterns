原文地址：[https://xeblog.cn/articles/15](https://xeblog.cn/articles/15)

# 引言
《穿越火线》这一游戏风靡一时，作为手游版的NC粉， 想当年也是雄姿英发啊。好汉不提当年勇，现在几乎不怎么玩了。。。别问我为什么，问就是没钱，哈哈哈哈嗝～    
现在的游戏，只要一充钱，各种属性增强，各种坑爹特权，实力再高也玩不赢RMB玩家啊，在小康路上已经迷了路的我，不禁得说上一句：实力不允许。

![](https://user-gold-cdn.xitu.io/2019/5/18/16acb98fba296146?w=300&h=300&f=jpeg&s=20841)

# 装饰模式的定义
> 装饰模式是在不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。

对于网瘾少年来说，就是游戏里的皮肤，让游戏里的角色、武器啥的变得好看的。

**装饰模式的通用类图：**

![](https://user-gold-cdn.xitu.io/2019/5/18/16acb98fcc9334c8?w=803&h=367&f=png&s=27175)

*  **Component**    
	`Component` 是一个接口或者抽象类，它定义一个最核心的对象，是一个最原始的业务场景。
*  **ConcreteComponent**    
	`ConcreteComponent` 是最核心、最原始的业务逻辑实现，要装饰的就是它。
*  **Decorator**    
	顾名思义，它是一个专门做装饰的类，说白了，就是一个装修工。它一般是一个抽象类，也需要实现最原始的业务逻辑，不同于其它实现类的是，它需要定义一个 `private`  变量指向 	`Component` 对象，一般通过构造的方式传入 `Component` 对象。
*  **ConcreteComponentA、ConcreteComponentB**    
	它们是两个具体的装饰类，通过这两个装饰类来增强或减弱原始的业务逻辑，再说白了，就是游戏里的两个皮肤，给原先角色或武器装饰上后，别提多NB了。
	
![](https://user-gold-cdn.xitu.io/2019/5/18/16acb98fba4dc540?w=263&h=247&f=jpeg&s=9421)

# 装饰模式的实现
首先定义一个具体的~~业务~~游戏场景，CF游戏中的最基本的操作：登入、开火、丢手雷

**UML类图**

![](https://user-gold-cdn.xitu.io/2019/5/18/16acb98fcccdddfa?w=712&h=637&f=png&s=47753)

**抽象构件：CFGameService**
```Java
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
```

**具体构件：CFerServiceImpl**

```Java
/**
 * cf游戏者实现类
 *
 * @author anlingyi
 */
public class CFerServiceImpl implements CFGameService {

    @Override
    public void login(String username, String password) {
        System.out.println(username + ", 登入游戏成功！");
    }

    @Override
    public void fire() {
        System.out.println("开火。。。");
    }

    @Override
    public void grenade() {
        System.out.println("丢雷。。。");
    }
}
```

**抽象装饰者：CFGameDecorator**

```Java
/**
 * cf游戏装饰类
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
```

**具体的装饰类：ArmsDecorator、EffectDecorator**

```Java
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
```


```Java
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
```

## 开始游戏

平民玩家进入了游戏。。。

```Java
/**
 * cf客户端
 *
 * @author anlingyi
 */
public class CFClient {

    public static void main(String[] args) {
        CFGameService cf = new CFerServiceImpl();
        cf.login("小毅", "123456");
        cf.fire();
        cf.grenade();
    }
}
```

游戏效果：

```
小毅, 登入游戏成功！
开火。。。
丢雷。。。
```

毫无乐趣可言。

![](https://user-gold-cdn.xitu.io/2019/5/18/16acb98fd0079b99?w=330&h=287&f=png&s=31920)

> “这个问题充钱就能解决” —— 老子(子读一声)

RMB玩家进入了游戏。。。

```Java
/**
 * cf客户端
 *
 * @author anlingyi
 */
public class CFClient {

    public static void main(String[] args) {
        CFGameService cf = new CFerServiceImpl();
        // 充钱充钱(修饰武器)
        cf = new ArmsDecorator(cf);
        cf.login("小毅", "123456");
        cf.fire();
        cf.grenade();
    }
}
```

游戏效果：

```
小毅, 登入游戏成功！
装备：AK-47-火麒麟
开火。。。
装备：高爆手雷
丢雷。。。
```

瞬间NB多了，连隔壁小孩都馋哭了。。。哈哈哈～

![](https://user-gold-cdn.xitu.io/2019/5/18/16acb98fc13da987?w=499&h=369&f=jpeg&s=33120)

继续充

```Java
/**
 * cf客户端
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
```

游戏效果：

```
尊贵的vvvvvip会员
小毅, 登入游戏成功！
装备：AK-47-火麒麟
开火。。。
嘿帅！
装备：高爆手雷
丢雷。。。
发呀的轰！
```

越充越NB，越NB越好玩，越好玩越充。。。从此，在贫困的道路上越走越远。

![](https://user-gold-cdn.xitu.io/2019/5/18/16acb9965e7be939?w=259&h=284&f=gif&s=21115)

# 装饰模式的优缺点

## 优点
* 装饰类和被装饰类可以独立发展，而不会相互耦合。`Component` 类不需要知道 `Decorator` 类的存在，`Decorator` 类是从外部来扩展 `Component` 类的功能，而 `Decorator` 类也不用知道具体的构件。
* 装饰模式是继承关系的一个替代方案，装饰对象和真实对象具有相同的接口。
* 装饰模式可以动态地扩展一个实现类的功能，不用修改原有对象的结构就可以增强或减弱原有的功能。

## 缺点
* 过度的使用装饰模式会使程序变得更加复杂。

# 参考
* 《设计模式之禅》
