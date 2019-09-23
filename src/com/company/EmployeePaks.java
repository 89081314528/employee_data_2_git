package com.company;

public class EmployeePaks {
    private String name;
    private String surname;
    private String patronymic;
    private int salary;

    public EmployeePaks(String name, String surname, String patronymic, int salary) {
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
