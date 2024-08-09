package aston.course_project.sorting.castom_classes;

public class Root {
    private String color;
    private double weight;
    private String type;

    public Root(String color, double weight, String type) {
        this.color = color;
        this.weight = weight;
        this.type = type;
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
