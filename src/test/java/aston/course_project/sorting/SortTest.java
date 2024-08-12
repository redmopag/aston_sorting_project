package aston.course_project.sorting;

import aston.course_project.sorting.exceptions.NoSortStrategyException;
import aston.course_project.sorting.sort_strategy.ShellSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import aston.course_project.sorting.sort_strategy.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    List<Integer> listActual;
    List<Integer> listExpected;

    public void listCreate(){
        Integer[] actual = {5, 1, 3, -2, 10, -7};
        Integer[] expected = {-7, -2, 1, 3, 5, 10};

        listActual = Arrays.asList(actual);
        listExpected = Arrays.asList(expected);
    }

    @Test
    public void shellSortTest(){
        listCreate();

        ShellSort<Integer> shellSort = new ShellSort<>();
        shellSort.sort(listActual);

        assertEquals(listExpected, listActual);
    }

    @Test
    public void sortStrategyTest() throws NoSortStrategyException {
        listCreate();

        Sort<Integer> sort = new Sort<>(new ShellSort<Integer>());
        sort.sort(listActual);

        assertEquals(listExpected, listActual);
    }
}
