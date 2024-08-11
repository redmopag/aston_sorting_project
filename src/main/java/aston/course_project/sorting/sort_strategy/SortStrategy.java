package aston.course_project.sorting.sort_strategy;

import java.util.List;

public interface SortStrategy<T extends Comparable<? super T>> {
    void sort(List<T> toSort);
}
