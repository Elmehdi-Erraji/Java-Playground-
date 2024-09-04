package src.OOP;

import java.sql.SQLOutput;

public class Car {

    protected String brand;
    protected String model;
    protected int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car() {

    }


    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }


    public void start(){
        System.out.println("the car is starting");
    }

    public void stop(){
        System.out.println("the car is stopping");
    }

    public static void main(String[] args) {
        Car car = new Car("Mercedes", "VW",2020);
        Car car1 = new Car("Mercedes", "VW");



        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getYear());


        System.out.println(car1.getBrand());
        System.out.println(car1.getModel());

        car.start();
        car.stop();
    }
}

