package work.icql.icm.product.b.server.doc.code.datastructure.list.queue;

import work.icql.java.datastructure.list.List;
import work.icql.java.datastructure.list.Queue;
import work.icql.java.datastructure.list.linked.DoubleLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private List<E> linkedList = new DoubleLinkedList<>();

    @Override
    public void add(E e) {
        linkedList.add(e);
    }

    @Override
    public E remove() {
        int index = 0;
        E e = linkedList.get(index);
        linkedList.remove(index);
        return e;
    }
}
