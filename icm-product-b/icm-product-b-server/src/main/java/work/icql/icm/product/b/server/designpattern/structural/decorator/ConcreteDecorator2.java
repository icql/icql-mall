package work.icql.icm.product.b.server.designpattern.structural.decorator;

/**
 * 具体的装饰器2
 */
public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedOperation();
    }

    private void addedOperation() {
        System.out.println("增加装饰器2");
    }
}
