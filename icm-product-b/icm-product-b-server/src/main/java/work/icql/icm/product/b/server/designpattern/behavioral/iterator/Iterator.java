package work.icql.icm.product.b.server.designpattern.behavioral.iterator;

public interface Iterator<E> {

    boolean hasNext();

    void next();

    E currentItem();
}