package work.icql.icm.product.b.server.datastructure.list.stack;

import work.icql.java.datastructure.list.List;
import work.icql.java.datastructure.list.Stack;
import work.icql.java.datastructure.list.linked.DoubleLinkedList;

public class LinkedStack<E> implements Stack<E> {

    private List<E> linkedList = new DoubleLinkedList<>();

    @Override
    public void push(E e) {
        linkedList.add(e);
    }

    @Override
    public E pop() {
        int lastIndex = linkedList.size() - 1;
        E last = linkedList.get(lastIndex);
        linkedList.remove(last);
        return last;
    }
}
