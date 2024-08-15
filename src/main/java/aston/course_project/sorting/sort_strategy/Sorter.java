package aston.course_project.sorting.sort_strategy;

import aston.course_project.sorting.custom_classes.Parity;
import aston.course_project.sorting.exceptions.NoSortStrategyException;

import java.util.List;

public class Sorter {
    private SortStrategy sortStrategy;

    public Sorter(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public <T extends Parity & Comparable<? super T>> void sort(List<T> toSort) throws NoSortStrategyException {
        if(sortStrategy != null){
            sortStrategy.sort(toSort);
        } else {
            throw new NoSortStrategyException("Стратегия не установлена");
        }
    }
}
