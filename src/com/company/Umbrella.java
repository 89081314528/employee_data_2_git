package com.company;

public class Umbrella {
    private final String name;
    private final String surname;
    private final Integer salary;

    public Umbrella(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public Umbrella withSalary(Integer salary) {
        return new Umbrella(this.getName(), this.getSurname(), salary);
    }
}
