package aston.course_project.sorting;

import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;
import aston.course_project.sorting.exceptions.InvalidArgumentException;
import aston.course_project.sorting.fill_array.ArrayFillOption;
import aston.course_project.sorting.fill_array.ArrayFromFileFillOption;
import aston.course_project.sorting.sort_strategy.EvenSortStrategy;
import aston.course_project.sorting.sort_strategy.OddSortStrategy;
import aston.course_project.sorting.sort_strategy.ShellSortStrategy;
import aston.course_project.sorting.sort_strategy.SortStrategy;
import aston.course_project.sorting.work_with_array.WorkWithArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final WorkWithArray workWithArray = new WorkWithArray();
    private static final Map<Integer, ArrayFillOption> arrayFactoryMap = new HashMap<>();
    private static final Map<Integer, SortStrategy> arraySortMap = new HashMap<>();

    public static void init(){
        arrayFactoryMap.put(1, new ArrayFromFileFillOption());

        arraySortMap.put(1, new ShellSortStrategy());
        arraySortMap.put(2, new EvenSortStrategy());
        arraySortMap.put(3, new OddSortStrategy());
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите вариант заполнения коллекции:");
            System.out.println("1. Заполнить из файла");
            System.out.println("2. Заполнить случайными числами");
            System.out.println("3. Заполнить вручную");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа
            if (choice == 4) { // Завершение работы программы
                break;
            } else if (choice == 1) {
                System.out.println("Введите путь до файла: ");
                String path = scanner.nextLine();

                workWithArray.setPath(path);
                ArrayFillOption currentFactory = arrayFactoryMap.get(choice);
                if(currentFactory instanceof ArrayFromFileFillOption){
                    ((ArrayFromFileFillOption) currentFactory).setPath(path);
                }
                workWithArray.setArrayFactory(currentFactory);
            } else{
                System.out.println("Введите класс, объекты которого заполнят массив:");
                System.out.println("Car");
                System.out.println("Book");
                System.out.println("Vegetable");

                workWithArray.setClassType(scanner.nextLine().toLowerCase());
                workWithArray.setArrayFactory(arrayFactoryMap.get(choice));
            }
            System.out.println();

            System.out.println("Введите длину массива:");

            int length = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
            System.out.println();
            try {
                workWithArray.setList(length);
            } catch (InvalidArgumentException e){
                System.out.println(e.getMessage());
            } catch (IOException e){
                System.out.println("Не удалось прочитать файл");
            }

            System.out.println("Выберите вариант способа сортировки коллекции:");
            System.out.println("1. Сортировка всех элементов коллекции");
            System.out.println("2. Сортировка только четных элементов коллекции");
            System.out.println("3. Сортировка только нечётных элементов коллекции");

            int sortChoice = scanner.nextInt();
            try {
                workWithArray.sortArray(arraySortMap.get(sortChoice));
            } catch (InvalidArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            if (sortChoice == 1) {
                try {
                    switch (workWithArray.getClassType().toLowerCase()) {
                        case "car" -> System.out.println("Результат бинарного поиска: " +
                                    workWithArray.binarySearch(getCar(scanner)));
                        case "book" -> System.out.println("Результат бинарного поиска: " +
                                workWithArray.binarySearch(getBook(scanner)));
                        case "vegetable" -> System.out.println("Результат бинарного поиска: " +
                                workWithArray.binarySearch(getVegetable(scanner)));
                    }
                } catch (InvalidArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        scanner.close();
    }

    private static Vegetable getVegetable(Scanner scanner) throws InvalidArgumentException{
        System.out.println("Корнеплод");
        System.out.println("Введите тип: ");
        String type = scanner.nextLine();
        System.out.println("Введите цвет: ");
        String color = scanner.nextLine();
        System.out.println("Введите вес: ");
        int weight = scanner.nextInt();

        return new Vegetable.Builder(color, weight, type).build();
    }

    private static Book getBook(Scanner scanner) throws InvalidArgumentException{
        System.out.println("Книга");
        System.out.println("Введите автора: ");
        String author = scanner.nextLine();
        System.out.println("Введите название: ");
        String title = scanner.nextLine();
        System.out.println("Введите кол-во страниц");
        int pagesCount = scanner.nextInt();

        return new Book.Builder(author, title, pagesCount).build();
    }

    private static Car getCar(Scanner scanner) throws InvalidArgumentException {
        System.out.println("Машина");
        System.out.println("Введите мощность: ");
        int power = scanner.nextInt();
        System.out.println("Введите модель машины: ");
        String model = scanner.nextLine();
        System.out.println("Введите год машины");
        int year = scanner.nextInt();

        return new Car.Builder(power, model, year).build();
    }
}
