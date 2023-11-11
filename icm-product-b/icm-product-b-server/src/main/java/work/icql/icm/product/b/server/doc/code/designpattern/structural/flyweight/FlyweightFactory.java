package work.icql.icm.product.b.server.doc.code.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    /**
     * 享元池
     */
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight == null) {
            //如果对象不存在，先创建一个新的对象添加到享元池中，然后返回
            Flyweight fw = new ConcreteFlyweight(key);
            flyweights.put(key, fw);
            return fw;
        } else {
            //如果对象存在，则直接从享元池获取
            return flyweight;
        }
    }
}
