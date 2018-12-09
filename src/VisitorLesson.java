public class VisitorLesson {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        VisitorImpl visitor = new VisitorImpl();
        cat.doJob(visitor);
        dog.doJob(visitor);
    }
}

interface Animal {
    void doJob(Visitor visitor);
}

class Cat implements Animal {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doCat();
    }
}

class Dog implements Animal {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doDog();
    }
}

interface Visitor {
    void doCat();
    void doDog();
}

class VisitorImpl implements Visitor {
    @Override
    public void doCat() {
        System.out.println("May!");
    }
    @Override
    public void doDog() {
        System.out.println("Hav!");
    }
}