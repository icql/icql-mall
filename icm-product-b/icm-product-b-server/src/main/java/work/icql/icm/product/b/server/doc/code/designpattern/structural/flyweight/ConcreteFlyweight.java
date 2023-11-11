package work.icql.icm.product.b.server.doc.code.designpattern.structural.flyweight;

public class ConcreteFlyweight extends Flyweight {

    public ConcreteFlyweight(Object intrinsicState) {
        super(intrinsicState);
    }

    @Override
    public void operation(Object extrinsicState) {
        System.out.println("内部状态：" + intrinsicState + "外部状态：" + extrinsicState);
    }
}
