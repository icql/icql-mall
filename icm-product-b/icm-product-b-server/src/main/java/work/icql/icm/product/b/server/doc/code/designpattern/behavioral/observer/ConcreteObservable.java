package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.observer;

import java.util.Observable;

/**
 * 具体被观察者
 */
public class ConcreteObservable extends Observable {

    public void sendMsg(String msg) {
        setChanged();
        notifyObservers(msg);
    }
}
