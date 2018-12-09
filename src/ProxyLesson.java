public class ProxyLesson {
    public static void main(String[] args) {
        ProxyHonda proxyHonda = new ProxyHonda();
        proxyHonda.drive();
    }
}

interface Vehicle{
    void drive();
}

class Honda implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Honda class");
    }
}

class ProxyHonda implements Vehicle {

    Vehicle honda =  new Honda();
    @Override
    public void drive() {
        System.out.println("Method from proxy!");
        honda.drive();
    }
}
