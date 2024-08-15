package aston.course_project.sorting.FillArraysOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FillArrayRandom implements ArrayFillOption {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    @Override
    public <T> List<T> fillArray() throws Exception {

        System.out.print("Введите количество объектов, которые хотите создать: ");
        int capacity = scanner.nextInt();

        List<Object> arrayList = new ArrayList<>(capacity);

        System.out.println("Выберите класс для создания объекта:");
        System.out.println("1. Car");
        System.out.println("2. Vegetable");
        System.out.println("3. Book");

        int choice = scanner.nextInt();

        for (int i = 0; i < capacity; i++) {
            switch (choice) {
                case 1:

                    Car car = new Car.Builder()
                            .setPower(random.nextInt(300) + 1)
                            .setModel(getRandomModel())
                            .setYear(2000 + random.nextInt(24))
                            .build();
                    arrayList.add(car);
                    break;

                case 2:
                    Vegetable vegetable = new Vegetable.Builder()
                            .withColor(getRandomColor())
                            .withWeight((random.nextDouble() * 100))
                            .withType(getRandomType())
                            .build();
                    arrayList.add(vegetable);
                    break;

                case 3:

                    Book book = new Book.Builder()
                            .author(getRandomAuthor())
                            .title(getRandomTitle())
                            .pagesCount(random.nextInt(1000) + 1)
                            .build();
                    arrayList.add(book);
                    break;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    i--;
            }
        }

        System.out.println(arrayList);
        return (List<T>) arrayList;
    }

    private String getRandomModel() {
        String[] models = {"Mazda", "Toyota", "BMW", "Mercedes", "Porsche", "Ford", "Nissan", "Mitsubishi"};
        return models[random.nextInt(models.length)];
    }

    private String getRandomType() {
        String[] types = {"Potato", "Tomato", "Carrot", "Cabbage", "Pepper", "Cucumber"};
        return types[random.nextInt(types.length)];
    }

    private String getRandomColor() {
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple", "Orange", "White", "Black"};
        return colors[random.nextInt(colors.length)];
    }

    private String getRandomTitle() {
        String[] titles = {"Jenny Offill", "Michael Ian Black", "Ryan T. Higgins", "Doreen Cronin", "Eric Carle"};
        return titles[random.nextInt(titles.length)];
    }

    private String getRandomAuthor() {
        String[] authors = {"I’m Bored", "17 Things I’m Not Allowed to Do Anymore", "We Don’t Eat Our Classmates", "Click, Clack, Moo: Cows That Type", "The Very Hungry Caterpillar"};
        return authors[random.nextInt(authors.length)];
    }

    public static void main(String[] args) {
        FillArrayRandom fillArrayRandom = new FillArrayRandom();
        try {
            List<Object> resultList = fillArrayRandom.fillArray();
            for (Object obj : resultList) {
                System.out.println(obj.toString());
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}