package aston.course_project.sorting;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите вариант заполнения коллекции:");
            System.out.println("1. Заполнить из файла");
            System.out.println("2. Заполнить случайными числами");
            System.out.println("3. Заполнить вручную");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            if (choice == 4) { // Завершение работы программы
                exit = true;
            }
            System.out.println();


            System.out.println("Выберите вариант способа сортировки коллекции:");
            System.out.println("1. Сортировка всех элементов коллекции");
            System.out.println("2. Сортировка только четных или нечётных элементов коллекции");

            int isEvenOddSort = scanner.nextInt();
            System.out.println(isEvenOddSort);
            scanner.nextLine(); // Очистка буфера
            System.out.println();


            switch (choice) {
                case 1:
                    // Заполнение массива из файла
                    // Валидация данных
                    // Сортировка исходного массива
                    break;
                case 2:
                    System.out.println("Введите длину элементов коллекции:");
                    int lengthRandom = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    // Заполнение массива случайными числами
                    // Валидация данных
                    // Сортировка исходного массива
                    break;
                case 3:
                    System.out.println("Введите длину элементов коллекции:");
                    int lengthManual = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    // Заполнение массива вручную
                    // Валидация данных
                    // Сортировка исходного массива
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }

            if (!exit && isEvenOddSort == 1) {
                System.out.println("Введите элемент для поиска:");
                // Считывание элемента для поиска
                // Бинарный поиск в отсортированной коллекции
            }
        }

    }
}
