package com.salex.creational.abstract_factory;

import com.salex.creational.abstract_factory.model.ProductA;
import com.salex.creational.abstract_factory.model.ProductB;

/**
 * Предоставляет интерфейс для создания семейств взаимосвязанных или взаимозависимых объектов,
 * не специфицируя их конкретных классов.
 */
public abstract class AbstractFactory {

    public abstract ProductA createProductA();

    public abstract ProductB createProductB();

}
