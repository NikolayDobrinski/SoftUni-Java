package softuni.fundamentals.methodslab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        double area = getRectangleArea(width, height);
        System.out.printf("%.0f", area);

    }

    private static double getRectangleArea(double a, double b) {
        return a * b;
    }
}
