package src.OOP;

public class ElectricCar extends Car {
    public int batteryLife;

    public ElectricCar(String brand, String model, int year, int batteryLife) {
        super(brand, model,year);
        this.batteryLife = batteryLife;
    }

    @Override
    public void start() {
        System.out.println("The electric car is starting quietly");
    }

    public void changeBattery() {
        System.out.println("The electric car is changing the battery life");
    }

    public static void main(String[] args) {
        ElectricCar car = new ElectricCar("tesla","model S",2022,10);

        System.out.println(car.getBrand());
        car.start();
    }


}