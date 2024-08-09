package aston.course_project.sorting.custom_classes;

public class Vegetable {
    private String color;
    private double weight;
    private String type;

    public Vegetable(Builder builder) {
        this.color = builder.color;
        this.weight = builder.weight;
        this.type = builder.type;
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
