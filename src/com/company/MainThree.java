package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * создать массив сотрудников,
 * создать массив настроек
 * создать метод нахождения строки в массиве
 * создать метод, который запишет в файл с заданным именем в зависимости от настроек и зарплаты
 */

public class MainThree {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeNft[] employeeNfts = new EmployeeNft[] {
                new EmployeeNft("Тимур", "Забиров", 120000),
                new EmployeeNft("Алексей", "Тамбовцев", 80000),
                new EmployeeNft("Иван", "Попко", 60000)
        };
        String[] settings = new String[] {
                "name",
//                "surname",
                "salary"
        };
        reportNft("reportNft.csv", employeeNfts, settings, 65000);
    }
    public static boolean findDirector (String director, String[] settings) {
      for (int i = 0; i < settings.length; i++)  {
          if(settings[i].equals(director)) {
              return true;
          }
        }
      return false;
    }
    public static void reportNft(String fileName, EmployeeNft[] employeeNfts, String[] settings, int minSalary) throws FileNotFoundException {
        PrintStream preanter = new PrintStream(new File(fileName));
        if (findDirector("name", settings)) {
            preanter.print("name;");
        }
        if (findDirector("surname", settings)) {
            preanter.print("surname;");
        }
        if (findDirector("salary", settings)) {
            preanter.print("salary");
        }
        preanter.println();
        for(int i = 0; i < employeeNfts.length; i ++) {
            EmployeeNft employeeNft = employeeNfts[i];
            if(employeeNft.getSalary() > minSalary) {
                if (findDirector("name", settings)) {
                 preanter.print(employeeNft.getName());
                 preanter.print(";");
                }
                if (findDirector("surname", settings)) {
                 preanter.print(employeeNft.getSurname());
                 preanter.print(";");
                }
                if (findDirector("salary", settings)) {
                    preanter.print(employeeNft.getSalary());
                }
                preanter.println();
            }
        }
    }
}
