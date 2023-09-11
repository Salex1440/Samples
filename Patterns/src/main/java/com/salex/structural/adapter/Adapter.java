package com.salex.structural.adapter;

/**
 * Адаптер (Adapter) — структурный шаблон проектирования, предназначенный для организации использования функций объекта,
 * недоступного для модификации, через специально созданный интерфейс.
 */
public interface Adapter {

    String doSth(String context, int repeats);

}
