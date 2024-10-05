# Принцип разделения интерфейсов (Interface segregation)

Данный принцип похож на принцип единственной ответственности, но относится не к классам, а к интерфейсам.
Он говорит, что не стоит добавлять в интерфейсы методы, которые могут быть не использованы наследниками.
Т.е. лучше много маленьких интерфейсов, чем один большой.

В качестве примера рассмотрим интерфейс Restaurant. Он объявляет в себе множество методов, которые реализованы в
RestaurantImpl, но не все методы могут быть реализованы классом Buffet. Решением проблемы является разбиение
интерфейса Restaurant на множество мелких интерфейсов, которые будут реализовываться в классах при необходимости.