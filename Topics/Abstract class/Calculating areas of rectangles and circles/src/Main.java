import java.util.Scanner;

// Define the abstract Shape class with an abstract area() method
abstract class Shape {
    abstract double area(double width, double height);
    abstract double area(double radius);
}

// Implement the Rectangle class that extends Shape
class Rectangle extends Shape {
    @Override
    double area(double length, double width) {
        return length * width;
    }

    @Override
    double area(double radius) {
        return 0;
    }
}

// Implement the Circle class that extends Shape
class Circle extends Shape {
    @Override
    double area(double width, double height) {
        return 0;
    }

    @Override
    double area(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the dimensions of the rectangle
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        // Read the radius of the circle
        double radius = scanner.nextDouble();

        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        // Calculate and print the area of the rectangle
        System.out.println(rectangle.area(length, width));
        System.out.println(circle.area(radius));

        // Calculate and print the area of the circle


        scanner.close();
    }
}