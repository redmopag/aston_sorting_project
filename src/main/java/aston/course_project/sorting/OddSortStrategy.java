package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OddSortStrategy<T extends Parity & Comparable<? super T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        List<T> oddNumbers = new ArrayList<>();

        // Фильтруем нечетные числа
        for (T item : list) {
            if (item.isOdd()) { // Нечетное число
                oddNumbers.add(item);
            }
        }

        // Сортируем нечетные числа
        Collections.sort(oddNumbers);

        // Вставляем отсортированные нечетные числа обратно в исходный список
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isOdd()) { // Если нечетное
                list.set(i, oddNumbers.get(index++));
            }
        }
    }
}