package aston.course_project.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class BinarySearch<T> {

    //возвращает индекс элемента в списке
    //если нужного элемента нет - возвращает -1
    public int binarySearch(List<? extends T> list, T key, Comparator<T> comparator) {
        if (!list.contains(key))
            return -1;
        return Collections.binarySearch(list, key, comparator);
    }
}
