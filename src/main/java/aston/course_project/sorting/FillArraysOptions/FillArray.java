package aston.course_project.sorting.FillArraysOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillArray implements ArrayFillOption {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public <K> List<K> fillArray() throws Exception {
        System.out.print("Введите количество объектов, которые хотите создать: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        List<K> objectList = new ArrayList<>(capacity);

        while (objectList.size() < capacity) {
            System.out.println("Выберите класс для создания объекта:");
            System.out.println("1 - Car");
            System.out.println("2 - Vegetable");
            System.out.println("3 - Book");
            System.out.println("Введите 'Выйти' для завершения ввода.");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Выйти")) {
                break;
            }

            while (true) {
                K object = createObject(choice);
                if (object != null) {
                    objectList.add(object);
                }

                if (objectList.size() == capacity) {
                    break;
                }
            }
        }

        System.out.println(objectList);
        return objectList;
    }

    private <K> K createObject(String choice) {
        switch (choice) {
            case "1":
                return (K) createCar();
            case "2":
                return (K) createVegetable();
            case "3":
                return (K) createBook();
            default:
                return null;
        }
    }

    private Car createCar() {
        Car.Builder builder = new Car.Builder();
        System.out.print("Введите модель машины (или 'Выйти' для отмены): ");
        String model = scanner.nextLine();
        if (model.equalsIgnoreCase("Выйти")) return null;

        builder.setModel(model);

        int power = getPositiveInteger("Введите мощность машины (HP): ");
        builder.setPower(power);

        int year = getPositiveInteger("Введите год выпуска (например, 2020): ");
        builder.setYear(year);

        return builder.build();
    }

    private Vegetable createVegetable() {
        Vegetable.Builder builder = new Vegetable.Builder();
        System.out.print("Введите тип овоща (или 'Выйти' для отмены): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("Выйти")) return null;

        builder.withType(type);

        String color = getNonEmptyString("Введите цвет овоща: ");
        builder.withColor(color);

        double weight = getPositiveDouble("Введите вес овоща (в кг): ");
        builder.withWeight(weight);

        return builder.build();
    }

    private Book createBook() {
        Book.Builder builder = new Book.Builder();
        System.out.print("Введите название книги (или 'Выйти' для отмены): ");
        String title = scanner.nextLine();
        if (title.equalsIgnoreCase("Выйти")) return null;

        builder.title(title);

        String author = getNonEmptyString("Введите автора книги: ");
        builder.author(author);

        int pagesCount = getPositiveInteger("Введите количество страниц: ");
        builder.pagesCount(pagesCount);

        return builder.build();
    }

    private int getPositiveInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Число должно быть положительным. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            }
        }
    }

    private double getPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Число должно быть положительным. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            }
        }
    }

    private String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            if (!value.trim().isEmpty()) {
                return value;
            } else {
                System.out.println("Это поле не может быть пустым. Попробуйте снова.");
            }
        }
    }
}

