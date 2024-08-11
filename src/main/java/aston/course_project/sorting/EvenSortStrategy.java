package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.List;

class EvenSortStrategy implements SortStrategy {
    @Override
    public void sort(NumberWrapper[] array) {
        List<NumberWrapper> evenNumbers = new ArrayList<>();

        for (NumberWrapper number : array) {
            if (number.getValue() % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        NumberWrapper[] toSortArray = evenNumbers.toArray(new NumberWrapper[0]);

        Sorter.shellSort(toSortArray);

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getValue() % 2 == 0) {
                array[i] = toSortArray[index++];
            }
        }
    }
}
