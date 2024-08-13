package aston.course_project.sorting;

import java.util.List;

public class BinarySearch<T> {

    //возвращает индекс элемента в списке
    //если нужного элемента нет - возвращает -1
    public int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        if (list.isEmpty()) {
            return -1;
        }
        int mid = list.size() / 2;
        int edge = list.size() - 1;
        if (list.get(0).compareTo(key) > 0 || list.get(edge).compareTo(key) < 0) {
            return -1;
        }
        while (!list.get(mid).equals(key)) {
            if ((edge - mid) == 1 && list.get(mid).compareTo(key) < 0 && list.get(edge).compareTo(key) > 0) {
                return -1;}
            if (list.get(mid).compareTo(key) < 0) {
                mid = (edge + (mid + 1)) / 2;
            } else {
                edge = mid;
                mid /= 2;
            }

            }
        return mid;
}
}
