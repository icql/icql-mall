package work.icql.icm.product.b.server.datastructure.list.queue;

import work.icql.java.datastructure.list.List;
import work.icql.java.datastructure.list.Queue;
import work.icql.java.datastructure.list.array.ArrayList;

public class ArrayQueue<E> implements Queue<E> {

    private List<E> arrayList = new ArrayList<>();

    @Override
    public void add(E e) {
        arrayList.add(e);
    }

    @Override
    public E remove() {
        int index = 0;
        E e = arrayList.get(index);
        arrayList.remove(index);
        return e;
    }
}
