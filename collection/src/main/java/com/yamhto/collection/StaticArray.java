package com.yamhto.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author yamhto
 * @className: StaticArray.java
 * @package com.yamhto.collection
 * @description: 静态数组
 * @date 2020/4/29 9:32
 */
public class StaticArray<E> implements Collection<E> {

    transient Object[] elementData;

    private static final int INIT_SIZE = 0;

    private int maxsize; //max size

    private int size; //current size

    public StaticArray(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("StaticArray's capacity must be greater than  0");
        }

        elementData = new Object[capacity];
        this.maxsize = capacity;
        this.size = INIT_SIZE;
    }


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return new Itr(0);
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E e) {
        if (this.size == 0) {
            elementData[0] = e;
            ++this.size;
            return true;
        }

        if (this.size == this.maxsize) {
            throw new ArrayIndexOutOfBoundsException("this collection is full,can't add object");
        }

        elementData[this.size] = e;
        ++this.size;

        return true;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    public boolean containsAll(java.util.Collection<?> c) {
        return false;
    }

    public boolean addAll(java.util.Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(java.util.Collection<?> c) {
        return false;
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public Spliterator<E> spliterator() {
        return null;
    }

    public Stream<E> stream() {
        return null;
    }

    public Stream<E> parallelStream() {
        return null;
    }


    class Itr implements Iterator<E> {

        Itr(int cursor) {
            this.cursor = cursor;
        }

        int cursor = 0;

        int lastRet = -1;

        int expectedModCount = size;

        @Override
        public boolean hasNext() {
            if (cursor < expectedModCount) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            E e = get(cursor);
            ++cursor;
            return e;

        }

        @Override
        public void remove() {
        }


    }
}
