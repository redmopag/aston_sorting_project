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
    public <T> List<T> fillArray(int n) throws InvalidArgumentException {
        List<T> list = new ArrayList<>(n);

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            String line = reader.readLine().toLowerCase();
            if(line.equals("car")){
                do {
                    int power = Integer.parseInt(reader.readLine().split(": ")[1]);
                    String model = reader.readLine().split(": ")[1];
                    int year = Integer.parseInt(reader.readLine().split(": ")[1]);

                    list.add((T) new Car.Builder(power, model, year).build());

                    reader.readLine();
                } while(reader.readLine() != null && n-- > 0);
            } else if(line.equals("book")){
                do{
                    String author = reader.readLine().split(": ")[1];
                    String title = reader.readLine().split(": ")[1];
                    int pagesCount = Integer.parseInt(reader.readLine().split(": ")[1]);

                    list.add((T) new Book.Builder(author, title, pagesCount).build());

                    reader.readLine();
                } while(reader.readLine() != null && n-- > 0);
            } else if(line.equals("vegetable")){
                do {
                    String color = reader.readLine().split(": ")[1];
                    String type = reader.readLine().split(": ")[1];
                    int weight = Integer.parseInt(reader.readLine().split(": ")[1]);

                    list.add((T) new Vegetable.Builder(color, weight, type).build());

                    reader.readLine();
                } while(reader.readLine() != null && n-- > 0);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        }

        return list;
    }
}
