package aston.course_project.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CarTest implements Parity, Comparable<CarTest> {
    private int speed;

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
    public void testEvenSort() {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(3),
                new CarTest(1),
                new CarTest(8),
                new CarTest(12),
                new CarTest(7),
                new CarTest(4)
        ));

        Sorter<CarTest> sorter = new Sorter<CarTest>(new EvenSortStrategy<>());
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
    public void testOddSort() {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(8),
                new CarTest(3),
                new CarTest(1),
                new CarTest(12),
                new CarTest(9),
                new CarTest(5)
        ));

        Sorter<CarTest> sorter = new Sorter<CarTest>(new OddSortStrategy<>());
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
    public void testCombinedSort() {
        List<CarTest> speed = new ArrayList<>(Arrays.asList(
                new CarTest(5),
                new CarTest(12),
                new CarTest(3),
                new CarTest(6),
                new CarTest(9),
                new CarTest(18)
        ));

        Sorter<CarTest> evenSorter = new Sorter<CarTest>(new EvenSortStrategy<>());
        evenSorter.sort(speed);

        Sorter<CarTest> oddSorter = new Sorter<CarTest>(new OddSortStrategy<>());
        oddSorter.sort(speed);

        List<CarTest> expected = Arrays.asList(
                new CarTest(3),
                new CarTest(6),
                new CarTest(5),
                new CarTest(12),
                new CarTest(9),
                new CarTest(18)
        );

        assertArrayEquals(expected.toArray(), speed.toArray());
    }
}