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

class Car {
    private Integer power;
    private String model;
    private Integer year;


    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    @Override
    public String toString() {
        return "Car: Model - " + model + ", Power - " + power + " HP, Year - " + year;
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

class Vegetable {
    private String type;
    private String color;
    private Double weight;

    public Vegetable(Builder builder) {
        this.color = builder.color;
        this.weight = builder.weight;
        this.type = builder.type;
    }

    @Override
    public String toString() {
        return "Vegetable: Type - " + type + ", Weight - " + weight + ", Color - " + color;
    }

    public static class Builder {
        private String color;
        private double weight;
        private String type;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Vegetable build() {
            return new Vegetable(this);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Book {
    private String author;
    private String title;
    private Integer pagesCount;

    public Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pagesCount = builder.pagesCount;
    }

    @Override
    public String toString() {
        return "Book: Title - " + title + ", Author - " + author + ", Count pages - " + pagesCount;
    }

    public static class Builder {
        private String author;
        private String title;
        private int pagesCount;

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder pagesCount(int pagesCount) {
            this.pagesCount = pagesCount;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getAuthor() {
        return author;
    }


    public String getTitle() {
        return title;
    }

    public int getPagesCount() {
        return pagesCount;
    }

}
