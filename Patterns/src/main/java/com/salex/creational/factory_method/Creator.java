package com.salex.creational.factory_method;


/**
 * Factory method (Фабричный метод) - Определяет интерфейс для создания объекта,
 * но оставляет подклассам решение о том, на основании какого класса создавать объект.
 * Фабричный метод позволяет классу делегировать создание подклассов.
 */
public interface Creator {

    Product factoryMethod();

}
