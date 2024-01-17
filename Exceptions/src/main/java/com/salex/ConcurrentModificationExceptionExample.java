package com.salex;

import java.util.*;

public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            try {
                Integer value = it.next();
                if (value == 3) {
                    // После выполнения удаления с помощью метода ArrayList.remove(Object o)
                    // поменяется состояние переменной modCount. При этом, у внутреннего класса Itr
                    // состояние переменной expectedModCount останется прежним. Поэтому, при последующем
                    // вызове метода Itr.next() expectedModCount != modCount, из-за чего произойдет
                    // вызов исключения ConcurrentModificationException.
                    list.remove(value);
                    // Чтобы избежать такой ситуации, нужно вызывать метод Itr.remove(). В нем
                    // произойдет синхронизация внутреннего состояния modCount с expectedModCount.
                    System.out.println(value + " was removed.");

                } else {
                    System.out.println(value);
                }
            } catch (ConcurrentModificationException ex) {
                System.out.println("ConcurrentModificationException was thrown!");
                break;
            }

        }

        // Конструкция for-each реализуется на основе итератора, поэтому ошибка повторится.
        try {
            for (Integer value : list) {
                    if (value == 2) {
                            list.remove(value);
                            System.out.println(value + " was removed.");
                    } else {
                        System.out.println(value);
                    }
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("ConcurrentModificationException was thrown!");
        }

        // Если необходимо модифицировать список во время перебора в цикле, лучше воспользоваться
        // стандартным циклом for. Однако, нужно иметь в виду, что данный код не потокобезопасен!
        for (int i = 0; i < list.size();) {
            if (list.get(i) == 4) {
                Integer removed = list.remove(i);
                System.out.println(removed + " was removed.");
            } else if (list.get(i) == 5) {
                list.add(6);
                System.out.println(list.get(i++));
            }
            else {
                System.out.println(list.get(i++));
            }
        }

        // Либо воспользоваться внутренним классом ListItr, но, при этом не вызывать методы класса ArrayList!!!
        // И данный код также не потокобезопасен!
        for (ListIterator<Integer> it = list.listIterator(); it.hasNext();) {
            Integer next = it.next();
            System.out.println(next);
            if (next == 1) {
                it.add(2);
                System.out.println(it.previous() + " was added");
            }
        }
    }
}
