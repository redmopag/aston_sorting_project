package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OddSortStrategy<T extends Comparable<? super T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        List<T> oddNumbers = new ArrayList<>();

        for (T number : list) {
            if (isOdd((Integer) number)) {
                oddNumbers.add(number);
            }
        }

        Collections.sort(oddNumbers);

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isOdd((Integer) list.get(i))) {
                list.set(i, oddNumbers.get(index++));
            }
        }
    }

    private boolean isOdd(Integer number) {
        return number % 2 != 0;
    }
}
