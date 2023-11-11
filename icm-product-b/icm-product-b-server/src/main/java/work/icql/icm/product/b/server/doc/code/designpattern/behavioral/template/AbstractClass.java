package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.template;

public abstract class AbstractClass {

    public final void templateMethod() {
        //...
        method1();
        //...
        method2();
        //...
    }

    protected abstract void method1();

    protected abstract void method2();
}
