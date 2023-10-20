package work.icql.icm.product.b.server.designpattern.behavioral.observer;

/**
 * 观察者模式
 */
public class ObserverClient {

    public static void main(String[] args) {
        //java提供了Observer接口和Observable类来作为观察者模式的抽象层
        //我们只需要自定义具体观察者类和具体观察目标类即可实现观察者模式
        ConcreteObservable observable = new ConcreteObservable();
        observable.addObserver(new ConcreteObserver1());
        observable.addObserver(new ConcreteObserver2());
        observable.sendMsg("测试消息");
    }
}