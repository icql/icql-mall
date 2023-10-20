package work.icql.icm.product.b.server.designpattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者2
 */
public class ConcreteObserver2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者2-收到消息：" + arg);
    }
}
