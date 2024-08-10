package aston.course_project.sorting;

import java.util.ArrayList;
import java.util.List;

class EvenSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] array) {
        List<Integer> evenNumbers = new ArrayList<>();

        for (int number : array) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        int[] toSortArray = evenNumbers.stream().mapToInt(i -> i).toArray();

        Sorter.shellSort(toSortArray);

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = toSortArray[index++];
            }
        }
    }
}
