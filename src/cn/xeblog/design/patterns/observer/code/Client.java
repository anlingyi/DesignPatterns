package cn.xeblog.design.patterns.observer.code;

/**
 * @author anlingyi
 * @date 2021/4/10 12:05 下午
 */
public class Client {

    public static void main(String[] args) {
        // 搬砖工：张三
        ZhangSan zhangsan = new ZhangSan();
        // 搬砖工：李四
        LiSi lisi = new LiSi();
        // 包工头
        Foreman foreman = new Foreman();
        Boss boss = new Boss();

        // 包工头开始监控张三、李四
        zhangsan.addObserver(foreman);
        lisi.addObserver(foreman);

        // 张三又在摸鱼
        zhangsan.moFish();
        // 张三又在瞎聊天
        zhangsan.chat();
        // 张三终于开始搬砖了
        zhangsan.movingBricks();

        // 李四就爱逛b站
        lisi.bilibili();
        // 李四开始听小曲
        lisi.music();
        // 李四终于开始搬砖了
        lisi.movingBricks();

        // boss监控包工头
        foreman.addObserver(boss);

        foreman.late();
        foreman.leaveEarly();
        foreman.absenteeism();
    }

}
