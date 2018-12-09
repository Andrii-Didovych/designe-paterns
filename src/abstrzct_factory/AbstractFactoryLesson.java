package abstrzct_factory;

public class AbstractFactoryLesson {
    public static void main(String[] args) {
        Factory tankFactory = new AbstractFactory().createFactory("tank");
        Factory carFactory = new AbstractFactory().createFactory("car");
        Vehicle tank = tankFactory.createVehicle("T-52");
        Vehicle car = carFactory.createVehicle("Audy");
        tank.drive();
        car.drive();
    }
}

interface Vehicle {
    void drive();
}

class Toyota implements Vehicle {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class Audy implements Vehicle {
    @Override
    public void drive() {
        System.out.println("drive Audy");
    }
}

class T51 implements Vehicle {
    @Override
    public void drive() {
        System.out.println("drive T-51");
    }
}

class T52 implements Vehicle {
    @Override
    public void drive() {
        System.out.println("drive T-52");
    }
}

interface Factory {
    Vehicle createVehicle(String s);
}

class CarFactory implements Factory{
    public Vehicle createVehicle(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota":
                return new Toyota();
            case "Audy" :
                return new Audy();
            default:
                return null;
        }
    }

}

class TankFactory implements Factory{
    public Vehicle createVehicle(String typeOfTank) {
        switch (typeOfTank) {
            case "T-51":
                return new T51();
            case "T-52" :
                return new T52();
            default:
                return null;
        }
    }
}

class AbstractFactory {
    public Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "car":
                return new CarFactory();
            case "tank" :
                return new TankFactory();
            default:
                return null;
        }
    }
}