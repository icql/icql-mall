package work.icql.icm.product.b.server.designpattern.structural.decorator;

/**
 * 具体的构件1
 */
public class ConcreteComponent1 implements Component {

    @Override
    public void operation() {
        System.out.println("具体的构件1");
    }
}
