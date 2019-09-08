package com.company;
/**создать метод, который печатает human
 * чтобы вместо переменной вставить ее значение, надо навести курсор на то место, куда хочешь вставить переменную
 * и нажать ctr+alt+n, вместо переменной ulya будет new Human
*/
public class MainTwo {
    public static void main(String[] args) {
        Human ilya = new Human("Илья", "Сазонов", "Михайлович");
        printHuman(new Human("Юлия", "Гордеева", "Валентиновна"));
        printHuman(ilya);
        Human[] humans = new Human[]{new Human("Юлия", "Гордеева", "Валентиновна"), ilya};
        for (int i = 0; i < humans.length; i++) {
            printHuman(humans[i]);
        }
    }

    public static void printHuman(Human humans) {
        System.out.println(humans.getName() + ";" + humans.getPatronymic() + ";" + humans.getSurname());
    }
}
