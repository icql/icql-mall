package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.strategy;

/**
 * 具体的策略B
 */
public class ConcreteStrategyB implements Strategy {

    @Override
    public void operation() {
        System.out.println("具体的策略B");
    }
}
