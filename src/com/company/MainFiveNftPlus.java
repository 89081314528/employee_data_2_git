package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * создать массив сотрудников,
 * создать массив настроек,
 * создать метод нахождения строки в массиве
 * создать метод, который запишет в файл с заданным именем в зависимости от настроек и зарплаты
 */

public class MainFiveNftPlus {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeNftPlus[] employeeNftPluses = new EmployeeNftPlus[] {
                new EmployeeNftPlus("Julia", "Gordeeva", "Valentinovna", 80000),
                new EmployeeNftPlus("Natalya", "Sherbakova", "Vladimirovna", 10000)
        };
        String[] settings = new String[] {
                "name",
                "surname",
//                "patronymic",
                "salary"
        };
        report("reportNftPlus.csv",employeeNftPluses, settings, 9000);
    }
    public static boolean findStringInSettings (String[] settings, String a) {
        for (int i = 0; i < settings.length; i++) {
            if (settings[i] == a) {
                return true;
            }
        }
        return false;
    }
    public static void report (String fileName, EmployeeNftPlus[] employeeNftPluses, String[] settings, int minSalary) throws FileNotFoundException {
        PrintStream preanter = new PrintStream(new File(fileName));
        if (findStringInSettings(settings, "name")) {
            preanter.print("name;");
        }
        if (findStringInSettings(settings, "surname")) {
            preanter.print("surname;");
        }
        if (findStringInSettings(settings, "patronymic")) {
            preanter.print("patronymic;");
        }
        if (findStringInSettings(settings, "salary")) {
            preanter.print("salary;");
        }
        preanter.println();
        for (int i = 0; i < employeeNftPluses.length; i++) {
            EmployeeNftPlus employeeNftPlus = employeeNftPluses[i];
            if (employeeNftPlus.getSalary() > minSalary) {
                if (findStringInSettings(settings, "name")) {
                    preanter.print(employeeNftPlus.getName());
                    preanter.print(";");
                }
                if (findStringInSettings(settings, "surname")) {
                    preanter.print(employeeNftPlus.getSurname());
                    preanter.print(";");
                }
                if (findStringInSettings(settings, "patronymic")) {
                    preanter.print(employeeNftPlus.getPatronymic());
                    preanter.print(";");
                }
                if (findStringInSettings(settings, "salary")) {
                    preanter.print(employeeNftPlus.getSalary());
                }
                preanter.println();
            }
        }
    }
}

