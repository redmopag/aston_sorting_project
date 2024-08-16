package aston.course_project.sorting.custom_classes;

import aston.course_project.sorting.exceptions.InvalidArgumentException;

import java.util.Objects;

public class Vegetable implements Comparable<Vegetable>, Parity {
    private final String type;
    private final String color;
    private final int weight;

    private Vegetable(Builder builder) {
        this.color = builder.color;
        this.weight = builder.weight;
        this.type = builder.type;
    }

    @Override
    public int compareTo(Vegetable otherVegetable) {
        int result = this.type.compareTo(otherVegetable.type);
        if (result == 0) {
            result = this.weight - otherVegetable.weight;
            if (result == 0) {
                result = this.color.compareTo(otherVegetable.color);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return weight == vegetable.weight && Objects.equals(type, vegetable.type) && Objects.equals(color, vegetable.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, weight);
    }

    @Override
    public String toString() {
        return "Vegetable: Type - " + type + ", Weight - " + weight + ", Color - " + color;
    }

    @Override
    public boolean isOdd() {
        return weight % 2 != 0;
    }

    public static class Builder {
        private final String color;
        private final int weight;
        private final String type;

        public Builder(String color, int weight, String type) throws InvalidArgumentException {
            if(color.isEmpty()){
                throw new InvalidArgumentException("Поле цвет не может быть пустым");
            } else if(type.isEmpty()){
                throw new InvalidArgumentException("Поле тип не может быть пустым");
            } else if(weight <= 0){
                throw new InvalidArgumentException("Поле вес не может быть меньше или равно нулю");
            }

            this.color = color;
            this.weight = weight;
            this.type = type;
        }

        public Vegetable build() {
            return new Vegetable(this);
        }
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
