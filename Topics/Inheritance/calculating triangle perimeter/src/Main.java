import java.util.Scanner;

public class Main {

    // Base class Polygon
    static class Polygon {
        private int sideLength;

        // Method to set the length of sides
        public void setSideLength(int sideLength) {
            this.sideLength = sideLength;
        }

        // Method to get the length of sides
        public int getSideLength() {
            return sideLength;
        }
    }

    // Derived class Square
    public static class Square extends Polygon {
        public void area(int sideLength) { System.out.println(sideLength * sideLength); }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sideLength = scanner.nextInt();

        // Create an instance of Square
        Square kwadrat = new Square();

        // Set the side length
        kwadrat.setSideLength(sideLength);

        // Calculate and print the area
        kwadrat.area(sideLength);
    }
}