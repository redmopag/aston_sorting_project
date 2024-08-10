package aston.course_project.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class BinarySearch<T> {
    public int bin (List<? extends T> list, T key, Comparator<? super T> comparator) {
        return Collections.binarySearch(list, key, comparator);
    }
}
