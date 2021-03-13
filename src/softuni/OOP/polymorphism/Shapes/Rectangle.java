package softuni.OOP.polymorphism.Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double perimeter, double area, double height, double width) {
        super(perimeter, area);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculatePerimeter() {
        return height * 2 + width * 2;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }
}
