package aston.course_project.sorting.castom_classes;

public class Car {
    private int power;
    private int yearCreate;
    private String model;

    public Car(int power, int yearCreate, String model) {
        this.power = power;
        this.yearCreate = yearCreate;
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYearCreate() {
        return yearCreate;
    }

    public void setYearCreate(int yearCreate) {
        this.yearCreate = yearCreate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
