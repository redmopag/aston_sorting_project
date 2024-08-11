package aston.course_project.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShellSortTest {
    @Test
    public void shellSortTest(){
        Integer[] actual = {5, 1, 3, -2, 10, -7};
        Integer[] expected = {-7, -2, 1, 3, 5, 10};

        List<Integer> listActual = Arrays.asList(actual);
        List<Integer> listExpected = Arrays.asList(expected);

        ShellSort<Integer> shellSort = new ShellSort<>();
        shellSort.sort(listActual);

        assertEquals(listExpected, listActual);
    }
}
