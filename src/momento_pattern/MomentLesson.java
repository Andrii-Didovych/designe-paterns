package momento_pattern;

public class MomentLesson {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("One");
        CareTaker careTaker = new CareTaker();
        careTaker.setMoment(originator.createMoment());
        originator.setState("two");
        System.out.println(originator.getState());
        originator.getDataFromMoment(careTaker.getMoment());
        System.out.println(originator.getState());
    }
}

class CareTaker {
    Moment moment;

    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }
}

class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Moment createMoment() {
        return new Moment(state);
    }

    public void getDataFromMoment(Moment moment) {
        this.state = moment.getState();
    }

}

class Moment {
    private String state;

    public Moment(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
