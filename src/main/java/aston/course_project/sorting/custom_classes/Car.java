package aston.course_project.sorting.custom_classes;


import aston.course_project.sorting.Parity;
import aston.course_project.sorting.exceptions.InvalidArgumentException;

public class Car implements Comparable<Car>, Parity {
    private final Integer power;
    private final String model;
    private final Integer year;


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

    @Override
    public boolean isOdd() {
        return power % 2 != 0;
    }


    public static class Builder {
        private final int power;
        private final String model;
        private final int year;

        public Builder(int power, String model, int yaer) throws InvalidArgumentException {
            if(power <= 0){
                throw new InvalidArgumentException("Поле мощность не может быть меньше или равно нулю");
            } else if(model.isEmpty()){
                throw new InvalidArgumentException("Поле модель не может быть пустым");
            } else if(yaer < 1885){
                throw new InvalidArgumentException("Поле год не может быть меньше 1885");
            }

            this.power = power;
            this.model = model;
            this.year = yaer;
        }

        public Car build() {
            return new Car(this);
        }
    }


    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
}


