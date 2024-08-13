package aston.course_project.sorting;

import java.util.List;

public class Sorter<T extends Parity & Comparable<? super T>> {
    private SortStrategy<T> strategy;

    public Sorter(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(List<T> list) {
        strategy.sort(list);
    }
}