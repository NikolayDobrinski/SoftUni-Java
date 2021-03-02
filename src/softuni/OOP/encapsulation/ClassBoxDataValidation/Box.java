package softuni.OOP.encapsulation.ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isPositiveOrBiggerThanZero(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (isPositiveOrBiggerThanZero(width)) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (isPositiveOrBiggerThanZero(height)) {
            this.height = height;
        }
    }

    private boolean isPositiveOrBiggerThanZero(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        return true;
    }

    public double calculateSurfaceArea() {
        return (this.height * this.width) * 2 + (this.height * this.length) * 2 + (this.width * this.length) * 2;
    }

    public double calculateLateralSurfaceArea() {
        return (this.height * this.width) * 2 + (this.height * this.length) * 2;
    }

    public double calculateVolume() {
        return this.width * this.length * this.height;
    }
}
