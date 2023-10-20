package work.icql.icm.product.b.server.designpattern.creational.factory.factorymethod;

public interface ObjectFactory {
    IObject createObject(String type);
}
