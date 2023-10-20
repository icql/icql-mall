package work.icql.icm.product.b.server.designpattern.creational.factory.simplefactory;

import work.icql.java.designpattern.creational.factory.simplefactory.object.ObjectA;
import work.icql.java.designpattern.creational.factory.simplefactory.object.ObjectB;
import work.icql.java.designpattern.creational.factory.simplefactory.object.ObjectC;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式
 */
public class Factory {

    private static final Map<String, IObject> OBJECT_BY_TYPE = new HashMap<>();

    static {
        OBJECT_BY_TYPE.put("A", new ObjectA());
        OBJECT_BY_TYPE.put("B", new ObjectB());
        OBJECT_BY_TYPE.put("C", new ObjectC());
    }

    public static IObject createObject(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return OBJECT_BY_TYPE.get(type.toUpperCase());
    }
}
