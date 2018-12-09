package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverLesson {
    public static void main(String[] args) {
        Observer2 john = new Observer2("John");
        Observer2 fill = new Observer2("fill");
        Observer2 bill = new Observer2("bill");

        john.setMessage("Hello!!");
        fill.setMessage("Hi!");
        bill.setMessage("Greeting!");

    }
}

class Observer2 {
    private static List<Observer2
            > observers = new ArrayList<>();
    private String name;
    private String message;

    public Observer2(String name) {
        this.name = name;
        observers.add(this);
    }

    void setMessage(String msg) {
        this.message = msg;
        notifyAllObserver();
    }

    private void notifyAllObserver() {
        for (Observer2 observer : observers) {
            observer.update();
        }
    }

    private void update() {
        if (message!=null){
            System.out.println(name + " changed message " + message);
        }
    }
}