package aston.course_project.sorting.sort_strategy;

import aston.course_project.sorting.custom_classes.Parity;

import java.util.ArrayList;
import java.util.List;

public class EvenSortStrategy implements SortStrategy {
    @Override
    public <T extends Parity & Comparable<? super T>> void sort(List<T> list) {
        List<T> evenNumbers = new ArrayList<>();

        // Фильтруем четные числа
        for (T item : list) {
            if (!item.isOdd()) { // Четное число
                evenNumbers.add(item);
            }
        }

        // Сортируем четные числа
        new ShellSortStrategy().sort(evenNumbers);

        // Вставляем отсортированные четные числа обратно в исходный список
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isOdd()) { // Если четное
                list.set(i, evenNumbers.get(index++));
            }
        }
    }
}