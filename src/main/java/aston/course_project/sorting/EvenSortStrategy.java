package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EvenSortStrategy<T extends Comparable<? super T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        List<T> evenNumbers = new ArrayList<>();

        for (T number : list) {
            if (isEven((Integer) number)) {
                evenNumbers.add(number);
            }
        }

        Collections.sort(evenNumbers);

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isEven((Integer) list.get(i))) {
                list.set(i, evenNumbers.get(index++));
            }
        }
    }

    private boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}
