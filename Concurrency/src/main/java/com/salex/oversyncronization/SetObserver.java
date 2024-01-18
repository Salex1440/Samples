package com.salex.oversyncronization;

import java.util.Set;

/**
 * Этот интерфейс является структурно идентичным BiConsumer<ObservableSet<E>, Е>.
 * Мы решили определить пользовательский функциональный интерфейс как потому,
 * что имена интерфейса и метода делают код более удобочитаемым, так и потому,
 * что интерфейс может развиваться и включать множественные обратные вызовы.
 * Все это — аргументы в пользу применения BiConsumer
 */

@FunctionalInterface
public interface SetObserver<E> {

    // Вызывается при добавлении элемента к множеству
    void added(Set<E> set, E element);

}
