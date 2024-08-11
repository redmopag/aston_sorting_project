package aston.course_project.sorting.sort_strategy;

import java.util.List;

public class Sort<T extends Comparable<? super T>> {
    private SortStrategy<T> sortStrategy;

    public Sort(SortStrategy<T> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void setSort(SortStrategy<T> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void sort(List<T> toSort){
        if(sortStrategy != null){
            sortStrategy.sort(toSort);
        }
    }
}
