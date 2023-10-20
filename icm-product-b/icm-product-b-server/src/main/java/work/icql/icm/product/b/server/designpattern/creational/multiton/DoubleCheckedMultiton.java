package work.icql.icm.product.b.server.designpattern.creational.multiton;

import java.util.HashMap;
import java.util.Map;

/**
 * 多例：双重检测
 */
public final class DoubleCheckedMultiton {

    private static final Map<String, DoubleCheckedMultiton> INSTANCE_BY_NAME = new HashMap<>();

    private DoubleCheckedMultiton() {
    }

    public static DoubleCheckedMultiton getInstance(String name) {
        DoubleCheckedMultiton INSTANCE = INSTANCE_BY_NAME.get(name);
        //第1次检查
        if (INSTANCE == null) {
            synchronized (DoubleCheckedMultiton.class) {
                //第2次检查
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedMultiton();
                    INSTANCE_BY_NAME.put(name, INSTANCE);
                }
            }
        }
        return INSTANCE;
    }
}