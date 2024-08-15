package aston.course_project.sorting.sort_strategy;

import aston.course_project.sorting.custom_classes.Parity;

import java.util.List;

public interface SortStrategy {
    <T extends Parity & Comparable<? super T>> void sort(List<T> toSort);
}
