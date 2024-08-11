package aston.course_project.sorting;

import java.util.List;

import static java.util.Collections.swap;

public class ShellSort<T extends Comparable<? super T>> {
    public void sort(List<T> toSort){
        int n = toSort.size(); // Кол-во элементов

        // h - прыжок для выбора значения в подмножество
        for(int h = n / 2; h > 0; h /= 2){
            for(int i = h; i < n; i++){
                T key = toSort.get(i);
                int j = i;
                // Проверяем, если элемент key меньше элемента из своего подмножества, то сортируем вставкой
                while(j >= h && key.compareTo(toSort.get(j - h)) < 0){
                    swap(toSort, j, j-h);
                    j -= h;
                }
            }
        }
    }
}
