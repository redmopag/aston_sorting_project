package aston.course_project.sorting;

import aston.course_project.sorting.exceptions.NoSortStrategyException;
import aston.course_project.sorting.sort_strategy.EvenSortStrategy;
import aston.course_project.sorting.sort_strategy.OddSortStrategy;
import aston.course_project.sorting.sort_strategy.ShellSortStrategy;
import aston.course_project.sorting.sort_strategy.Sorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CarTest implements Parity, Comparable<CarTest> {
    private final int speed;

    public CarTest(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean isOdd() {
        return speed % 2 != 0;
    }

    @Override
    public int compareTo(CarTest carTest) {
        return Integer.compare(this.speed, carTest.speed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarTest carTest = (CarTest) o;
        return speed == carTest.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }
}


class SorterTest {

    @Test
    public void testEvenSort() throws NoSortStrategyException {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(3),
                new CarTest(1),
                new CarTest(8),
                new CarTest(12),
                new CarTest(7),
                new CarTest(4)
        ));

        Sorter sorter = new Sorter(new EvenSortStrategy());
        sorter.sort(speed);

        List<CarTest> expected = Arrays.asList(
                new CarTest(3),
                new CarTest(1),
                new CarTest(4),
                new CarTest(8),
                new CarTest(7),
                new CarTest(12)
        );

        assertArrayEquals(expected.toArray(), speed.toArray());
    }

    @Test
    public void testOddSort() throws NoSortStrategyException {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(8),
                new CarTest(3),
                new CarTest(1),
                new CarTest(12),
                new CarTest(9),
                new CarTest(5)
        ));

        Sorter sorter = new Sorter(new OddSortStrategy());
        sorter.sort(speed);

        List<CarTest> expected = Arrays.asList(
                new CarTest(8),
                new CarTest(1),
                new CarTest(3),
                new CarTest(12),
                new CarTest(5),
                new CarTest(9)
        );

        assertArrayEquals(expected.toArray(), speed.toArray());
    }

    @Test
    public void testCombinedSort() throws NoSortStrategyException {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(5),
                new CarTest(12),
                new CarTest(3),
                new CarTest(6),
                new CarTest(9),
                new CarTest(18)
        ));

        List<CarTest> expected = Arrays.asList(
                new CarTest(3),
                new CarTest(6),
                new CarTest(5),
                new CarTest(12),
                new CarTest(9),
                new CarTest(18)
        );

        Sorter evenSorter = new Sorter(new EvenSortStrategy());
        evenSorter.sort(speed);

        Sorter oddSorter = new Sorter(new OddSortStrategy());
        oddSorter.sort(speed);

        assertArrayEquals(expected.toArray(), speed.toArray());
    }

    @Test
    public void shellSortTest() throws NoSortStrategyException {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(5),
                new CarTest(12),
                new CarTest(3),
                new CarTest(6),
                new CarTest(9),
                new CarTest(18)
        ));

        List<CarTest> expected = Arrays.asList(
                new CarTest(3),
                new CarTest(5),
                new CarTest(6),
                new CarTest(9),
                new CarTest(12),
                new CarTest(18)
        );

        Sorter shellSort = new Sorter(new ShellSortStrategy());
        shellSort.sort(speed);

        assertArrayEquals(expected.toArray(), speed.toArray());
    }
}