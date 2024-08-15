package aston.course_project.sorting.custom_classes;

import aston.course_project.sorting.Parity;

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
    public String toString() {
        return "Vegetable: Type - " + type + ", Weight - " + weight + ", Color - " + color;
    }

    @Override
    public boolean isOdd() {
        return weight % 2 != 0;
    }

    public static class Builder {
        private String color;
        private int weight;
        private String type;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
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
