package work.icql.icm.product.b.server.designpattern.structural.adapter;

import work.icql.java.designpattern.structural.adapter.adaptee.Adaptee1;
import work.icql.java.designpattern.structural.adapter.adaptee.Adaptee2;
import work.icql.java.designpattern.structural.adapter.clazz.ClazzAdaptor;
import work.icql.java.designpattern.structural.adapter.object.ObjectAdaptor;

public class AdapterClient {

    public static void main(String[] args) {
        ITarget target1 = new ClazzAdaptor();
        target1.operationA();
        target1.operationB();

        ITarget target2 = new ObjectAdaptor(new Adaptee1(), new Adaptee2());
        target2.operationA();
        target2.operationB();
    }
}
