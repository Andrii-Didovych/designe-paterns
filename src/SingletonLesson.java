public class SingletonLesson {
    public static void main(String[] args) {
        Singleton.getInstance();

    }
}

class Singleton {

    static private Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}