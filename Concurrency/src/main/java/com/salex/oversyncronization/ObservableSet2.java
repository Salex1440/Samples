package com.salex.oversyncronization;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSet2<E> extends HashSet<E> {

    private final List<SetObserver> observers = new CopyOnWriteArrayList<>();

    public ObservableSet2(Set<E> set) {
        super(set);
    }

    public void addObserver(SetObserver<E> observer) {
            observers.add(observer);
    }

    public void removeObserver(SetObserver<E> observer) {
            observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (SetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element); // Вызов notifyElementAdded
        }
        return result;
    }

}
