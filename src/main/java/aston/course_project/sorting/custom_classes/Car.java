package aston.course_project.sorting.custom_classes;


public class Car implements Comparable<Car> {
    private Integer power;
    private String model;
    private Integer year;


    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    @Override
    public int compareTo(Car otherCar) {
        int result = this.model.compareTo(otherCar.model);
        if (result == 0) {
            result = this.power.compareTo(otherCar.power);
            if (result == 0) {
                result = this.year.compareTo(otherCar.year);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Car: Model - " + model + ", Power - " + power + " HP, Year - " + year;
    }


    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}


