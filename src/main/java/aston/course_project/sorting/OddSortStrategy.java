package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OddSortStrategy<T extends IntegerProvider & Comparable<? super T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        List<T> oddNumbers = new ArrayList<>();

        for (T item : list) {
            if (isOdd(item.getIntegerValue())) {
                oddNumbers.add(item);
            }
        }

        Collections.sort(oddNumbers);

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isOdd(list.get(i).getIntegerValue())) {
                list.set(i, oddNumbers.get(index++));
            }
        }
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}