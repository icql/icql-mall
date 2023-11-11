package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.iterator;

import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void add(E e) {

    }


    private static class ArrayIterator<E> implements Iterator<E> {

        private int cursor;

        private ArrayList<E> arrayList;

        public ArrayIterator(ArrayList<E> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public boolean hasNext() {
            return cursor != arrayList.size();
        }

        @Override
        public void next() {
            cursor++;
        }

        @Override
        public E currentItem() {
            if (cursor >= arrayList.size()) {
                throw new NoSuchElementException();
            }
            return arrayList.get(cursor);
        }
    }
}
