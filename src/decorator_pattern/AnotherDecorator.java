package decorator_pattern;

public class AnotherDecorator {
    public static void main(String[] args) {
        Car car = new SportCar(new LuxuryCar(new BasicCar()));
        car.assemble();
    }
}

interface Car {
    void assemble();
}

class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic car");
    }
}

class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}

class SportCar extends CarDecorator {

    public SportCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of sport car");
    }
}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("adding features of luxury car");
    }
}
