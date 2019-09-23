package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MainFourPaks {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeePaks[] employeePakses = new EmployeePaks[]{
                new EmployeePaks("Ксения", "Иванова", "Владимировна", 10650),
                new EmployeePaks("Наталья", "Щербакова", "Владимировна", 10000)
        };
        String[] settings = new String[]{
                "name",
//                "surname",
                "patronymic",
                "salary"
        };
        reportPaks("reportPaks.csv", employeePakses, settings, 10000);
    }

    public static boolean findWordInMassiveSettings(String word, String[] settings) {
        for (int i = 0; i < settings.length; i++) {
            if (settings[i] == word) {
                return true;
            }
        }
        return false;
    }

    public static void reportPaks(String fileName, EmployeePaks[] employeePakses, String[] settings, int minSalary) throws FileNotFoundException {
        PrintStream preanter = new PrintStream(new File(fileName));
            if (findWordInMassiveSettings("name", settings)) {
                preanter.print("name;");
            }
            if (findWordInMassiveSettings("surname", settings)) {
                preanter.print("surname;");
            }
            if (findWordInMassiveSettings("patronymic", settings)) {
                preanter.print("patronymic;");
            }
            if (findWordInMassiveSettings("salary", settings)) {
                preanter.print("salary;");
            }
        preanter.println();
        for (int i = 0; i < employeePakses.length; i++) {
            EmployeePaks employeePaks = employeePakses[i];
            if (employeePaks.getSalary() > minSalary) {
                if (findWordInMassiveSettings("name", settings)) {
                    preanter.print(employeePaks.getName());
                    preanter.print(";");
                }
                if (findWordInMassiveSettings("surname", settings)) {
                    preanter.print(employeePaks.getSurname());
                    preanter.print(";");
                }
                if (findWordInMassiveSettings("patronymic", settings)) {
                    preanter.print(employeePaks.getPatronymic());
                    preanter.print(";");
                }
                if (findWordInMassiveSettings("salary", settings)) {
                    preanter.print(employeePaks.getSalary());
                    preanter.print(";");
                }
            }
            preanter.println();
        }
    }
}
