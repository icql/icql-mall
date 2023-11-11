package work.icql.icm.product.b.server.doc.code.designpattern.structural.proxy.b_dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理模式：基于接口实现-jdk动态代理
 * 基于继承实现，cglib字节码技术可以动态代理
 */
public class UserServiceProxy {

    private final UserServiceImpl userService = new UserServiceImpl();

    public void action() {
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                UserServiceProxy.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    //附加功能
                    Object obj = method.invoke(userService, args);
                    return obj;
                });
        proxyService.action();
        System.out.println("代理类-action方法 执行了。。。");
    }
}
