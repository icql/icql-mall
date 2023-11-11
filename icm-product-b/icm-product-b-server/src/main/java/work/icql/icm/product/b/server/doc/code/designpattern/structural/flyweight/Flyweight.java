package work.icql.icm.product.b.server.doc.code.designpattern.structural.flyweight;

public abstract class Flyweight {

    /**
     * 内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
     */
    protected final Object intrinsicState;

    public Flyweight(Object intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    /**
     * 外部状态extrinsicState在使用时由外部设置，不保存在享元对象中，即使是同一个对象，在每一次调用时也可以传入不同的外部状态
     */
    public abstract void operation(Object extrinsicState);
}
