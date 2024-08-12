package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EvenSortStrategy<T extends IntegerProvider & Comparable<? super T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        List<T> evenNumbers = new ArrayList<>();

        for (T item : list) {
            if (isEven(item.getIntegerValue())) {
                evenNumbers.add(item);
            }
        }

        Collections.sort(evenNumbers);

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isEven(list.get(i).getIntegerValue())) {
                list.set(i, evenNumbers.get(index++));
            }
        }
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}