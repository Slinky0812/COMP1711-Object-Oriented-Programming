public class Circle {
    private double radius;

    public Circle() {
        this(1);
    }

    public Circle(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Invalid radius");
        }
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

    @Override
    public String toString() {
        return String.format("Circle(radius=%.4f)", radius);
    }

    @Override
    public boolean equals(Object other) {
        Circle object = (Circle) other;
        if ((this.getRadius() - object.getRadius()) < 0.00005 && (this.getRadius() - object.getRadius()) > -0.00005) {
            return true;
        } else {
            return false;
        }
    }
 }
