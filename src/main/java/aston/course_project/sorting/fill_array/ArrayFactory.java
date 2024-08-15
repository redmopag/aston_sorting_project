package aston.course_project.sorting.fill_array;

import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;

import java.util.List;

public interface ArrayFactory {
    List<Car> createCarList(int n);
    List<Book> createBookList(int n);
    List<Vegetable> createVegetableList(int n);
}
