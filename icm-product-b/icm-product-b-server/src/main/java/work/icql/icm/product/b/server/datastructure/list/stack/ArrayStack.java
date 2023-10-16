package work.icql.icm.product.b.server.datastructure.list.stack;

import work.icql.java.datastructure.list.List;
import work.icql.java.datastructure.list.Stack;
import work.icql.java.datastructure.list.array.ArrayList;

public class ArrayStack<E> implements Stack<E> {

    private List<E> arrayList = new ArrayList<>();

    @Override
    public void push(E e) {
        arrayList.add(e);
    }

    @Override
    public E pop() {
        int lastIndex = arrayList.size() - 1;
        E last = arrayList.get(lastIndex);
        arrayList.remove(last);
        return last;
    }
}
