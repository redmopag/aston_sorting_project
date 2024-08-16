package aston.course_project.sorting.FillArraysOptions;

import aston.course_project.sorting.exceptions.InvalidTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FillArrayRandom implements ArrayFillOption {
    private final Random random = new Random();

    private String classType;

    public void setClassType(String classType){
        this.classType = classType;
    }

    @Override
    public <T> List<T> fillArray(int n) throws InvalidTypeException {
        List<Object> arrayList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            switch (classType) {
                case "car":
                    Car car = new Car.Builder()
                            .setPower(random.nextInt(300) + 1)
                            .setModel(getRandomModel())
                            .setYear(2000 + random.nextInt(24))
                            .build();
                    arrayList.add(car);
                    break;

                case "vegetable":
                    Vegetable vegetable = new Vegetable.Builder()
                            .withColor(getRandomColor())
                            .withWeight((random.nextDouble() * 100))
                            .withType(getRandomType())
                            .build();
                    arrayList.add(vegetable);
                    break;

                case "book":

                    Book book = new Book.Builder()
                            .author(getRandomAuthor())
                            .title(getRandomTitle())
                            .pagesCount(random.nextInt(1000) + 1)
                            .build();
                    arrayList.add(book);
                    break;

                default:
                    throw new InvalidTypeException("Указанный тип объекта не поддерживается");
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
}