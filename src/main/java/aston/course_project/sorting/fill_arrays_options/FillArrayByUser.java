package aston.course_project.sorting.fill_arrays_options;

import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;
import aston.course_project.sorting.exceptions.InvalidArgumentException;
import aston.course_project.sorting.exceptions.InvalidTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillArrayByUser implements ArrayFillOption {
    private final Scanner scanner = new Scanner(System.in);

    private final String classType;

    public FillArrayByUser(String classType){
        this.classType = classType;
    }

    @Override
    public <K> List<K> fillArray(int n) throws InvalidArgumentException {
        List<K> objectList = new ArrayList<>(n);

        while (objectList.size() < n) {
            System.out.println("Введите q, чтобы закончить ввод. Чтобы продолжить введите любую другую букву: ");
            String choice = scanner.nextLine();
            if(choice.equals("q")){
                break;
            }

            try {
                K object = createObject(classType);
                if (object != null) {
                    objectList.add(object);
                }
            } catch (InvalidArgumentException e){
                System.out.println("Не удалось создать объект: " + e.getMessage());
            } catch (InvalidTypeException e){
                throw new InvalidArgumentException(e.getMessage());
            }
        }

        return objectList;
    }

    private <K> K createObject(String choice) throws InvalidArgumentException, InvalidTypeException {
        return switch (choice) {
            case "car" -> (K) createCar();
            case "book" -> (K) createVegetable();
            case "vegetable" -> (K) createBook();
            default -> throw new InvalidTypeException("Неверный тип объекта");
        };
    }

    private Car createCar() throws InvalidArgumentException {
        System.out.print("Введите модель машины: ");
        String model = scanner.nextLine();

        int power = getPositiveInteger("Введите мощность машины (HP): ");

        int year = getPositiveInteger("Введите год выпуска (например, 2020): ");

        return new Car.Builder(power, model, year).build();
    }

    private Vegetable createVegetable() throws InvalidArgumentException {
        System.out.print("Введите тип овоща: ");
        String type = scanner.nextLine();

        System.out.print("Введите цвет овоща: ");
        String color = scanner.nextLine();

        int weight = getPositiveInteger("Введите вес овоща (в кг): ");

        return new Vegetable.Builder(color, weight, type).build();
    }

    private Book createBook() throws InvalidArgumentException {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();

        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        int pagesCount = getPositiveInteger("Введите количество страниц: ");

        return new Book.Builder(author, title, pagesCount).build();
    }

    private int getPositiveInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            }
        }
    }
}

