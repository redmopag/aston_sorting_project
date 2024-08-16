package aston.course_project.sorting.fill_array;

import aston.course_project.sorting.exceptions.InvalidArgumentException;

import java.util.List;

public interface ArrayFillOption {
    <K> List<K> fillArray(int n) throws InvalidArgumentException;
}
