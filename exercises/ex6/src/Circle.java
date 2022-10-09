public class Circle {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        double area;
        area = Math.PI * (Math.pow(radius, 2));
        return area;
    }

    public double perimeter() {
        double perimeter;
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}
