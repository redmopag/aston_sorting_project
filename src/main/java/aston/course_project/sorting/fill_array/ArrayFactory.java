package aston.course_project.sorting.fill_array;

import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;
import aston.course_project.sorting.exceptions.InvalidArgumentException;

import java.util.List;

public interface ArrayFactory {
    <K> List<K> fillArray(int n) throws InvalidArgumentException;
}
