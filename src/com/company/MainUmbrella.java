package com.company;

import javafx.print.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**заполнить эксель паспортными данными сотрудников (фио, серия, номер, зарплата)
 метод, который принимает массив сотрудников и округляет зарплату до 1000,
 метод, который печатает в файл
 заменить массивы на листы
 */

public class MainUmbrella {
    public static void main(String[] args) throws FileNotFoundException {
        List<Umbrella> umbrellas = new ArrayList<>(List.of(
                new Umbrella("Sofia", "Dickinson", 125689),
                new Umbrella("Greyson", "Steuber", 89852),
                new Umbrella("Itzel", "Corwin", 10360)
        ));
        for (int i = 0; i < umbrellas.size(); i++) {
            Umbrella umbrella = umbrellas.get(i);
            System.out.println(umbrella.getName());
        }
        okrugleniye(umbrellas, 1000);
        printCsv("UmbrellaCsv", umbrellas);
    }
    public static void okrugleniye (List<Umbrella> umbrellas, int chislo) {
        for (int i = 0; i < umbrellas.size(); i++) {
            System.out.println(umbrellas.get(i).getName());
            Umbrella umbrella = umbrellas.get(i);
            if(umbrella.getSalary() % chislo < 500) {
                umbrellas.set(i,umbrella.withSalary(umbrella.getSalary() - umbrella.getSalary() % chislo));
            } else {
                umbrellas.set(i, umbrella.withSalary(umbrella.getSalary() + (1000 - umbrella.getSalary() % chislo)));
            }
            System.out.println(umbrellas.get(i).getSalary());
        }
    }

    public static void printCsv(String filename, List<Umbrella> umbrellas) throws FileNotFoundException {
        PrintStream printer = new PrintStream(new File(filename));
        printer.println("name" + ";" + "surname" + ";" + "salary");
        for (int i = 0; i < umbrellas.size(); i++){
            Umbrella umbrella = umbrellas.get(i);
            printer.println(umbrella.getName() + ";" + umbrella.getSurname() + ";" + umbrella.getSalary());
        }
    }
}

