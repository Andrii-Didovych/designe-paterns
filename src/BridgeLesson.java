public class BridgeLesson {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new GreenColor());
        triangle.applyColor();

        Pentagon pentagon = new Pentagon(new RedColor());
        pentagon.applyColor();
    }
}

interface Color {
    void getColor();
}

abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}

class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.println("Triangle has color");
        color.getColor();
    }
}

class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.println("Pentagon has color");
        color.getColor();
    }
}

class RedColor implements Color {
    @Override
    public void getColor() {
        System.out.println("red");
    }
}

class GreenColor implements Color {
    @Override
    public void getColor() {
        System.out.println("green");
    }
}
