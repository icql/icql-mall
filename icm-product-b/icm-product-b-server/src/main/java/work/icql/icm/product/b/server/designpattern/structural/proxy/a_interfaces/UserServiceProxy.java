package work.icql.icm.product.b.server.designpattern.structural.proxy.a_interfaces;

/**
 * 基于接口实现的代理模式
 */
public class UserServiceProxy implements UserService {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void action() {
        //附加功能
        System.out.println("代理类-action方法 执行了。。。");
        userService.action();
    }
}
