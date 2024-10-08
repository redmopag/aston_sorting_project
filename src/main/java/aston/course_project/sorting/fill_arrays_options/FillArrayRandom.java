package aston.course_project.sorting.fill_arrays_options;

import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;
import aston.course_project.sorting.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillArrayRandom implements ArrayFillOption {
    private final Random random = new Random();

    private final String classType;

    public FillArrayRandom(String classType){
        this.classType = classType;
    }

    @Override
    public <T> List<T> fillArray(int n) throws InvalidArgumentException {
        List<Object> arrayList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            switch (classType) {
                case "car":
                    Car car = new Car.Builder(random.nextInt(300) + 1,
                            getRandomModel(), 2000 + random.nextInt(24))
                            .build();
                    arrayList.add(car);
                    break;

                case "vegetable":
                    Vegetable vegetable = new Vegetable.Builder(getRandomColor(),
                            (random.nextInt() * 100), getRandomType())
                            .build();
                    arrayList.add(vegetable);
                    break;

                case "book":

                    Book book = new Book.Builder(getRandomAuthor(), getRandomTitle(),
                            random.nextInt(1000) + 1)
                            .build();
                    arrayList.add(book);
                    break;

                default:
                    throw new InvalidArgumentException("Указанный тип объекта не поддерживается");
            }
        }

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