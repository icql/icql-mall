package work.icql.icm.product.b.server.doc.code.designpattern.structural.decorator;

public class DecoratorClient {

    public static void main(String[] args) {
        //java-io类库有同样的装饰器实现

        Component component1 = new ConcreteComponent1();
        ConcreteDecorator1 concreteDecorator1_1 = new ConcreteDecorator1(component1);
        ConcreteDecorator2 concreteDecorator1_2 = new ConcreteDecorator2(concreteDecorator1_1);
        concreteDecorator1_2.operation();

        System.out.println();

        Component component2 = new ConcreteComponent2();
        ConcreteDecorator1 concreteDecorator2_1 = new ConcreteDecorator1(component2);
        ConcreteDecorator2 concreteDecorator2_2 = new ConcreteDecorator2(concreteDecorator2_1);
        concreteDecorator2_2.operation();
    }
}
