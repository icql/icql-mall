package work.icql.icm.product.b.server.designpattern.creational.singleton;


/**
 * 单例：饥饿模式——类加载时就创建对象
 * 过早占用内存，存在性能问题？
 * 若初始化耗时，应该在应用启动时就初始化好，避免使用时再创建出现性能问题
 * 占用内存多？按照fail-fast设计原则（有问题及早暴漏），启动时就能检查内存是否够用
 */
public final class EagerSingleton {
    /**
     * 类加载的时候执行clinit()时将创建对象，线程安全
     */
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
