package aston.course_project.sorting.custom_classes;

public class Vegetable implements Comparable<Vegetable> {
    private String type;
    private String color;
    private Double weight;

    public Vegetable(Builder builder) {
        this.color = builder.color;
        this.weight = builder.weight;
        this.type = builder.type;
    }

    @Override
    public int compareTo(Vegetable otherVegetable) {
        int result = this.type.compareTo(otherVegetable.type);
        if (result == 0) {
            result = this.weight.compareTo(otherVegetable.weight);
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

    public static class Builder {
        private String color;
        private double weight;
        private String type;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withWeight(double weight) {
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

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
