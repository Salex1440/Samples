![Exceptions hierarchy.drawio.png](Exceptions%20hierarchy.drawio.png)

Исключения можно разделить на две категории:

1. Встроенные исключения:
* Checked exceptions (зеленые блоки)
* Unchecked exceptions (красные блоки)
2. Пользовательские исключения

# Встроенные исключения

*Встроенные исключения* — это исключения, доступные в библиотеках Java. Эти исключения подходят для объяснения определенных ошибочных ситуаций.

## Checked exceptions
Проверенные исключения называются исключениями времени компиляции, поскольку эти исключения проверяются компилятором во время компиляции.
     
## Unchecked exceptions
Непроверенные исключения прямо противоположны проверенным исключениям. Компилятор не будет проверять эти исключения во время компиляции. Проще говоря, если программа выдает непроверенное исключение, и даже если мы его не обработали и не объявили, программа не выдаст ошибку компиляции.


# Исключения, определяемые пользователем:

Иногда встроенные в Java исключения не могут описать определенную ситуацию. В таких случаях пользователи также могут создавать исключения, которые называются «исключениями, определяемыми пользователем».

Преимущества обработки исключений в Java заключаются в следующем:

1. Положение о завершении реализации программы
2. Простая идентификация программного кода и кода обработки ошибок
3. Распространение ошибок
4. Значимые отчеты об ошибках
5. Определение типов ошибок
