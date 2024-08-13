package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EvenSortStrategy<T extends Parity & Comparable<? super T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        List<T> evenNumbers = new ArrayList<>();

        // Фильтруем четные числа
        for (T item : list) {
            if (!item.isOdd()) { // Четное число
                evenNumbers.add(item);
            }
        }

        // Сортируем четные числа
        Collections.sort(evenNumbers);

        // Вставляем отсортированные четные числа обратно в исходный список
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isOdd()) { // Если четное
                list.set(i, evenNumbers.get(index++));
            }
        }
    }
}