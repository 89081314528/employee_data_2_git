package com.company;

import javafx.print.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**заполнить эксель паспортными данными сотрудников (фио, серия, номер, зарплата)
 метод, который принимает массив сотрудников и округляет зарплату до 1000,
 метод, который печатает в файл
 заменить массивы на листы
 */

public class MainUmbrella {
    public static void main(String[] args) throws FileNotFoundException {
        Umbrella[] umbrellas = new Umbrella[]{
                new Umbrella("Sofia", "Dickinson", 125689),
                new Umbrella("Greyson", "Steuber", 89852),
                new Umbrella("Itzel", "Corwin", 10360)
        };
        for (int i = 0; i < umbrellas.length; i++) {
            Umbrella umbrella = umbrellas[i];
            System.out.println(umbrella.getName());
        }
        okrugleniye(umbrellas, 1000);
        printCsv("UmbrellaCsv", umbrellas);
    }
    public static void okrugleniye (Umbrella[] umbrellas, int chislo) {
        for (int i = 0; i < umbrellas.length; i++) {
            Umbrella umbrella = umbrellas[i];
            if(umbrella.getSalary() % chislo < 500) {
                umbrella = umbrella.withSalary(umbrella.getSalary() - umbrella.getSalary() % chislo);
            } else {
                umbrella = umbrella.withSalary(umbrella.getSalary() + (1000 - umbrella.getSalary() % chislo));
            }
            umbrellas[i] = umbrella;
            System.out.println(umbrella.getSalary());
        }
    }

    public static void printCsv(String filename, Umbrella[] umbrella) throws FileNotFoundException {
        PrintStream printer = new PrintStream(new File(filename));
        printer.println("name" + ";" + "surname" + ";" + "salary");
        for (int i = 0; i < umbrella.length; i++){
            Umbrella umbrellas = umbrella[i];
            printer.println(umbrellas.getName() + ";" + umbrellas.getSurname() + ";" + umbrellas.getSalary());
        }
    }
}

