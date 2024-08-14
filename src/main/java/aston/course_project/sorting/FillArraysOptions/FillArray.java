package aston.course_project.sorting.FillArraysOptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillArray implements ArrayFillOption {

    private List<Object> list;
    private Class<?> clazz;

    public FillArray() {
        list = new ArrayList<>();
        selectClass();
    }

    private void selectClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите класс для создания объектов:");
        System.out.println("1. Book");
        System.out.println("2. Car");
        System.out.println("3. Vegetable");
        System.out.println("0. Выход");

        int choice;
        while (true) {
            try {
                System.out.print("Введите номер класса: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        clazz = Book.class;
                        break;
                    case 2:
                        clazz = Car.class;
                        break;
                    case 3:
                        clazz = Vegetable.class;
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Некорректный ввод. Попробуйте еще раз.");
                        continue;
                }

                System.out.println("Выбранный класс: " + clazz.getSimpleName());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        fillArray();
    }

    @Override
    public List<Object> fillArray() {
        if (clazz == null) {
            throw new IllegalStateException("Класс не был установлен.");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Constructor<?>[] constructors = clazz.getDeclaredConstructors();
                Constructor<?> largestConstructor = constructors[0];

                for (Constructor<?> constructor : constructors) {
                    if (constructor.getParameterCount() > largestConstructor.getParameterCount()) {
                        largestConstructor = constructor;
                    }
                }

                Class<?>[] paramTypes = largestConstructor.getParameterTypes();
                Object[] params = new Object[paramTypes.length];

                Field[] fields = clazz.getDeclaredFields();
                for (int j = 0; j < paramTypes.length; j++) {
                    boolean validInput = false;
                    String inputTypeMessage = (paramTypes[j] == int.class) ? "целочисленное значение" :
                            (paramTypes[j] == double.class) ? "дробное значение" :
                                    (paramTypes[j] == boolean.class) ? "логическое значение" :
                                            paramTypes[j].getSimpleName();

                    while (!validInput) {
                        String fieldName = fields[j].getName();
                        System.out.printf("Введите значение для поля '%s' (%s) или 'Выйти' для завершения: ", fieldName, inputTypeMessage);
                        String inputValue = scanner.nextLine();

                        if (inputValue.equalsIgnoreCase("Выйти")) {
                            return list;
                        }

                        if (inputValue.trim().isEmpty()) {
                            System.out.println("Вы неверно ввели данные для поля '" + fieldName + "'. Ввод не должен быть пустым.");
                            continue;
                        }

                        try {
                            if (paramTypes[j] == int.class) {
                                params[j] = Integer.parseInt(inputValue);
                            } else if (paramTypes[j] == double.class) {
                                params[j] = Double.parseDouble(inputValue);
                            } else if (paramTypes[j] == boolean.class) {
                                params[j] = Boolean.parseBoolean(inputValue);
                            } else if (paramTypes[j] == String.class) {
                                params[j] = inputValue;
                            }
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Вы неверно ввели данные для поля '" + fieldName + "'. Пожалуйста, введите корректное значение.");
                        }
                    }
                }

                Object item = largestConstructor.newInstance(params);
                list.add(item);

            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
                System.out.println("Попробуйте снова ввести данные.");
            }
        }
    }

//        ВДРУГ ПОНАДОБИТСЯ
//    private void printList() {
//        System.out.println("Созданные объекты:");
//        for (Object obj : list) {
//            System.out.println(obj);
//        }
//    }
}

//class Car implements Comparable<Car> {
//    private Integer power;
//    private String model;
//    private Integer year;
//
//
//    private Car(Builder builder) {
//        this.power = builder.power;
//        this.model = builder.model;
//        this.year = builder.year;
//    }
//
//    @Override
//    public int compareTo(Car otherCar) {
//        int result = this.model.compareTo(otherCar.model);
//        if (result == 0) {
//            result = this.power.compareTo(otherCar.power);
//            if (result == 0) {
//                result = this.year.compareTo(otherCar.year);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Car: Model - " + model + ", Power - " + power + " HP, Year - " + year;
//    }
//
//
//    public static class Builder {
//        private int power;
//        private String model;
//        private int year;
//
//        public Builder setPower(int power) {
//            this.power = power;
//            return this;
//        }
//
//        public Builder setModel(String model) {
//            this.model = model;
//            return this;
//        }
//
//        public Builder setYear(int year) {
//            this.year = year;
//            return this;
//        }
//
//        public Car build() {
//            return new Car(this);
//        }
//    }
//
//
//    public int getPower() {
//        return power;
//    }
//
//    public void setPower(int power) {
//        this.power = power;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//}
//
//class Vegetable implements Comparable<Vegetable> {
//    private String type;
//    private String color;
//    private Double weight;
//
//    public Vegetable(Builder builder) {
//        this.color = builder.color;
//        this.weight = builder.weight;
//        this.type = builder.type;
//    }
//
//    @Override
//    public int compareTo(Vegetable otherVegetable) {
//        int result = this.type.compareTo(otherVegetable.type);
//        if (result == 0) {
//            result = this.weight.compareTo(otherVegetable.weight);
//            if (result == 0) {
//                result = this.color.compareTo(otherVegetable.color);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Vegetable: Type - " + type + ", Weight - " + weight + ", Color - " + color;
//    }
//
//    public static class Builder {
//        private String color;
//        private double weight;
//        private String type;
//
//        public Builder withColor(String color) {
//            this.color = color;
//            return this;
//        }
//
//        public Builder withWeight(double weight) {
//            this.weight = weight;
//            return this;
//        }
//
//        public Builder withType(String type) {
//            this.type = type;
//            return this;
//        }
//
//        public Vegetable build() {
//            return new Vegetable(this);
//        }
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//}
//
//class Book implements Comparable<Book> {
//    private String author;
//    private String title;
//    private Integer pagesCount;
//
//    public Book(Builder builder) {
//        this.author = builder.author;
//        this.title = builder.title;
//        this.pagesCount = builder.pagesCount;
//    }
//
//    @Override
//    public int compareTo(Book otherBook) {
//        int result = this.author.compareTo(otherBook.author);
//        if (result == 0) {
//            result = this.title.compareTo(otherBook.title);
//            if (result == 0) {
//                result = this.pagesCount.compareTo(otherBook.pagesCount);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Book: Title - " + title + ", Author - " + author + ", Count pages - " + pagesCount;
//    }
//
//    public static class Builder {
//        private String author;
//        private String title;
//        private int pagesCount;
//
//        public Builder author(String author) {
//            this.author = author;
//            return this;
//        }
//
//        public Builder title(String title) {
//            this.title = title;
//            return this;
//        }
//
//        public Builder pagesCount(int pagesCount) {
//            this.pagesCount = pagesCount;
//            return this;
//        }
//
//        public Book build() {
//            return new Book(this);
//        }
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setPagesCount(int pagesCount) {
//        this.pagesCount = pagesCount;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public int getPagesCount() {
//        return pagesCount;
//    }
//
//}