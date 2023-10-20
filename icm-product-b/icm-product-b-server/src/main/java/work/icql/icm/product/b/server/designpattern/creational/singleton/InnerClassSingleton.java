package work.icql.icm.product.b.server.designpattern.creational.singleton;


/**
 * 单例：内部类-懒加载
 */
public final class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    private static class SingletonHolder {
        public static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
