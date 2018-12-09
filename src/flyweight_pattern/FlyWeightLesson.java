package flyweight_pattern;

import java.util.ArrayList;
import java.util.List;

public class FlyWeightLesson {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car = garage.getCar("bmv", "black");
        Car car1 = garage.getCar("bmv", "black");
        System.out.println(car);
        System.out.println(car1);
    }
}

class Car{
    String brand;
    String color;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }
}

class Garage{

    List<Car> cars = new ArrayList<>();

    Car getCar(String brand, String color) {
        if (!cars.isEmpty()){
            for (Car car: cars) {
                if(car.brand.equals(brand)
                        &&car.color.equals(color)) return car;
            }
        }
        Car car = new Car(brand, color);
        cars.add(car);
        return car;
    }
}