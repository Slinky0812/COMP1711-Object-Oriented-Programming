import java.io.IOException;
import java.io.Writer;

public class Circle implements Writeable{
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

    @Override
    public void writeTo(Writer destination) throws IOException {
        String phrase = String.format("Circle: r=%.4f\n", getRadius());
        destination.write(phrase);
        destination.close();
    }
}