package com.company;
/**Human - это класс для передачи данных. Как создать класс для передачи данных.
 * 1) придумать название класса и создать класс
 * 2) Добавить поля класса, для этот нужно придумать поля, которые будут в классе и записать для каждого
 * поля private final тип поля название поля.
 * Сделать конструктор для класса, который принимает эти поля. Для этого поставить курсор на название одного из этих
 * полей, нажать alt+enter, выбрать add constuctor parameters, нажать enter, в появившемся контекстном меню выбрать все
 * поля и нажать ок.
 * Создать геттеры, для этого поставить курсор на пустую строчку после конструктора, нажать alt+insert, в появившемся
 * контекстном меню выбрать getter, нажать enter все поля и нажать ок. Геттеры нужны, чтобы присваивать значения private полей
 */

public class Human {
    private final String name;
    private final String surname;
    private final String patronymic;

    public Human(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
