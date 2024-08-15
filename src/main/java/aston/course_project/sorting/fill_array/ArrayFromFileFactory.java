package aston.course_project.sorting.fill_array;

import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;
import aston.course_project.sorting.exceptions.InvalidArgumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArrayFromFileFactory implements ArrayFactory {

    String path;

    public void setPath(String path){
        this.path = path;
    }

    @Override
    public List<Car> createCarList(int n) {
        List<Car> carList = new ArrayList<>(n);

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            while(reader.readLine() != null){
                int power = Integer.parseInt(reader.readLine().split(": ")[1]);
                String model = reader.readLine().split(": ")[1];
                int year = Integer.parseInt(reader.readLine().split(": ")[1]);

                carList.add(new Car.Builder(power, model, year).build());

                reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        } catch (InvalidArgumentException e) {
            System.out.println("Не удалось создать объект класса Car: " + e.getMessage());
        }

        return carList;
    }

    @Override
    public List<Book> createBookList(int n) {
        List<Book> bookList = new ArrayList<>(n);

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            while(reader.readLine() != null){
                String author = reader.readLine().split(": ")[1];
                String title = reader.readLine().split(": ")[1];
                int pagesCount = Integer.parseInt(reader.readLine().split(": ")[1]);

                bookList.add(new Book.Builder(author, title, pagesCount).build());

                reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        } catch (InvalidArgumentException e) {
            System.out.println("Не удалось создать объект класса Car: " + e.getMessage());
        }

        return bookList;
    }

    @Override
    public List<Vegetable> createVegetableList(int n) {
        List<Vegetable> vegetableList = new ArrayList<>(n);

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            while(reader.readLine() != null){
                String color = reader.readLine().split(": ")[1];
                String type = reader.readLine().split(": ")[1];
                int weight = Integer.parseInt(reader.readLine().split(": ")[1]);

                vegetableList.add(new Vegetable.Builder(color, weight, type).build());

                reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        } catch (InvalidArgumentException e) {
            System.out.println("Не удалось создать объект класса Car: " + e.getMessage());
        }

        return vegetableList;
    }
}
