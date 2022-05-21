package edu.umb.cs681.hw16;

import java.util.ArrayList;



public class Car {
    private String make, model;
    private int mileage, year;
    private double price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }



    public void setDominationCount(ArrayList<Car> usedCars) {
        for (Car car : usedCars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
    }

    public int getDominationCount() {
        return dominationCount;
    }
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("benz","GLA", 2022, 11, 59500);
        Car car2 = new Car("audi", "A4", 2021, 15, 79500);
        Car car3 = new Car("ford", "150", 2019, 10, 35000);
        Car car4 = new Car("bmw","M3", 2016, 5, 50000);
        Car car5 = new Car("jeep", "compass",2020, 12, 12040);
        
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        double minimum = cars.stream().mapToDouble(Car::getPrice).min().getAsDouble();
        System.out.println("Minimum price of the car, " + minimum);


        double maximum= cars.stream().mapToDouble(Car::getPrice).max().getAsDouble();
        System.out.println("Maximum price of the car, " + maximum);

        Integer carMakerNum = cars.stream()
                .parallel()
                .map( (Car car)-> car.getMake() )
                .reduce(0, (result,carMaker)-> ++result,
                        (finalResult,intermediateResult) -> finalResult + intermediateResult );
        System.out.println("Number of Car maker : " + carMakerNum);
        Integer carModelNum = cars.stream()
                .parallel()
                .map( (Car car)-> car.getModel() )
                .reduce(0, (result,carMaker)-> ++result,
                        (finalResult,intermediateResult) -> finalResult + intermediateResult );
        System.out.println("Number of car models: " + carModelNum);

        Integer averagePrice = cars.stream().parallel().map(car-> car.getPrice()).reduce(new int[2], (result, price) ->{
            double average = Math.round((result[0] * result[1] + price)/(result[0]+1));
            result[0]++;
            result[1] = (int) average;
            return result;},(finalResult, intermediateResult) -> finalResult)[1];

        System.out.println("Average price of cars: " + averagePrice);

    }
}
