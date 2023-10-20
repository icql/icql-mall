package work.icql.icm.product.b.server.designpattern.behavioral.state.impl_1;

/**
 * 马里奥状态
 */
public interface IMarioState {

    //以下是 所有状态 公共的事件

    /**
     * 获得蘑菇事件
     */
    void obtainMushRoom();

    /**
     * 获得火焰花事件
     */
    void obtainFireFlower();

    /**
     * 接触怪兽事件
     */
    void meetMonster();
}
