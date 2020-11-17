package javaclasses;

import java.util.Objects;

public class Car {

    private static int id=0;
    private final String brand;
    private final String model;
    private String color;
    private final int yearOfIssue;
    private long price;
    private String regNumber;

    public Car(String brand, String model, String color, int yearOfIssue, long price, String regNumber) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfIssue = yearOfIssue;
        this.price = price;
        this.regNumber = regNumber;
        id++;
    }

    public Car(String brand, String model, String color, int yearOfIssue) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfIssue = yearOfIssue;
        id++;
    }

    public Car(String brand, String model, String color, int yearOfIssue, long price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfIssue = yearOfIssue;
        this.price = price;
        id++;
    }

    public static int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "java_classes.Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", price=" + price +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfIssue == car.yearOfIssue &&
                brand.equals(car.brand) &&
                model.equals(car.model) &&
                color.equals(car.color) &&
                Objects.equals(regNumber, car.regNumber);
    }

    @Override
    public int hashCode() {
        int result = 17 * id+Objects.hash(brand, model, color, yearOfIssue, price, regNumber);
        result=17*result+yearOfIssue;
        return result;
    }

}
