package aston.course_project.sorting;

import java.util.Objects;

class CarTest implements IntegerProvider, Comparable<CarTest> {
    private int speed;

    public CarTest(int speed) {
        this.speed = speed;
    }

    @Override
    public int getIntegerValue() {
        return speed;
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
