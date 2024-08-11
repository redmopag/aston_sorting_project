package aston.course_project.sorting;

class NumberWrapper implements Comparable<NumberWrapper> {
    private int value;

    public NumberWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(NumberWrapper other) {
        return Integer.compare(this.value, other.value);
    }
}
