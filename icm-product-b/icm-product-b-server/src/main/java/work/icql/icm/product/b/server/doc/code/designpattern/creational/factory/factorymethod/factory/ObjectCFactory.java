package work.icql.icm.product.b.server.doc.code.designpattern.creational.factory.factorymethod.factory;

import work.icql.java.designpattern.creational.factory.factorymethod.IObject;
import work.icql.java.designpattern.creational.factory.factorymethod.ObjectFactory;
import work.icql.java.designpattern.creational.factory.factorymethod.object.ObjectC;

public class ObjectCFactory implements ObjectFactory {
    @Override
    public IObject createObject(String type) {
        //复杂的创建逻辑
        return new ObjectC();
    }
}
