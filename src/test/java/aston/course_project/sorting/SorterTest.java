package aston.course_project.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    private Sorter<Integer> sorter;

    @BeforeEach
    public void setUp() {
        sorter = new Sorter<Integer>(new EvenSortStrategy<>());
    }

    @Test
    public void testEvenSort() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 3, 8, 1, 4));
        sorter.sort(numbers);
        assertEquals(Arrays.asList(5, 2, 3, 4, 1, 8), numbers);
    }

    @Test
    public void testOddSort() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 3, 8, 1, 4));
        sorter.sort(numbers);

        sorter.setStrategy(new OddSortStrategy<>());
        sorter.sort(numbers);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 8), numbers);
    }

    @Test
    public void testEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        sorter.sort(numbers);
        assertEquals(new ArrayList<>(), numbers);
    }

    @Test
    public void testNoEvenNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        sorter.sort(numbers);
        assertEquals(Arrays.asList(1, 3, 5, 7, 9), numbers);
    }

    @Test
    public void testNoOddNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        sorter.sort(numbers);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), numbers);
    }
}