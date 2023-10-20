package work.icql.icm.product.b.server.designpattern.structural.flyweight;

public class FlyweightClient {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight test1 = flyweightFactory.getFlyweight("test1");
        Flyweight test2 = flyweightFactory.getFlyweight("test1");
        test1.operation("外部");
    }
}
