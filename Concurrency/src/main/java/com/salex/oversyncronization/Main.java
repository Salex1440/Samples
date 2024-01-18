package com.salex.oversyncronization;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    /**
     * Не вызывайте сторонние методы из области синхронизации. Это может привести
     * к непредсказуемым последствиям!
     */
    public static void main(String[] args) {
        try {
            example1();
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException was thrown!");
        }
//        example2(); // Метод вызовет взаимоблокировку!

        // Решить данные проблемы можно путем выноса вызова сторонних методов за пределы
        // синхронизированных блоков. Например:
//        private void notifyElementAdded(Е element)
//        {
//            List<SetObserver<E>> snapshot = null;
//            synchronized(observers)
//            {
//                snapshot = new ArrayList(observers) ;
//            }
//            for (SetObserver<E> observer : snapshot)
//                observer.added(this, element);
//        }
        // Для метода notifyElementAdded это включает получение “снимка” списка
        // observers, который затем можно безопасно обойти без блокировки. При таком
        // изменении оба предыдущих примера будут выполняться без исключений
        // и взаимоблокировок.
        // На самом деле есть лучший способ переместить вызов чужого метода за
        // рамки синхронизируемого блока. Библиотеки предоставляют параллельную
        // коллекцию, известную как CopyOnWriteArrayList, созданную специально
        // для этой цели. Эта реализация List представляет собой вариант ArrayList,
        // в котором все модифицирующие операции реализуются с помощью создания
        // копии всего базового массива. Поскольку внутренний массив никогда не
        // изменяется, итерации не требуют блокировки и выполняются очень быстро.
        // Для большинства применений производительность CopeOnWriteArrayList
        // будет ужасной, но для списка наблюдателей он подойдет идеально,
        // так как список редко изменяется и очень часто выполняется его обход.
        copyOnWriteArrayListExample();
        // Чужой метод, вызываемый за пределами синхронизируемой области, известен
        // как открытый вызов (open call). Кроме предотвращения сбоев, открытые
        // вызовы могут существенно увеличить степень параллельности. Чужой
        // метод может выполняться в течение произвольно длительного времени.
        // Если чужой метод вызван из синхронизируемой области, другие потоки не
        // получат доступ к излишне, без надобности защищенным ресурсам.
    }


    /**
     * Вы можете ожидать, что программа напечатает числа от 0 до 23, после чего
     * наблюдатель отказывается от подписки и программа завершает работу. Но на
     * самом деле она выводит значения от 0 до 23, после чего генерирует исключение
     * ConcurrentModificationException. Проблема в том, что notifyElementAdded
     * находится в процессе итерации по списку observers, когда вызывается метод
     * наблюдателя added. Метод added вызывает метод removeObserver множества, который,
     * в свою очередь, вызывает observer.remove. И теперь у нас проблема.
     * Мы пытаемся удалить элемент из списка во время обхода последнего, что является
     * некорректным действием. Итерация в методе notifyElementAdded находится в
     * синхронизируемом блоке, чтобы воспрепятствовать параллельному изменению множества,
     * но не препятствует обратному вызову наблюдаемого множества и изменению списка observers.
     */
    private static void example1() throws ConcurrentModificationException {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet());
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(Set<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ((ObservableSet<Integer>)set).removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    /**
     * При выполнении этой программы исключение не генерируется — мы получаем
     * взаимоблокировку. Фоновый поток вызывает set.removeObserver, который
     * пытается заблокировать observers, но не может захватить блокировку,
     * потому что основной поток уже ее захватил. В то же время основной поток
     * ждет, когда фоновый поток завершит удаление наблюдателя, чем и объясняется
     * блокировка.
     */
    private static void example2() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet());
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(Set<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> ((ObservableSet<Integer>)set).removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    private static void copyOnWriteArrayListExample() {
        ObservableSet2<Integer> set = new ObservableSet2<>(new HashSet());
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(Set<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ((ObservableSet2<Integer>)set).removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

}
