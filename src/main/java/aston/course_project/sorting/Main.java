package aston.course_project.sorting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите вариант заполнения массива:");
            System.out.println("1. Заполнить из файла");
            System.out.println("2. Заполнить случайными числами");
            System.out.println("3. Заполнить вручную");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            switch (choice) {
                case 1:
                    // Заполнение массива из файла
                    // Валидация данных
                    // Сортировка исходного массива
                    break;
                case 2:
                    // Заполнение массива случайными числами
                    // Валидация данных
                    // Сортировка исходного массива
                    break;
                case 3:
                    // Заполнение массива вручную
                    // Валидация данных
                    // Сортировка исходного массива
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }

            if (!exit) {
                System.out.println("Введите элемент для поиска:");
                // Считывание элемента для поиска
                // Бинарный поиск в отсортированной коллекции
            }
        }
    }
}
