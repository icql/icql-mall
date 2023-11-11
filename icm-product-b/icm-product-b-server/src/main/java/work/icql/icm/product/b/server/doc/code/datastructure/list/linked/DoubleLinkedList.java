package work.icql.icm.product.b.server.doc.code.datastructure.list.linked;

import work.icql.java.datastructure.list.List;

import java.util.Objects;

public class DoubleLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size;


    public DoubleLinkedList() {
    }

    public DoubleLinkedList(E e) {
        head = new Node<>(e, null, null);
        tail = head;
        size++;
    }


    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (head == null) {
            head = new Node<>(e, null, null);
            tail = head;
        } else {
            Node<E> old = node(index);
            old.next = new Node<>(e, old, old.next);
            if (index == size - 1) {
                tail = old.next;
            }
        }
        size++;
    }

    @Override
    public void add(E e) {
        int index = size - 1;
        if (index < 0) {
            index = 0;
        }
        add(index, e);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Node<E> node = node(index);
        Node<E> next = node.next;
        if (next != null) {
            node.data = next.data;
            node.next = next.next;
        } else {
            tail = node.prev;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void remove(E e) {
        int index = index(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public void set(int index, E e) {
        checkIndex(index);
        Node<E> node = node(index);
        node.data = e;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traversal() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DoubleLinkedList");
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\n");
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(node);
            node = node.next;
        }
        return stringBuilder.toString();
    }


    private void checkIndex(int index) {
        if (index < 0 || (size > 0 && index >= size) || (size == 0 && index > 0)) {
            throw new IllegalArgumentException("索引越界");
        }
    }

    private Node<E> node(int index) {
        int midIndex = size >> 1;
        Node<E> node;
        if (index < midIndex) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private int index(E e) {
        Node<E> node = head;
        for (int index = 0; index < size; index++) {
            if (Objects.equals(node, e)) {
                return index;
            }
            node = node.next;
        }
        return -1;
    }


    private static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
