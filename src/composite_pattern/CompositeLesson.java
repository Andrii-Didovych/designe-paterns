package composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeLesson {
    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        Circle circle = new Circle();
        triangle.draw("Red");
        circle.draw("Black");

        Drawing drawing = new Drawing();
        drawing.add(circle);
        drawing.add(triangle);
        drawing.remove(triangle);
        drawing.draw("Red");
        drawing.clear();


    }
}

interface Shape {
    void draw(String color);
}

class Circle implements Shape {
    @Override
    public void draw(String color) {
        System.out.println("Color of circle is - "+color);
    }
}

class Triangle implements Shape {

    @Override
    public void draw(String color) {
        System.out.println("Color of triangle is - "+color);
    }
}

class Drawing implements Shape{
    List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String color) {
        for (Shape shape: shapes) {
            shape.draw(color);
        }
    }

    void add(Shape shape) {
        shapes.add(shape);
    }

    void remove(Shape shape) {
        shapes.remove(shape);
    }

    void clear() {
        System.out.println("Clearing all shapes from drawing");
        this.shapes.clear();
    }
}