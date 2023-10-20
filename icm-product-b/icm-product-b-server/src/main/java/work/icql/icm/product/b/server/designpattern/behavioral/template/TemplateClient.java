package work.icql.icm.product.b.server.designpattern.behavioral.template;

/**
 * 模板方法模式
 */
public class TemplateClient {

    public static void main(String[] args) {
        AbstractClass demo1 = new ConcreteClass1();
        demo1.templateMethod();

        AbstractClass demo2 = new ConcreteClass2();
        demo2.templateMethod();
    }
}
