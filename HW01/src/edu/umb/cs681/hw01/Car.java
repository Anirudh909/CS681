package edu.umb.cs681.hw01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Car {
        private String make, model;
        private int mileage, year;
        private float price;
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

        public float getPrice() {
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

            cars.forEach((Car car) -> car.setDominationCount(cars));

            List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());
            List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
            List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage)).collect(Collectors.toList());
            List<Car> sortByDomination = cars.stream().sorted(Comparator.comparing(Car::getDominationCount)).collect(Collectors.toList());

            System.out.println("\n Sorted by Price \n");
            sortByPrice.forEach((Car car) -> System.out.println( car.getMake() + ", "+car.getModel() + ": " + car.getPrice()));


            System.out.println("\n Sorted by Year \n");
            sortByYear.forEach((Car car) -> System.out.println( car.getMake() + ", "+car.getModel() + ": " + car.getYear()));

            
            System.out.println("\n Sorted by Mileage \n");
            sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + ", "+car.getModel() + ": " + car.getMileage()));

           
            System.out.println("\n   Sorted by Domination \n");
            sortByDomination.forEach((Car car) -> System.out.println(car.getMake() + ", "+car.getModel() + ": "+ car.getDominationCount()));

        }
    }

