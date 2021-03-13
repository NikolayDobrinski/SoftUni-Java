package softuni.OOP.polymorphism.Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double perimeter, double area, double radius) {
        super(perimeter, area);
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
