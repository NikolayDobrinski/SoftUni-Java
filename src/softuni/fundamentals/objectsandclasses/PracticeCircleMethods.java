package softuni.fundamentals.objectsandclasses;

public class PracticeCircleMethods {
    static class Circle {
        double radius;

        double getArea() {
            return radius * radius * Math.PI;
        }

        void scale(double factor) {
            radius *= factor;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 5;
        c1.setRadius(10);

        System.out.println(c1.getArea());

        Circle c2 = new Circle();
        c2.radius = 10;
        c2.scale(2);

        System.out.println(c2.getArea());


    }
}
