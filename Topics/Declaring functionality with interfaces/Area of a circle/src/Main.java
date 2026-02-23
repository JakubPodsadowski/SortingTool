class Circle implements Measurable{
    private double radius;

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}

// do not change the interface
interface Measurable {
    double area();
}