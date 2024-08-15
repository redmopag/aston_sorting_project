package aston.course_project.sorting.sort_strategy;

import aston.course_project.sorting.custom_classes.Parity;

import java.util.ArrayList;
import java.util.List;

public class OddSortStrategy implements SortStrategy {
    @Override
    public <T extends Parity & Comparable<? super T>> void sort(List<T> list) {
        List<T> oddNumbers = new ArrayList<>();

        // Фильтруем нечетные числа
        for (T item : list) {
            if (item.isOdd()) { // Нечетное число
                oddNumbers.add(item);
            }
        }

        // Сортируем нечетные числа
        new ShellSortStrategy().sort(oddNumbers);

        // Вставляем отсортированные нечетные числа обратно в исходный список
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isOdd()) { // Если нечетное
                list.set(i, oddNumbers.get(index++));
            }
        }
    }
}