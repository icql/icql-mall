package work.icql.icm.product.b.server.designpattern.creational.factory.factorymethod;

import work.icql.java.designpattern.creational.factory.factorymethod.factory.ObjectAFactory;
import work.icql.java.designpattern.creational.factory.factorymethod.factory.ObjectBFactory;
import work.icql.java.designpattern.creational.factory.factorymethod.factory.ObjectCFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法模式
 */
public class Factory {

    private static final Map<String, ObjectFactory> FACTORY_BY_TYPE = new HashMap<>();

    static {
        FACTORY_BY_TYPE.put("A", new ObjectAFactory());
        FACTORY_BY_TYPE.put("B", new ObjectBFactory());
        FACTORY_BY_TYPE.put("C", new ObjectCFactory());
    }

    public static ObjectFactory createObject(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return FACTORY_BY_TYPE.get(type.toUpperCase());
    }
}
