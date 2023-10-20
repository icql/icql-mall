package work.icql.icm.product.b.server.designpattern.creational.factory.factorymethod.factory;

import work.icql.java.designpattern.creational.factory.factorymethod.ObjectFactory;
import work.icql.java.designpattern.creational.factory.factorymethod.IObject;
import work.icql.java.designpattern.creational.factory.factorymethod.object.ObjectA;

public class ObjectAFactory implements ObjectFactory {
    @Override
    public IObject createObject(String type) {
        //复杂的创建逻辑
        return new ObjectA();
    }
}
