public class AdapterLesson {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audy());
        carWash.washCar(new TrackWash(new Man()));
    }
}

interface Car {
    void wash();
}

interface Track {
    void clean();
}

class Man implements Track {
    @Override
    public void clean() {
        System.out.println("Man is clean");
    }
}

class TrackWash implements Car {
    public Track track;

    public TrackWash(Track track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}

class Audy implements Car {
    @Override
    public void wash() {
        System.out.println("Car is clean");
    }
}

class CarWash {
    public void washCar(Car car) {
        car.wash();
    }
}
