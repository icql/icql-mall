package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者1
 */
public class ConcreteObserver1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者1-收到消息：" + arg);
    }
}
