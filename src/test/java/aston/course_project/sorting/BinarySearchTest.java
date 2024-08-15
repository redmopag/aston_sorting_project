package aston.course_project.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

//пока что тесты без кастомных классов, после слияния изменю код тестов
public class BinarySearchTest {

    @Test
    public void binarySearchMethod() {
        //отсортированный список
        List<Integer> list = List.of(1, 2, 3);
        BinarySearch<Integer> bin = new BinarySearch<>();
        // возвращает -1, если нужного элемента нет
        Assertions.assertEquals(bin.binarySearch(list,7), -1);
        //возвращает индекс элемента из списка, который мы ищем
        Assertions.assertEquals(bin.binarySearch(list,1), 0);
    }
}
