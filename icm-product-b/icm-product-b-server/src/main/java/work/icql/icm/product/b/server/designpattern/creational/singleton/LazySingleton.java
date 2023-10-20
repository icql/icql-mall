package work.icql.icm.product.b.server.designpattern.creational.singleton;


/**
 * 单例：懒汉模式——延迟加载
 * 同步范围过大（锁对象为类Class对象），性能不佳
 */
public final class LazySingleton {

    private static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public synchronized static LazySingleton getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}