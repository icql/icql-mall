package work.icql.icm.product.b.server.doc.code.designpattern.structural.decorator;

/**
 * 抽象的装饰器
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
