package work.icql.icm.product.b.server.doc.code.designpattern.structural.proxy.a_interfaces;

public class UserServiceImpl implements UserService {

    @Override
    public void action() {
        System.out.println("被代理类-action方法 执行了。。。");
    }
}
