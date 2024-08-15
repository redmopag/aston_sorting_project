package aston.course_project.sorting.sort_strategy;

import aston.course_project.sorting.exceptions.NoSortStrategyException;

import java.util.List;

public class Sorter<T extends Comparable<? super T>> {
    private SortStrategy<T> sortStrategy;

    public Sorter(SortStrategy<T> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy<T> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void sort(List<T> toSort) throws NoSortStrategyException {
        if(sortStrategy != null){
            sortStrategy.sort(toSort);
        } else {
            throw new NoSortStrategyException("Стратегия не установлена");
        }
    }
}
