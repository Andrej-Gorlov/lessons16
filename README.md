# Автотесты на Java 17 с использованием JUnit

Этот проект предназначен для автоматизации тестирования веб-сайта https://kiwiduck.github.io/ с использованием Java 17 и фреймворка JUnit.

## Описание проекта

В рамках данного проекта реализованы автотесты, которые автоматизируют следующие действия:

Для настройки работы на различных операционных системах в классе WebDriverManager, расположенном по пути src/test/java/helpers/drivers, выполните следующие действия:

- Linux: закомментируйте 24 строку и раскомментируйте 23.
- Windows: закомментируйте 23 строку и раскомментируйте 24.

Убедитесь, что Google Chrome установлен не ниже версии 136
### Страница "Button"

1. Нажать на кнопку "CLICK ME!".
2. Проверить, что появляется текст "Excellent!" и кнопка "CLICK ME TOO!".
3. Нажать на кнопку "CLICK ME TOO!".
4. Проверить, что появляется ссылка с текстом "Great! Return to menu" и нажать на неё.

### Страница "Checkboxes"

1. Выбрать один или несколько из представленных чек-боксов и нажать на кнопку "GET RESULTS" под ними.
2. Проверить, что появляется текст, соответствующий атрибуту value из выделенных чек-боксов.
3. Выбрать любую радио кнопку и нажать кнопку "GET RESULTS", находящуюся под ними.
4. Проверить, что появляется текст, соответствующий значению атрибута value, выбранной кнопки.
5. Проверить, что появляется ссылка с текстом "Great! Return to menu" и нажать на неё.

### Заключение
Данный проект демонстрирует, как можно автоматизировать тестирование веб-приложений с использованием Java 17 и JUnit.
