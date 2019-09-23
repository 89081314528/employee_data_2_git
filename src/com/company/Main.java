package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * * паспортный стол - заполнить эксель паспортными данными сотрудников (фио, серия, номер, зарплата).
 * * сначала сделать по аналогии с PrimeTime для одного человека, потом сделать массив
 * * добавить настройки, какие колонки нужно добавлять в csv. сначала написать метод, который принимает массив строк и строку.
 * * если в массиве есть эта строка, то он возвращает тру, если нет, то фолс.
 * * метод, который принимает массив служащих, имя файла и целое число, и печатает файл служащих,
 * у которых зарплата выше этой цифры
 * как сохранять все мэйны и новые классы в гите?????!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Employee[] employees = new Employee[]{
                new Employee("Павел", "Иванов", "Святославович", 250000),
                new Employee("Денис", "Силяков", "Владимирович", 30000),
        };
        String[] settings = new String[]{
//                "name",
                "surname",
//                "patronymic",
//                "salary"
        };
        report("newReport.csv", employees, 20000, settings);
    }
    public static boolean findDirector (String a, String[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i].equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static void report(String fileName, Employee[] employees, int minSalary, String[] settings) throws FileNotFoundException {
        PrintStream printer = new PrintStream(new File(fileName));
        if (findDirector("surname", settings)) {
            printer.print("фамилия");
            printer.print(";");
        }
        if (findDirector("name", settings)) {
            printer.print("имя");
            printer.print(";");
        }
        if (findDirector("patronymic", settings)) {
            printer.print("отчество");
            printer.print(";");
        }
        printer.print("зарплата");
        printer.println();
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() > minSalary) {
                if (findDirector("surname", settings)) {
                    printer.print(employee.getSurname());
                    printer.print(";");
                }
                if (findDirector("name", settings)) {
                    printer.print(employee.getName());
                    printer.print(";");
                }
                if (findDirector("patronymic", settings)) {
                    printer.print(employee.getPatronymic());
                    printer.print(";");
                }
                printer.print(employee.getSalary());
                printer.println();
            }
        }
    }
}
