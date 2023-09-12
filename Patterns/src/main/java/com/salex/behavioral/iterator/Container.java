package com.salex.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Container<T> {

    protected final List<T> list = new ArrayList<>();

    public void add(T e) {
        list.add(e);
    }

    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
        int idx = 0;

        @Override
        public boolean hasNext() {
            return !(idx == list.size());
        }

        @Override
        public T next() {
            return list.get(idx++);
        }
    }

}
