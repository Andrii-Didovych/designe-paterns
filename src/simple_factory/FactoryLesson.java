package simple_factory;

public class FactoryLesson {
    public static void main(String[] args) {

        Factory factory = new Factory();
        Car audy = factory.create("simple_factory.Audy");
        Car toyota = factory.create("simple_factory.Toyota");
        audy.drive();
        toyota.drive();
    }
}


interface Car {
    void drive();
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive simple_factory.Toyota");
    }
}

class Audy implements Car {
    @Override
    public void drive() {
        System.out.println("drive simple_factory.Audy");
    }
}

class Factory {
    public Car create(String typeOfCar) {
        switch (typeOfCar) {
            case "simple_factory.Toyota":
                return new Toyota();
            case "simple_factory.Audy" :
                return new Audy();
                default:
                    return null;
        }
    }
}
