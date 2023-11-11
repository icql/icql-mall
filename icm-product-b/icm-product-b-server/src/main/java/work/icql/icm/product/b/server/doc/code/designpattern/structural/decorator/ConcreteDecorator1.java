package work.icql.icm.product.b.server.doc.code.designpattern.structural.decorator;

/**
 * 具体的装饰器1
 */
public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedOperation();
    }

    private void addedOperation() {
        System.out.println("增加装饰器1");
    }
}
