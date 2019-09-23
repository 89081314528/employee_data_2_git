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

    public static void reportPaks(String fileName, EmployeePaks[] employeePakses, String[] settings, int salary) throws FileNotFoundException {
        PrintStream preanter = new PrintStream(new File(fileName));
        for (int i = 0; i < settings.length; i++) {
            if (settings[i].equals("name")) {
                preanter.print("name;");
            }
            if (settings[i].equals("surname")) {
                preanter.print("surname;");
            }
            if (settings[i].equals("patronymic")) {
                preanter.print("patronymic;");
            }
            if (settings[i].equals("salary")) {
                preanter.print("salary;");
            }
        }
        preanter.println();
        for (int i = 0; i < employeePakses.length; i++) {
            EmployeePaks employeePaks = employeePakses[i];
            for (int y = 0; y < settings.length; y++) {
                if (settings[y].equals("name")) {
                    preanter.print(employeePaks.getName());
                    preanter.print(";");
                }
                if (settings[y].equals("surname")) {
                    preanter.print(employeePaks.getSurname());
                    preanter.print(";");
                }
                if (settings[y].equals("patronymic")) {
                    preanter.print(employeePaks.getPatronymic());
                    preanter.print(";");
                }
                if (settings[y].equals("salary")) {
                    preanter.print(employeePaks.getSalary());
                    preanter.print(";");
                }
            }
            preanter.println();
        }
    }
}
