package com.company;

public class EmployeeNftPlus {
        private final String name;
        private final String surname;
        private final String patronymic;
        private final int salary;

    public EmployeeNftPlus(String name, String surname, String patronymic, int salary) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }
}
