package work.icql.icm.product.b.server.datastructure.list.array;

import work.icql.java.datastructure.list.List;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> implements List<E> {
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTS = {};

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    private int size;


    public ArrayList() {
        elements = DEFAULT_CAPACITY_EMPTY_ELEMENTS;
    }

    public ArrayList(int capacity) {
        elements = new Objects[capacity];
    }


    @Override
    public void add(int index, E e) {
        checkIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
    }

    @Override
    public void add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
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
        elements[index] = e;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traversal() {
        System.out.println("traversal start");
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
        System.out.println("traversal end");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ArrayList");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\n");
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(elements[i]);
        }
        return stringBuilder.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界");
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (elements == DEFAULT_CAPACITY_EMPTY_ELEMENTS) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
            elements = new Object[minCapacity];
        } else if (minCapacity > elements.length) {
            int newCapacity = elements.length + (elements.length >> 1);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private int index(E e) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(e, elements[index])) {
                return index;
            }
        }
        return -1;
    }
}
